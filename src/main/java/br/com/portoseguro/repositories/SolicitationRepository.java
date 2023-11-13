package br.com.portoseguro.repositories;

import br.com.portoseguro.models.Solicitation;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class SolicitationRepository extends BaseRepository implements IRepository<Solicitation> {

    @Override
    public List<Solicitation> getAll() throws Exception {
        List<Solicitation> solicitations = new ArrayList<>();

        String query = """
            SELECT
                S.ST_SOLICITACAO AS solicitationStatus,
                S.NM_USUARIO AS userName,
                S.ID_SOLICITACAO AS solicitationId,
                S.ID_MOTORISTA AS driverId,
                S.ID_GUINCHO AS towTruckId,
                S.ID_CLIENTE AS clientId,
                S.ID_APOLICE AS policyId,
                S.DT_INICIO AS startDate,
                S.DT_FIM AS endDate,
                S.DT_CADASTRO AS registrationDate,
                S.DS_MOTIVO AS reason
            FROM
                T_PTSG_SOLICITACAO_GUINCHO S
            ORDER BY S.ID_SOLICITACAO
        """;

        try (Connection connection = getConnection();
             PreparedStatement ps = connection.prepareStatement(query)) {
            ResultSet results = ps.executeQuery();

            while (results.next()) {
                solicitations.add(mapResultSetToSolicitation(results));
            }

            return solicitations;
        }
    }

    @Override
    public Solicitation getById(int id) throws Exception {
        Solicitation solicitation = new Solicitation();

        String query = """
            SELECT
                S.ST_SOLICITACAO AS solicitationStatus,
                S.NM_USUARIO AS userName,
                S.ID_SOLICITACAO AS solicitationId,
                S.ID_MOTORISTA AS driverId,
                S.ID_GUINCHO AS towTruckId,
                S.ID_CLIENTE AS clientId,
                S.ID_APOLICE AS policyId,
                S.DT_INICIO AS startDate,
                S.DT_FIM AS endDate,
                S.DT_CADASTRO AS registrationDate,
                S.DS_MOTIVO AS reason
            FROM
                T_PTSG_SOLICITACAO_GUINCHO S
            WHERE S.ID_SOLICITACAO = ?
        """;

        try (Connection connection = getConnection();
             PreparedStatement ps = connection.prepareStatement(query)) {
            ps.setInt(1, id);

            ResultSet result = ps.executeQuery();

            if (result.next()) {
                solicitation = mapResultSetToSolicitation(result);
            }

            return solicitation;
        }
    }

    @Override
    public void save(Solicitation solicitation) throws Exception {
        String query = """
            INSERT INTO T_SUA_TABELA (
                ST_SOLICITACAO,
                NM_USUARIO,
                ID_SOLICITACAO,
                ID_MOTORISTA,
                ID_GUINCHO,
                ID_CLIENTE,
                ID_APOLICE,
                DT_INICIO,
                DT_FIM,
                DT_CADASTRO,
                DS_MOTIVO
            ) VALUES (
                ?,
                ?,
                ?,
                ?,
                ?,
                ?,
                ?,
                ?,
                ?,
                ?,
                ?
            )
        """;

        try (Connection connection = getConnection();
             PreparedStatement ps = connection.prepareStatement(query)) {
            setSolicitationStatement(solicitation, ps);
            ps.executeUpdate();
        }
    }

    @Override
    public Solicitation update(int id, Solicitation solicitation) throws Exception {
        Solicitation updatedSolicitation;

        String query = """
            UPDATE T_PTSG_SOLICITACAO_GUINCHO
            SET ST_SOLICITACAO = ?,
                NM_USUARIO = ?,
                ID_MOTORISTA = ?,
                ID_GUINCHO = ?,
                ID_CLIENTE = ?,
                ID_APOLICE = ?,
                DT_INICIO = ?,
                DT_FIM = ?,
                DT_CADASTRO = ?,
                DS_MOTIVO = ?
            WHERE ID_SOLICITACAO = ?
        """;

        try (Connection connection = getConnection();
             PreparedStatement ps = connection.prepareStatement(query)) {
            setSolicitationStatement(solicitation, ps);
            ps.setInt(11, id);
            ps.executeUpdate();

            updatedSolicitation = getById(id);
        }

        return updatedSolicitation;
    }

    @Override
    public void delete(int id) throws Exception {
        String query = "DELETE FROM T_SUA_TABELA WHERE ID_SOLICITACAO = ?";

        try (Connection connection = getConnection();
             PreparedStatement ps = connection.prepareStatement(query)) {
            ps.setInt(1, id);
            ps.executeUpdate();
        }
    }

    private Solicitation mapResultSetToSolicitation(ResultSet results) throws SQLException {
        return new Solicitation(
                results.getString("solicitationStatus").charAt(0),
                results.getString("userName"),
                results.getLong("solicitationId"),
                results.getLong("driverId"),
                results.getLong("towTruckId"),
                results.getLong("clientId"),
                results.getLong("policyId"),
                results.getDate("startDate"),
                results.getDate("endDate"),
                results.getDate("registrationDate"),
                results.getString("reason")
        );
    }

    private void setSolicitationStatement(Solicitation solicitation, PreparedStatement ps) throws SQLException {
        ps.setString(1, String.valueOf(solicitation.getRequestStatus()));
        ps.setString(2, solicitation.getUserName());
        ps.setLong(3, solicitation.getSolicitationId());
        ps.setLong(4, solicitation.getDriverId());
        ps.setLong(5, solicitation.getTowTruckId());
        ps.setLong(6, solicitation.getClientId());
        ps.setLong(7, solicitation.getPolicyId());
        ps.setDate(8, new java.sql.Date(solicitation.getStartDate().getTime()));
        ps.setDate(9, new java.sql.Date(solicitation.getEndDate().getTime()));
        ps.setDate(10, new java.sql.Date(solicitation.getRegistrationDate().getTime()));
        ps.setString(11, solicitation.getReasonDescription());
    }
}
