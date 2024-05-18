package dao;

import daoServices.DatabaseConnection;
import model.Client;
import model.Organizer;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.sql.*;

public class ClientDao implements DaoInterface<Client>{

    //private static List<Client> clients = new ArrayList<>(); //lista care tine minte clientii

    private static ClientDao clientDao;

    private daoServices.DatabaseConnection DatabaseConnection;
    private Connection connection = DatabaseConnection.getConnection();

    private ClientDao() throws SQLException {}

    public static ClientDao getInstance() throws SQLException {
        if(clientDao == null){
            clientDao = new ClientDao();
        }
        return clientDao;
    }

    //LOGIN care cauta dupa nume in lista si returneaza obiectul cu numele ala (trebuie sa implementam pentru parola)
    @Override
    public Client login(String username, String password) throws SQLException {
        String sql = "SELECT * FROM demo.client WHERE username = ? AND password = ?";
        ResultSet rs = null;

        try (PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setString(1, username);
            statement.setString(2, password);
            rs = statement.executeQuery();

            if (rs.next()) {
                Client client = new Client();
                client.setUsername(rs.getString("username"));
                client.setPassword(rs.getString("password"));
                client.setEmail(rs.getString("emailAddress"));
                return client;
            }
        } finally {
            if (rs != null) {
                rs.close();
            }
        }
        return null;
    }


    //DELETE ca sa putem sterge utilizatorul
    @Override
    public void delete(Client client) throws SQLException {
        String sql = "DELETE FROM demo.client s WHERE s.name = ?";
        try(PreparedStatement statement = connection.prepareStatement(sql);) {
            statement.setString(1, client.getUsername());
            statement.executeUpdate();
        }
    }

    //REGISTER ca dupa ce am creat un utilizator de tip client, il adaugam la lista

    @Override
    public void register(Client client) throws SQLException {
        String sql = "INSERT INTO demo.client (username, password, emailAddress) VALUES (?, ?, ?);";

        try(PreparedStatement statement = connection.prepareStatement(sql);) {
            statement.setString(1, client.getUsername());
            statement.setString(2, client.getPassword());
            statement.setString(3, client.getEmail());
            statement.executeUpdate();
        }
    }

    @Override
    public void update(Client client)  throws SQLException{
        String sql = "UPDATE demo.client set username = ? , password = ?" +
                " , Email = ? where username = ?";
        try(PreparedStatement statement = connection.prepareStatement(sql);) {
            statement.setString(1, client.getUsername());
            statement.setString(2, client.getPassword());
            statement.setString(3, client.getEmail());
            statement.executeUpdate();
        }
    }
}