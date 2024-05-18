package model;

public class GroupTicket extends Ticket{
    private Integer groupNumber;
    public GroupTicket(String id, Float price, String eventName, Integer groupNumber) {
        super(id, price * groupNumber, eventName);
    }

    public void setgroupNumber(Integer groupNumber) {
        this.groupNumber = groupNumber;
    }

    public Integer getgroupNumber() {
        return groupNumber;
    }
}
