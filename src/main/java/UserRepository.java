import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class UserRepository {

    private final jdbcConnection jdbcConnection = new jdbcConnection();

    public UserRepository() throws SQLException {
    }

    public int registerUser(User user) throws SQLException {
        Connection connection = jdbcConnection.getConnection();

        String addUser = "INSERT INTO users(first_name, last_name, username, password) VALUES (?, ?, ?, ?)";
        PreparedStatement preparedStatement = connection.prepareStatement(addUser);

        preparedStatement.setString(1, user.getFirstName());
        preparedStatement.setString(2, user.getLastNAme());
        preparedStatement.setString(3, user.getUsername());
        preparedStatement.setString(4, user.getPassword());

        int result = preparedStatement.executeUpdate();
        return result;

    }

    public User findByUsername(String username) throws SQLException {
        Connection connection = jdbcConnection.getConnection();

        String findUser = "SELECT * FROM users WHERE username = ?";
        PreparedStatement preparedStatement = connection.prepareStatement(findUser);
        preparedStatement.setString(1, username);
        ResultSet resultSet = preparedStatement.executeQuery();
        if (resultSet.next()) {
            int id = resultSet.getInt("id");
            String firstname = resultSet.getString("first_name");
            String lastname = resultSet.getString("last_name");
            String fetchUsername = resultSet.getString("username");
            String password = resultSet.getString("password");
            User user = new User(firstname, lastname, fetchUsername, password);
            return user;
        } else
            return null;


    }
}
