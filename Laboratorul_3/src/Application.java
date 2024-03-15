import model.Student;
import model.Profesor;
import service.StorageService;
import java.util.Scanner;

public class Application {
    private static final StorageService storageService = new StorageService();
    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        String command;
        do {
            System.out.println("Available commands:\ncreate\nread\nupdate\ndelete\nquit\nEnter command:");
            command = scanner.nextLine().trim().toLowerCase();
            switch (command) {
                case "create":
                    createEntity();
                    break;
                case "read":
                    readEntity();
                    break;
                // Cases for update and delete would go here
                case "quit":
                    System.out.println("Exiting application...");
                    break;
                default:
                    System.out.println("Invalid command.");
            }
        } while (!command.equals("quit"));
    }

    private static void createEntity() {
        System.out.println("Enter type of person (student/profesor):");
        String type = scanner.nextLine().trim().toLowerCase();
        System.out.println("name:");
        String name = scanner.nextLine().trim();
        System.out.println("phone number:");
        String phoneNumber = scanner.nextLine().trim();
        System.out.println("email:");
        String email = scanner.nextLine().trim();

        if (type.equals("student")) {
            System.out.println("student number:");
            String studentNumber = scanner.nextLine().trim();
            System.out.println("average mark:");
            double averageMark = Double.parseDouble(scanner.nextLine().trim());
            System.out.println("class:");
            String className = scanner.nextLine().trim();
            Student student = new Student(name, phoneNumber, email, studentNumber, averageMark, className);
            storageService.addStudent(student);
        } else if (type.equals("profesor")) {
            System.out.println("course:");
            String course = scanner.nextLine().trim();
            System.out.println("year:");
            int year = Integer.parseInt(scanner.nextLine().trim());
            Profesor profesor = new Profesor(name, phoneNumber, email, course, year);
            storageService.addProfesor(profesor);
        } else {
            System.out.println("Invalid type of person.");
        }
    }

    private static void readEntity() {
        System.out.println("Enter the name of the person:");
        String name = scanner.nextLine().trim();
        storageService.readPersonByName(name);
    }
}
