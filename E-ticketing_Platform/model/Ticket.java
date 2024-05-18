package model;

public class Ticket {
    private String userID;
    private Float price;
    private String eventName;

    public Ticket(String id, Float price, String eventName){
        this.userID = id;
        this.price = price;
        this.eventName = eventName;
    }


    public String getId() {
        return userID;
    }


    public void setId(String id) {
        this.userID = id;
    }


    public Float getPrice() {
        return price;
    }


    public void setPrice(Float price) {
        this.price = price;
    }


    public String getEventName() {
        return eventName;
    }


    public void setEventName(String eventName) {
        this.eventName = eventName;
    }

    @Override
    public String toString() {
        return "Ticket{" +
                "UserID='" + userID + '\'' +
                ", price=" + price +
                ", eventName='" + eventName + '\'' +
                '}';
    }
}
