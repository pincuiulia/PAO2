package service;

import daoServices.UserRepositoryService;
import model.User;
import model.Client;
import model.Organizer;
import java.util.Scanner;

import static utils.Constants.CLIENT;
import static utils.Constants.ORGANIZER;

public class UserService {

    private UserRepositoryService databaseService;
    public UserService(){this.databaseService = new UserRepositoryService();}
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

    private void personInit(Scanner scanner, String typeOfUser) {
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
            } else if (typeOfUser.equals(ORGANIZER)) {
                newUser = new Organizer(username, password, email);
            }

            if (newUser != null) {
                databaseService.addUser(newUser);
                System.out.println("User registered successfully!");
            } else {
                System.out.println("Failed to create user account.");
            }
        }
    }


   public void register(Scanner scanner){
           System.out.println("Enter type of account [client/organizer]:");
           String typeOfUser = scanner.nextLine().toLowerCase();
           if(!typeOfUserValidation(typeOfUser)){return;}
           personInit(scanner, typeOfUser);
    }

    public void login(Scanner scanner) {
        System.out.println("Enter user type (client/organizer):");
        String userType = scanner.nextLine().trim().toLowerCase();
        System.out.println("username: ");
        String username = scanner.nextLine().trim();
        System.out.println("password: ");
        String password = scanner.nextLine().trim();

        User user = null;
        switch (userType) {
            case "client":
                user = databaseService.getClientByUsernameAndPassword(username, password);
                break;
            case "organizer":
                user = databaseService.getOrganizerByUsernameAndPassword(username, password);
                break;
            default:
                System.out.println("Invalid user type.");
                return;
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
        databaseService.deleteUser(typeOfUser, username, password);
    }
}
