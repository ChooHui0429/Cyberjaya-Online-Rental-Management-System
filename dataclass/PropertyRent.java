package dataclass;

public class PropertyRent {
    private String userID;
    private String propertyID;
    private String ownerAgentID;
    private String status;

    public String getUserID() {
        return userID;
    }

    public void setUserID(String userID) {
        this.userID = userID;
    }

    public String getPropertyID() {
        return propertyID;
    }

    public void setPropertyID(String propertyID) {
        this.propertyID = propertyID;
    }

    public String getOwnerAgentID() {
        return ownerAgentID;
    }

    public void setOwnerAgentID(String ownerAgentID) {
        this.ownerAgentID = ownerAgentID;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
