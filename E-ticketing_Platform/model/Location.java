package model;

public class Location {
    private String city;
    private String address;
    private Integer capacity;


    public Location(String city, String address, Integer capacity) {
        this.city = city;
        this.address = address;
        this.capacity = capacity;
    }

    public Location() {

    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public Integer getCapacity() {
        return capacity;
    }

    public void setCapacity(Integer capacity) {
        this.capacity = capacity;
    }

    @Override
    public String toString() {
        return "Location{" +
                "city='" + city + '\'' +
                ", address='" + address + '\'' +
                ", capacity=" + capacity +
                '}';
    }

}
