package dao;

import model.Organizer;
import java.util.ArrayList;
import java.util.List;

public class OrganizerDao {

    private  static  List<Organizer> organizers = new ArrayList<>();//lista care tine minte organizatorii

    //LOGIN care cauta dupa nume in lista si returneaza obiectul cu numele ala (trebuie sa implementam pentru parola)
    public Organizer login(String username, String password){
        if(!organizers.isEmpty()){
            for(Organizer o : organizers){
                if(o.getUsername().equals(username) && o.getPassword().equals(password))
                    return o;
            }
        }
        return null;
    }

    public void delete (Organizer organizer){
        organizers.remove(organizer);
    }

    public void register (Organizer organizer){
        organizers.add(organizer);
    }
}
