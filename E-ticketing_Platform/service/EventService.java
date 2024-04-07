package service;

import daoServices.EventRepositoryService;
import model.Event;
import model.Location;

import java.util.Comparator;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class EventService {
    private EventRepositoryService eventRepositoryService;

    public EventService(EventRepositoryService eventRepositoryService) {
        this.eventRepositoryService = eventRepositoryService;
    }

    public void addEvent(Scanner scanner) {
        System.out.println("Enter event name:");
        String name = scanner.nextLine();
        System.out.println("Enter event date:");
        String date = scanner.nextLine();
        System.out.println("Enter event city:");
        String city = scanner.nextLine();
        System.out.println("Enter event address:");
        String address = scanner.nextLine();
        System.out.println("Enter event's location capacity:");
        Integer capacity = Integer.parseInt(scanner.nextLine());
        System.out.println("Enter organizer name:");
        String organizerName = scanner.nextLine();
        System.out.println("Enter ticket price:");
        Float price = Float.parseFloat(scanner.nextLine());

        Location location = new Location(city, address, capacity);
        Event event = new Event(name, date, location, organizerName, price);
        eventRepositoryService.addEvent(event);
    }

    public void removeEvent(Scanner scanner) {
        System.out.println("Enter the name of the event to remove:");
        String eventName = scanner.nextLine();
        eventRepositoryService.removeEvent(eventName);
    }

    public void findEvent(Scanner scanner) {
        System.out.println("Enter the name of the event to find:");
        String eventName = scanner.nextLine();
        eventRepositoryService.getEventByName(eventName);
    }

    public List<Event> getSortedEventsByDate() {
        return eventRepositoryService.getAllEvents().stream()
            .sorted(Comparator.comparing(Event::getDate))
                .collect(Collectors.toList());
    }
    public void displaySortedEvents() {
        List<Event> sortedEvents = eventRepositoryService.getAllEvents().stream()
                .sorted(Comparator.comparing(Event::getDate))
                .collect(Collectors.toList());
        for (Event event : sortedEvents) {
            System.out.println(event);
        }
    }
}

