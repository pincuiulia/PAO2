import daoServices.EventRepositoryService;
import service.EventService;
import service.LocationService;
import service.UserService;
import daoServices.LocationRepositoryService;

import java.sql.SQLException;
import java.util.Scanner;

public class Application {
    public static void main(String[] args) throws SQLException {
        

        Scanner scanner = new Scanner(System.in);
        UserService userService = new UserService();
        LocationRepositoryService locationRepositoryService = new LocationRepositoryService();
        EventRepositoryService eventRepositoryService = new EventRepositoryService();
        LocationService locationService = new LocationService(locationRepositoryService);
        EventService eventService = new EventService(eventRepositoryService);

        while(true) {
            menu();
            String command = scanner.nextLine();
            System.out.println("Command received: " + command);
            switch (command.toLowerCase()) {
                case "login":
                    userService.login(scanner);
                    break;
                case "register":
                    userService.register(scanner);
                    break;
                case "delete account":
                    userService.delete(scanner);
                    break;
                case "add location":
                    locationService.addLocation(scanner);
                    break;
                case "remove location":
                    locationService.removeLocation(scanner);
                    break;
                case "find location":
                    locationService.readLocation(scanner);
                    break;
                case "add event":
                    eventService.addEvent(scanner);
                    break;
                case "remove event":
                    eventService.removeEvent(scanner);
                    break;
                case "find event":
                    eventService.findEvent(scanner);
                    break;
                case "display next events":
                    eventService.displaySortedEvents();
                    break;
                case "quit":
                    System.out.println("Exiting....");
                    return;
                default:
                    System.out.println("Wrong command");
            }
        }
    }

    private static void menu() {
        System.out.println("___Available commands:___");
        System.out.println("---> Register");
        System.out.println("---> login");
        System.out.println("---> delete account");
        System.out.println("---> Add Location");
        System.out.println("---> Remove Location");
        System.out.println("---> Find Location");
        System.out.println("---> Add Event");
        System.out.println("---> Remove Event");
        System.out.println("---> Find Event");
        System.out.println("---> Display next events");
        System.out.println("---> QUIT");
        System.out.println("Enter command:");
    }
}
