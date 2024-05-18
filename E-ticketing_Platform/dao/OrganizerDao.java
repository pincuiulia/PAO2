package dao;

import daoServices.DatabaseConnection;
import model.Client;
import model.Organizer;

import java.sql.*;

public class OrganizerDao implements DaoInterface<Organizer> {

    private static OrganizerDao organizerDao;
    private Connection connection = DatabaseConnection.getConnection();

    private OrganizerDao() throws SQLException {}

    public static OrganizerDao getInstance() throws SQLException {
        if (organizerDao == null) {
            organizerDao = new OrganizerDao();
        }
        return organizerDao;
    }

    @Override
    public Organizer login(String username, String password) throws SQLException {
        String sql = "SELECT * FROM demo.organizer WHERE username = ? AND password = ?";
        ResultSet rs = null;

        try (PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setString(1, username);
            statement.setString(2, password);
            rs = statement.executeQuery();

            while (rs.next()){
                Organizer organizer = new Organizer();
                organizer.setUsername(rs.getString("username"));
                organizer.setPassword(rs.getString("password"));
                organizer.setEmail(rs.getString("Email"));
                return organizer;
            }
        } finally {
            if (rs != null) {
                rs.close();
            }
        }
        return null;
    }

    @Override
    public void delete(Organizer organizer) throws SQLException {
        String sql = "DELETE FROM demo.organizer WHERE username = ?";
        try (PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setString(1, organizer.getUsername());
            statement.executeUpdate();
        }
    }

    @Override
    public void register(Organizer organizer) throws SQLException {
        String sql = "INSERT INTO demo.organizer (username, password, emailAddress) VALUES (?, ?, ?)";
        try (PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setString(1, organizer.getUsername());
            statement.setString(2, organizer.getPassword());
            statement.setString(3, organizer.getEmail());
            statement.executeUpdate();
        }
    }

    @Override
    public void update(Organizer organizer) throws SQLException {
        String sql = "UPDATE demo.organizer SET password = ?, emailAddress = ? WHERE username = ?";
        try (PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setString(1, organizer.getPassword());
            statement.setString(2, organizer.getEmail());
            statement.setString(4, organizer.getUsername());
            statement.executeUpdate();
        }
    }

}
