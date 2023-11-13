package br.com.portoseguro.repositories;

import br.com.portoseguro.models.TowTruckOperator;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class TowTruckOperatorRepository extends BaseRepository implements IRepository<TowTruckOperator> {

    @Override
    public List<TowTruckOperator> getAll() throws Exception {
        List<TowTruckOperator> towTruckOperators = new ArrayList<>();

        String query = """
            SELECT
                M.ID_MOTORISTA AS id,
                M.NM_MOTORISTA AS name,
                M.NR_TELEFONE AS phoneNumber,
                M.ST_MOTORISTA AS availabilityStatus
            FROM
                T_PTSG_MOTORISTA M
            ORDER BY M.ID_MOTORISTA
        """;

        try (Connection connection = getConnection();
             PreparedStatement ps = connection.prepareStatement(query)) {
            ResultSet results = ps.executeQuery();

            while (results.next()) {
                towTruckOperators.add(new TowTruckOperator(
                        results.getInt("id"),
                        results.getString("name"),
                        results.getLong("phoneNumber"),
                        results.getString("availabilityStatus")
                ));
            }

            return towTruckOperators;
        }
    }

    @Override
    public TowTruckOperator getById(int id) throws Exception {
        TowTruckOperator towTruckOperator = new TowTruckOperator();

        String query = """
            SELECT
                M.ID_MOTORISTA AS id,
                M.NM_MOTORISTA AS name,
                M.NR_TELEFONE AS phoneNumber,
                M.ST_MOTORISTA AS availabilityStatus
            FROM
                T_PTSG_MOTORISTA M
            WHERE M.ID_MOTORISTA = ?
        """;

        try (Connection connection = getConnection();
             PreparedStatement ps = connection.prepareStatement(query)) {
            ps.setInt(1, id);

            ResultSet result = ps.executeQuery();

            if (result.next()) {
                towTruckOperator = new TowTruckOperator(
                        result.getInt("id"),
                        result.getString("name"),
                        result.getLong("phoneNumber"),
                        result.getString("availabilityStatus")
                );
            }

            return towTruckOperator;
        }
    }

    @Override
    public void save(TowTruckOperator towTruckOperator) throws SQLException {
        String query = """
            INSERT INTO T_PTSG_MOTORISTA (
                ID_MOTORISTA,
                ST_MOTORISTA,
                NM_MOTORISTA,
                NR_TELEFONE,
                DT_CADASTRO
            ) VALUES (
                SEQ_MOTORISTA_PTSG.NEXTVAL,
                ?,
                ?,
                ?,
                SYSDATE
            )
        """;

        try (Connection connection = getConnection();
             PreparedStatement ps = connection.prepareStatement(query)) {

            setTowTruckOperatorStatement(towTruckOperator, ps);

            ps.executeUpdate();
        } catch (Exception e) {
            throw new SQLException(e);
        }
    }

    @Override
    public TowTruckOperator update(int id, TowTruckOperator towTruckOperator) throws Exception {
        TowTruckOperator updatedTowTruckOperator;

        String query = """
            UPDATE T_PTSG_MOTORISTA
            SET ST_MOTORISTA = ?,
                NM_MOTORISTA = ?,
                NR_TELEFONE = ?
            WHERE ID_MOTORISTA = ?
        """;

        try (Connection connection = getConnection();
             PreparedStatement ps = connection.prepareStatement(query)) {

            setTowTruckOperatorStatement(towTruckOperator, ps);

            ps.setInt(4, id);
            ps.executeUpdate();

            updatedTowTruckOperator = getById(id);
        }

        return updatedTowTruckOperator;
    }

    private void setTowTruckOperatorStatement(TowTruckOperator towTruckOperator, PreparedStatement ps) throws SQLException {
        ps.setString(1, towTruckOperator.getDriverStatus());
        ps.setString(2, towTruckOperator.getDriverName());
        ps.setLong(3, towTruckOperator.getPhoneNumber());
    }

    @Override
    public void delete(int id) throws Exception {
        String query = "DELETE FROM T_PTSG_MOTORISTA WHERE ID_MOTORISTA = ?";

        try (Connection connection = getConnection();
             PreparedStatement ps = connection.prepareStatement(query)) {

            ps.setInt(1, id);
            ps.executeUpdate();
        }
    }
}
