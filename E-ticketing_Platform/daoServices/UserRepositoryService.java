package daoServices;

import model.Organizer;
import model.Client;
import model.User;
import dao.ClientDao;
import dao.OrganizerDao;

import java.sql.SQLException;

import static utils.Constants.CLIENT;
import static utils.Constants.ORGANIZER;

public class UserRepositoryService {

    private OrganizerDao organizerDao = OrganizerDao.getInstance();
    private ClientDao clientDao = ClientDao.getInstance();

    public UserRepositoryService() throws SQLException {}

    //Cauta in lista clientilor dupa username
    public Client getClientByUsernameAndPassword(String username, String password) throws SQLException {
        Client client = clientDao.login(username, password);
        if(client != null)
            System.out.println(client);
        else
            System.out.println("No user found with these credentials");
        return client;
    }

    //Cauta in lista organizatorilor dupa username
    public Organizer getOrganizerByUsernameAndPassword(String username, String password) throws SQLException {
        Organizer organizer = organizerDao.login(username, password);
        if(organizer != null)
            System.out.println(organizer);
        else
            System.out.println("No user found with these credentials");
        return organizer;
    }

    //cauta in listele de clienti si organizatori folosindu-se de type si nume
    public User getUser(String typeOfPerson, String username, String password)  throws SQLException{
        User user = null;
        switch (typeOfPerson) {
            case CLIENT:
                user = getClientByUsernameAndPassword(username, password);
                break;
            case ORGANIZER:
                user = getOrganizerByUsernameAndPassword(username, password);
                break;
            default:
                System.out.println("Invalid type of person: " + typeOfPerson);
                break;
        }
        if (user == null) {
            System.out.println("No user found with these credentials");
        }
        return user;
    }


    //adauga utilizator
    public void addUser(User user)  throws SQLException{
        if(user != null){
            switch (user){
                case Client client -> clientDao.register(client);
                case Organizer organizer -> organizerDao.register(organizer);
                default -> throw new IllegalStateException("Unexpected value: " + user);
            }
        }
    }

    public void deleteUser(String typeOfUser, String username, String password)  throws SQLException{
        User user = getUser(typeOfUser, username, password);
        if (user == null) return;

        switch (user){
            case Client client -> clientDao.delete(client);
            case Organizer organizer -> organizerDao.delete(organizer);
            default -> throw new IllegalStateException("Unexpected value: " + user);
        }
        System.out.println("Deleted " + user);
    }

    public void update(User user) throws SQLException {
        if (user != null) {
            switch (user) {
                case Client client -> clientDao.update(client);
                case Organizer organizer -> organizerDao.update(organizer);
                default -> throw new IllegalStateException("Unexpected value: " + user);
            }
        }
    }
}