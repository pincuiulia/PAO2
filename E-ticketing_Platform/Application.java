import daoServices.EventRepositoryService;
import service.EventService;
import service.LocationService;
import service.UserService;
import daoServices.LocationRepositoryService;

import java.util.Scanner;

public class Application {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        UserService userService = new UserService();
        LocationRepositoryService locationRepositoryService = new LocationRepositoryService();
        EventRepositoryService eventRepositoryService = new EventRepositoryService();
        LocationService locationService = new LocationService(locationRepositoryService);
        EventService eventService = new EventService(eventRepositoryService);

        while(true) {
            menu();
            String command = scanner.nextLine().toLowerCase();
            System.out.println("Command received: " + command);
            switch (command) {
                case "login":
                    userService.login(scanner);
                    break;
                case "register":
                    userService.register(scanner);
                    break;
                case "delete account":
                    userService.delete(scanner);
                    break;
                case "Add Location":
                    locationService.addLocation(scanner);
                    break;
                case "Remove Location":
                    locationService.removeLocation(scanner);
                    break;
                case "Find Location":
                    locationService.readLocation(scanner);
                    break;
                case "Add Event":
                    eventService.addEvent(scanner);
                    break;
                case "Remove Event":
                    eventService.removeEvent(scanner);
                    break;
                case "Find event":
                    eventService.findEvent(scanner);
                    break;
                case "Display next events":
                    eventService.displaySortedEvents();
                    break;
                case "QUIT":
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
