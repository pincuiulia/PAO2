package dao;

import model.Event;
import java.util.ArrayList;
import java.util.List;

public class EventDao {
    private List<Event> events = new ArrayList<>();

    public void addEvent(Event event) {
        events.add(event);
    }

    public void removeEvent(Event event) {
        events.remove(event);
    }

    public Event readEvent(String name) {
        if(!events.isEmpty()) {
            for(Event e : events) {
                if(e.getName().equals(name)) {
                    return e;
                }
            }
        }
        return null;
    }

    public List<Event> getEvents() {
        return new ArrayList<>(events); // returneaza o copie a listei pentru a evita modificările externe
    }
}
