package br.com.portoseguro.repositories;

import br.com.portoseguro.models.TowTruckAvailability;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class TowTruckAvailabilityRepository extends BaseRepository implements IRepository<TowTruckAvailability> {

    @Override
    public List<TowTruckAvailability> getAll() throws Exception {
        List<TowTruckAvailability> towTruckAvailabilities = new ArrayList<>();

        String query = """
            SELECT
                T.ID_GUINCHO AS id,
                T.NR_PLACA AS plateNumber,
                T.NM_USUARIO AS userName,
                T.ST_DISPONIBILIDADE AS availabilityStatus,
                T.DT_CADASTRO AS registrationDate,
                T.CP_CARGA AS cargaPeso
            FROM
                T_PTSG_GUINCHO T
            ORDER BY T.ID_GUINCHO
        """;

        try (Connection connection = getConnection();
             PreparedStatement ps = connection.prepareStatement(query)) {
            ResultSet results = ps.executeQuery();

            while (results.next()) {
                towTruckAvailabilities.add(new TowTruckAvailability(
                        results.getInt("id"),
                        results.getString("plateNumber"),
                        results.getString("userName"),
                        results.getString("availabilityStatus"),
                        results.getDate("registrationDate"),
                        results.getDouble("cargaPeso")
                ));
            }

            return towTruckAvailabilities;
        }
    }

    @Override
    public TowTruckAvailability getById(int id) throws Exception {
        TowTruckAvailability towTruckAvailability = new TowTruckAvailability();

        String query = """
            SELECT
                T.ID_GUINCHO AS id,
                T.NR_PLACA AS plateNumber,
                T.NM_USUARIO AS userName,
                T.ST_DISPONIBILIDADE AS availabilityStatus,
                T.DT_CADASTRO AS registrationDate,
                T.CP_CARGA AS cargaPeso
            FROM
                T_PTSG_GUINCHO T
            WHERE T.ID_GUINCHO = ?
        """;

        try (Connection connection = getConnection();
             PreparedStatement ps = connection.prepareStatement(query)) {
            ps.setInt(1, id);

            ResultSet result = ps.executeQuery();

            if (result.next()) {
                towTruckAvailability = new TowTruckAvailability(
                        result.getInt("id"),
                        result.getString("plateNumber"),
                        result.getString("userName"),
                        result.getString("availabilityStatus"),
                        result.getDate("registrationDate"),
                        result.getDouble("cargaPeso")
                );
            }

            return towTruckAvailability;
        }
    }

    @Override
    public void save(TowTruckAvailability towTruckAvailability) throws SQLException {
        String query = """
            INSERT INTO T_PTSG_GUINCHO (
                ID_GUINCHO,
                ST_DISPONIBILIDADE,
                NR_PLACA,
                NM_USUARIO,
                DT_CADASTRO,
                CP_CARGA
            ) VALUES (
                SEQ_GUINCHO_PTSG.NEXTVAL,
                ?,
                ?,
                ?,
                TO_DATE('11/11/23', 'DD/MM/RR'),
                ?
            )
        """;

        try (Connection connection = getConnection();
             PreparedStatement ps = connection.prepareStatement(query)) {

            setTowTruckAvailabilityStatement(towTruckAvailability, ps);

            ps.executeUpdate();
        } catch (Exception e) {
            throw new SQLException(e);
        }
    }

    @Override
    public TowTruckAvailability update(int id, TowTruckAvailability towTruckAvailability) throws Exception {
        TowTruckAvailability updatedTowTruckAvailability;

        String query = """
            UPDATE T_PTSG_GUINCHO
            SET ST_DISPONIBILIDADE = ?,
                NR_PLACA = ?,
                NM_USUARIO = ?,
                CP_CARGA = ?
            WHERE ID_GUINCHO = ?
        """;

        try (Connection connection = getConnection();
             PreparedStatement ps = connection.prepareStatement(query)) {

            setTowTruckAvailabilityStatement(towTruckAvailability, ps);

            ps.setInt(5, id);
            ps.executeUpdate();

            updatedTowTruckAvailability = getById(id);
        }

        return updatedTowTruckAvailability;
    }

    private void setTowTruckAvailabilityStatement(TowTruckAvailability towTruckAvailability, PreparedStatement ps) throws SQLException {
        ps.setString(1, towTruckAvailability.getAvailabilityStatus());
        ps.setString(2, towTruckAvailability.getPlateNumber());
        ps.setString(3, towTruckAvailability.getUserName());
        ps.setDouble(4, towTruckAvailability.getCargoCapacity());
    }

    @Override
    public void delete(int id) throws Exception {
        String query = "DELETE FROM T_PTSG_GUINCHO WHERE ID_GUINCHO = ?";

        try (Connection connection = getConnection();
             PreparedStatement ps = connection.prepareStatement(query)) {

            ps.setInt(1, id);
            ps.executeUpdate();
        }
    }
}
