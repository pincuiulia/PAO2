package model;

public class VIPTicket extends Ticket {
    private Boolean accessToVIP;
    private String VIPBenefits;

    public VIPTicket(String id, Float price, String eventName) {
        super(id, (float) (price * 1.5), eventName);
    }

    public Boolean getAccessToVIP() {
        return accessToVIP;
    }

    public void setAccessToVIP(Boolean accessToVIP) {
        this.accessToVIP = accessToVIP;
    }

    public String getVIPBenefits() {
        return VIPBenefits;
    }

    public void setVIPBenefits(String VIPBenefits) {
        this.VIPBenefits = VIPBenefits;
    }
}
