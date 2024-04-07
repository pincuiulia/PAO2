package model;
import java.util.ArrayList;
import java.util.List;

public class Organizer extends User{
    private List<Event> createdEvents;

    public Organizer(String username, String password, String email) {
        super(username, password, email);
        this.createdEvents = new ArrayList<>();
    }

    public List<Event> getCreatedEvents(){
        return createdEvents;
    }

    @Override
    public String toString(){
        return "Client details{" +
                "username= " + getUsername() + '\'' +
                "password= " + getPassword() + '\'' +
                "emailAddres= " + getEmail() + '\'' +
                "cart= " + getCreatedEvents() + '}';
    }
}
