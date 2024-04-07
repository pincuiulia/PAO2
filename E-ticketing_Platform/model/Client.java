package model;
import java.util.ArrayList;
import java.util.List;

public class Client extends User{

    private  List<Ticket> cart;


    public Client(String username, String password, String email) {
        super(username, password, email);
        this.cart = new ArrayList<>();
    }

    public List<Ticket> getCart() {
        return cart;
    }


    @Override
    public String toString(){
        return "Client details{" +
                "username= " + getUsername() + '\'' +
                "password= " + getPassword() + '\'' +
                "emailAddres= " + getEmail() + '\'' +
                "cart= " + getCart() + '}';
    }
}
