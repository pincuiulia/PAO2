package dao;

import model.Client;
import java.util.ArrayList;
import java.util.List;

public class ClientDao {

    private static List<Client> clients = new ArrayList<>(); //lista care tine minte clientii

    //LOGIN care cauta dupa nume in lista si returneaza obiectul cu numele ala (trebuie sa implementam pentru parola)
    public Client login(String username, String password){
        if(!clients.isEmpty()){
            for(Client c : clients){
                if(c.getUsername().equals(username) && c.getPassword().equals(password))
                    return c;
            }
        }
        return null;
    }

    //DELETE ca sa putem sterge utilizatorul
    public void delete(Client client){
        clients.remove(client);
    }

    //REGISTER ca dupa ce am creat un utilizator de tip client, il adaugam la lista
    public void register(Client client){
        clients.add(client);
    }
}
