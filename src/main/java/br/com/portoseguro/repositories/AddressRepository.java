package br.com.portoseguro.repositories;

import br.com.portoseguro.models.Address;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class AddressRepository extends BaseRepository implements IRepository<Address> {

    @Override
    public List<Address> getAll() throws Exception {
        List<Address> addresses = new ArrayList<>();

        String query = """
            SELECT
                A.ID_END_CLIENTE AS id,
                A.NR_LOGRADOURO AS logradouroNumber,
                A.NM_USUARIO AS userName,
                A.ID_LOGRADOURO AS logradouroId,
                A.ID_CLIENTE AS clientId,
                A.DT_INICIO AS startDate,
                A.DT_FIM AS endDate,
                A.DT_CADASTRO AS registrationDate,
                A.DS_PONTO_REFERENCIA AS pontoReferencia,
                A.DS_COMPLEMENTO_NUMERO AS complementoNumero
            FROM
                T_PTSG_ENDERECO_CLIENTE A
            ORDER BY A.ID_END_CLIENTE
        """;

        try (Connection connection = getConnection();
             PreparedStatement ps = connection.prepareStatement(query)) {
            ResultSet results = ps.executeQuery();

            while (results.next()) {
                addresses.add(new Address(
                        results.getInt("id"),
                        results.getLong("logradouroNumber"),
                        results.getString("userName"),
                        results.getLong("logradouroId"),
                        results.getLong("clientId"),
                        results.getDate("startDate"),
                        results.getDate("endDate"),
                        results.getDate("registrationDate"),
                        results.getString("pontoReferencia"),
                        results.getString("complementoNumero")
                ));
            }

            return addresses;
        }
    }

    @Override
    public Address getById(int id) throws Exception {
        Address address = new Address();

        String query = """
            SELECT
                A.ID_END_CLIENTE AS id,
                A.NR_LOGRADOURO AS logradouroNumber,
                A.NM_USUARIO AS userName,
                A.ID_LOGRADOURO AS logradouroId,
                A.ID_CLIENTE AS clientId,
                A.DT_INICIO AS startDate,
                A.DT_FIM AS endDate,
                A.DT_CADASTRO AS registrationDate,
                A.DS_PONTO_REFERENCIA AS pontoReferencia,
                A.DS_COMPLEMENTO_NUMERO AS complementoNumero
            FROM
                T_PTSG_ENDERECO_CLIENTE A
            WHERE A.ID_END_CLIENTE = ?
        """;

        try (Connection connection = getConnection();
             PreparedStatement ps = connection.prepareStatement(query)) {
            ps.setInt(1, id);

            ResultSet result = ps.executeQuery();

            if (result.next()) {
                address = new Address(
                        result.getInt("id"),
                        result.getLong("logradouroNumber"),
                        result.getString("userName"),
                        result.getLong("logradouroId"),
                        result.getLong("clientId"),
                        result.getDate("startDate"),
                        result.getDate("endDate"),
                        result.getDate("registrationDate"),
                        result.getString("pontoReferencia"),
                        result.getString("complementoNumero")
                );
            }

            return address;
        }
    }

    @Override
    public void save(Address address) throws SQLException {
        String query = """
            INSERT INTO T_PTSG_ENDERECO_CLIENTE (
                ID_END_CLIENTE,
                NR_LOGRADOURO,
                NM_USUARIO,
                ID_LOGRADOURO,
                ID_CLIENTE,
                DT_INICIO,
                DT_FIM,
                DT_CADASTRO,
                DS_PONTO_REFERENCIA,
                DS_COMPLEMENTO_NUMERO
            ) VALUES (
                SEQ_ENDERECO_PTSG.NEXTVAL,
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
            setAddressStatement(address, ps);

            ps.executeUpdate();
        } catch (Exception e) {
            throw new SQLException(e);
        }
    }

    @Override
    public Address update(int id, Address address) throws Exception {
        Address updatedAddress;

        String query = """
            UPDATE T_PTSG_ENDERECO_CLIENTE
            SET NR_LOGRADOURO = ?,
                NM_USUARIO = ?,
                ID_LOGRADOURO = ?,
                ID_CLIENTE = ?,
                DT_INICIO = ?,
                DT_FIM = ?,
                DT_CADASTRO = ?,
                DS_PONTO_REFERENCIA = ?,
                DS_COMPLEMENTO_NUMERO = ?
            WHERE ID_END_CLIENTE = ?
        """;

        try (Connection connection = getConnection();
             PreparedStatement ps = connection.prepareStatement(query)) {
            setAddressStatement(address, ps);

            ps.setInt(10, id);
            ps.executeUpdate();

            updatedAddress = getById(id);

            System.out.println(updatedAddress.getId());
        }

        return updatedAddress;
    }

    private void setAddressStatement(Address address, PreparedStatement ps) throws SQLException {
        ps.setLong(1, address.getLogradouroNumber());
        ps.setString(2, address.getUserName());
        ps.setLong(3, address.getLogradouroId());
        ps.setLong(4, address.getClientId());
        ps.setDate(5, new java.sql.Date(address.getStartDate().getTime()));
        ps.setDate(6, new java.sql.Date(address.getEndDate().getTime()));
        ps.setDate(7, new java.sql.Date(address.getRegistrationDate().getTime()));
        ps.setString(8, address.getPontoReferencia());
        ps.setString(9, address.getComplementoNumero());
    }

    @Override
    public void delete(int id) throws Exception {
        String query = "DELETE FROM T_PTSG_ENDERECO_CLIENTE WHERE ID_END_CLIENTE = ?";

        try (Connection connection = getConnection();
             PreparedStatement ps = connection.prepareStatement(query)) {
            ps.setInt(1, id);
            ps.executeUpdate();
        }
    }
}
