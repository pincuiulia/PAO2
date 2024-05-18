package model;

public class Event {
    private String name;
    private String date;
    private Location location;
    private String organizerName;
    private Integer ticketsNumber;
    private Float price;

    public Event(String name, String date, Location location, String organizerName, Float price) {
        this.name = name;
        this.date = date;
        this.location = location;
        this.organizerName = organizerName;
        this.price = price;
        this.ticketsNumber = location.getCapacity();
    }


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public Location getLocation() {
        return location;
    }

    public void setLocation(Location location) {
        this.location = location;
    }

    public String getOrganizerName() {
        return organizerName;
    }

    public void setOrganizerName(String organizerName) {
        this.organizerName = organizerName;
    }

    public Integer getTicketsNumber() {
        return ticketsNumber;
    }

    public void setTicketsNumber(Integer ticketsNumber) {
        if (location != null) {
            this.ticketsNumber = location.getCapacity();
        } else {
            System.out.println("Location is not set. Unable to determine tickets number.");
        }
    }

    public Float getPrice() {
        return price;
    }

    public void setPrice(Float price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return "Event{" +
                "name='" + name + '\'' +
                ", date='" + date + '\'' +
                ", location=" + location +
                ", organizerName='" + organizerName + '\'' +
                ", ticketsNumber=" + ticketsNumber +
                ", price=" + price +
                '}';
    }

}
