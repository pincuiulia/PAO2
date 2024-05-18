package dao;

import daoServices.DatabaseConnection;
import model.Location;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class LocationDao {

    private static LocationDao locationDao;

    private Connection connection;

    public LocationDao() throws SQLException {
        this.connection = DatabaseConnection.getConnection();
    }

    public static LocationDao getInstance() throws SQLException {
        if (locationDao == null) {
            locationDao = new LocationDao();
        }
        return locationDao;
    }

    // READ
    public Location read(String city) throws SQLException {
        String sql = "SELECT * FROM demo.location WHERE city = ?";
        ResultSet rs = null;

        try (PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setString(1, city);
            rs = statement.executeQuery();

            if (rs.next()) {
                Location location = new Location();
                location.setCity(rs.getString("city"));
                location.setAddress(rs.getString("address"));
                location.setCapacity(rs.getInt("capacity"));
                return location;
            }
        } finally {
            if (rs != null) {
                rs.close();
            }
        }
        return null;
    }

    // REMOVE
    public void removeLocation(Location location) throws SQLException {
        String sql = "DELETE FROM demo.location WHERE city = ?";
        try (PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setString(1, location.getCity());
            statement.executeUpdate();
        }
    }

    // ADD
    public void addLocation(Location location) throws SQLException {
        String sql = "INSERT INTO demo.location (city, address, capacity) VALUES (?, ?, ?)";
        try (PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setString(1, location.getCity());
            statement.setString(2, location.getAddress());
            statement.setInt(3, location.getCapacity());
            statement.executeUpdate();
        }
    }

    // UPDATE
    public void updateLocation(Location location) throws SQLException {
        String sql = "UPDATE demo.location SET address = ?, capacity = ? WHERE city = ?";
        try (PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setString(1, location.getAddress());
            statement.setInt(2, location.getCapacity());
            statement.setString(3, location.getCity());
            statement.executeUpdate();
        }
    }
}
