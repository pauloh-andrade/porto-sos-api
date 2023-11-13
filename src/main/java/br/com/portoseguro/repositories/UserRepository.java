package br.com.portoseguro.repositories;

import br.com.portoseguro.models.User;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

public class UserRepository extends BaseRepository implements IRepository<User> {


    @Override
    public List<User> getAll() throws Exception {
        return null;
    }

    @Override
    public User getById(int id) throws Exception {
        return null;
    }

    public User getByPhoneNumber(String phoneNumber) throws Exception {
        String query = """
            SELECT
                C.NR_TELEFONE AS phoneNumber,
                C.SH_CLIENTE AS password
            FROM T_PTSG_CLIENTE C WHERE NR_TELEFONE = ?
            """;
        try (Connection connection = getConnection();
             PreparedStatement ps = connection.prepareStatement(query)) {

            ps.setString(1, phoneNumber);

            try (ResultSet rs = ps.executeQuery()) {
                User user = new User();

                if (rs.next()) {
                    user.setPhoneNumber(rs.getString("phoneNumber"));
                    user.setPassword(rs.getString("password"));
                }

                return user;
            }
        }
    }

    @Override
    public void save(User item) throws Exception {

    }

    @Override
    public User update(int id, User item) throws Exception {
        return null;
    }

    @Override
    public void delete(int id) throws Exception {

    }
}
