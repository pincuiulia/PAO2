package daoServices;
import dao.EventDao;
import model.Event;

import java.util.ArrayList;
import java.util.List;

public class EventRepositoryService {
    private EventDao eventDao;

    public EventRepositoryService(){
        this.eventDao = new EventDao();
    }

    public void addEvent(Event event) {
        eventDao.addEvent(event);
        System.out.println("Event added: " + event);
    }

    public Event getEventByName(String name){
        Event event = eventDao.readEvent(name);
        if(event != null){
            System.out.println(event);
        }else {
            System.out.println("No event having this name");
        }

        return event;
    }

    public void removeEvent(String eventName) {
        Event event = getEventByName(eventName);
        if (event == null) return;

        eventDao.removeEvent(event);

        System.out.println("Removed event: " + eventName);
    }

    public List<Event> getAllEvents() {

        return new ArrayList<>(eventDao.getEvents());
    }

}
