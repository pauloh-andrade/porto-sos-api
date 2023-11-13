package br.com.portoseguro.repositories;

import br.com.portoseguro.models.Client;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ClientRepository extends BaseRepository implements IRepository<Client> {


    @Override
    public List<Client> getAll() throws Exception {
        List<Client> clients = new ArrayList<>();


        String query = """
            SELECT
                C.ID_CLIENTE AS id,
                C.SH_CLIENTE AS password,
                C.RG_CLIENTE AS rg,
                C.NR_TELEFONE AS phoneNumber,
                C.LG_CLIENTE AS name,
                C.DS_EMAIL AS emailAddress,
                C.CPF_CLIENTE AS cpf
            FROM
                T_PTSG_CLIENTE C
            ORDER BY C.ID_CLIENTE
        """;

        try (Connection connection = getConnection();
             PreparedStatement ps = connection.prepareStatement(query))
        {
            ResultSet results = ps.executeQuery();

            while(results.next()) {
                clients.add(new Client(
                        results.getInt("id"),
                        results.getString("name"),
                        results.getString("phoneNumber"),
                        results.getString("emailAddress"),
                        results.getString("password"),
                        results.getString("cpf"),
                        results.getString("rg")
                        ));
            }

            return clients;
        }
    }

    @Override
    public Client getById(int id) throws Exception {
        Client client = new Client();

        String query = """
            SELECT
                C.ID_CLIENTE AS id,
                C.SH_CLIENTE AS password,
                C.RG_CLIENTE AS rg,
                C.NR_TELEFONE AS phoneNumber,
                C.LG_CLIENTE AS name,
                C.DS_EMAIL AS emailAddress,
                C.CPF_CLIENTE AS cpf
            FROM
                T_PTSG_CLIENTE C
            WHERE C.ID_CLIENTE = ?
        """;

        try (Connection connection = getConnection();
             PreparedStatement ps = connection.prepareStatement(query))
        {
            ps.setInt(1, id);

            ResultSet result = ps.executeQuery();

            if (result.next()) {
                client = new Client(
                        result.getInt("id"),
                        result.getString("name"),
                        result.getString("phoneNumber"),
                        result.getString("emailAddress"),
                        result.getString("password"),
                        result.getString("cpf"),
                        result.getString("rg")
                );
            }

            return client;
        }
    }

    @Override
    public void save(Client client) throws SQLException {
        String query = """
                INSERT INTO T_PTSG_CLIENTE (
                    ID_CLIENTE,
                    ST_CLIENTE,
                    SH_CLIENTE,
                    RG_CLIENTE,
                    NR_TELEFONE,
                    NM_USUARIO,
                    LG_CLIENTE,
                    DS_EMAIL,
                    CPF_CLIENTE,
                    DT_INICIO,
                    DT_FIM
                ) VALUES (
                    SEQ_CLIENTE_PTSG.NEXTVAL,
                    'A',
                    ?,
                    ?,
                    ?,
                    'ADMIN',
                    ?,
                    ?,
                    ?,
                    TO_DATE('11/11/23', 'DD/MM/RR'),
                    null
                )
                """;

        try (Connection connection = getConnection();
             PreparedStatement ps = connection.prepareStatement(query)) {

            setClientStatement(client, ps);


            ps.executeUpdate();
        } catch (Exception e) {
            throw new SQLException(e);
        }
    }

    @Override
    public Client update(int id, Client client) throws Exception {
        Client updatedClient;

        String query = """
                UPDATE T_PTSG_CLIENTE
                SET SH_CLIENTE = ?,
                    RG_CLIENTE = ?,
                    NR_TELEFONE = ?,
                    LG_CLIENTE = ?,
                    DS_EMAIL = ?,
                    CPF_CLIENTE = ?
                WHERE ID_CLIENTE = ?
                """;

        try (Connection connection = getConnection();
             PreparedStatement ps = connection.prepareStatement(query)) {

            setClientStatement(client, ps);

            ps.setInt(7, id);
            ps.executeUpdate();

            updatedClient = getById(id);

            System.out.println(updatedClient.getId());
        }

        return updatedClient;
    }

    private void setClientStatement(Client client, PreparedStatement ps) throws SQLException {
        ps.setString(1, client.getPassword());
        ps.setString(2, client.getRg());
        ps.setString(3, client.getPhoneNumber());
        ps.setString(4, client.getName());
        ps.setString(5, client.getEmailAddress());
        ps.setString(6, client.getCpf());
    }

    @Override
    public void delete(int id) throws Exception {
        String query = "DELETE FROM T_PTSG_CLIENTE WHERE ID_CLIENTE = ?";

        try (Connection connection = getConnection();
             PreparedStatement ps = connection.prepareStatement(query)) {

            ps.setInt(1, id);
            ps.executeUpdate();
        }
    }
}
