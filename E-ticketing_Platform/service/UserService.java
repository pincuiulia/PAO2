package service;

import daoServices.UserRepositoryService;
import model.User;
import model.Client;
import model.Organizer;
import java.util.Scanner;
import java.sql.SQLException;
import utils.FileManagement;


import static utils.Constants.CLIENT;
import static utils.Constants.ORGANIZER;
import static utils.Constants.AUDIT_FILE;

public class UserService {

    private UserRepositoryService databaseService;
    public UserService() throws SQLException  {this.databaseService = new UserRepositoryService();}
    public boolean typeOfUserValidation(String typeOfUser) {

        if(! typeOfUser.equals(CLIENT) && !typeOfUser.equals(ORGANIZER)){
            System.out.println("Wrong type");
            return false;
        }
        return true;
    }

    private User setGeneralInfo(String username, Scanner scanner) {
        System.out.println("password:");
        String password = scanner.nextLine();
        System.out.println("email:");
        String email = scanner.nextLine();
        return new User(username, password, email);
    }

    private void personInit(Scanner scanner, String typeOfUser) throws SQLException {
        System.out.println("username: ");
        String username = scanner.nextLine();
        System.out.println("password: ");
        String password = scanner.nextLine();
        System.out.println("email:");
        String email = scanner.nextLine();

        User newUser = null;

        if ((typeOfUser.equals(CLIENT) && databaseService.getClientByUsernameAndPassword(username, password) != null) ||
                (typeOfUser.equals(ORGANIZER) && databaseService.getOrganizerByUsernameAndPassword(username, password) != null)) {
            System.out.println("An account with these credentials already exists.");
        } else {
            if (typeOfUser.equals(CLIENT)) {
                newUser = new Client(username, password, email);
                System.out.println(newUser);
            } else if (typeOfUser.equals(ORGANIZER)) {
                newUser = new Organizer(username, password, email);
            }

            if (newUser != null) {
                databaseService.addUser(newUser);
                System.out.println("User registered successfully!");
            } else {
                System.out.println("Failed to create user account.");
            }

            try {
                databaseService.addUser(newUser);
                System.out.println("Created " + newUser);
                FileManagement.scriereFisierChar(AUDIT_FILE, "add persoana " + newUser.getUsername());
            } catch (SQLException e) {
                System.out.println("Cannot create " + newUser + " exception " + e.getSQLState() + " " + e.getMessage());
            }
        }
    }


   public void register(Scanner scanner){
           System.out.println("Enter type of account [client/organizer]:");
           String typeOfUser = scanner.nextLine().toLowerCase();
           if(!typeOfUserValidation(typeOfUser)){return;}
       try {
           personInit(scanner, typeOfUser);
       } catch (SQLException e) {
           System.out.println("Userul nu se poate crea " + e.getSQLState() + " " + e.getMessage());
       }
    }

    public void login(Scanner scanner) {
        System.out.println("Enter user type (client/organizer):");
        String userType = scanner.nextLine().trim().toLowerCase();
        System.out.println("username: ");
        String username = scanner.nextLine().trim();
        System.out.println("password: ");
        String password = scanner.nextLine().trim();

        User user = null;

        try {
            switch (userType) {
                case "client":
                    user = databaseService.getClientByUsernameAndPassword(username, password);
                    FileManagement.scriereFisierChar(AUDIT_FILE, "login client " + username);
                    break;
                case "organizer":
                    user = databaseService.getOrganizerByUsernameAndPassword(username, password);
                    FileManagement.scriereFisierChar(AUDIT_FILE, "login organizer " + username);
                    break;
                default:
                    System.out.println("Invalid user type.");
                    return;
            }
        } catch (SQLException e) {
            System.out.println("Login failed: " + e.getSQLState() + " " + e.getMessage());
        }

        if (user != null) {
            System.out.println("Login successful for: " + user.getUsername());
        } else {
            System.out.println("Login failed. Check your username, password, and user type.");
        }
    }

    public void delete(Scanner scanner){
        System.out.println("username: ");
        String username = scanner.nextLine();
        System.out.println("typeOfUser:");
        String typeOfUser = scanner.nextLine();
        System.out.println("password: ");
        String password = scanner.nextLine();
        if(!typeOfUserValidation(typeOfUser)) { return; }
        try {
            databaseService.deleteUser(typeOfUser, username, password);
            FileManagement.scriereFisierChar(AUDIT_FILE, "delete user " + username);
        } catch (SQLException e) {
            System.out.println("The user cannot be deleted " + e.getSQLState() + " " + e.getMessage());
        }
    }


    public void update(Scanner scanner) throws SQLException {
        System.out.println("Enter user type (client/organizer):");
        String userType = scanner.nextLine().trim().toLowerCase();
        if(!typeOfUserValidation(userType)) { return; }
        System.out.println("Enter username:");
        String username = scanner.nextLine().trim();
        System.out.println("Enter password:");
        String password = scanner.nextLine().trim();

        User user = databaseService.getUser(userType, username,password);
        if (user == null) {
            System.out.println("User not found.");
            return;
        }

        // Reading general info
        User userGeneralInfo = setGeneralInfo(username, scanner);
        user.setUsername(username);
        user.setPassword((userGeneralInfo.getPassword()));
        user.setEmail((userGeneralInfo.getEmail()));

        try {
            databaseService.update(user);
            FileManagement.scriereFisierChar(AUDIT_FILE, "update " + userType + " " + username);
            System.out.println("User updated successfully.");
        } catch (SQLException e) {
            System.out.println("User could not be updated: " + e.getSQLState() + " " + e.getMessage());
        }
    }
}
