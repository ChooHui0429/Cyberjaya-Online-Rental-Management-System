package dataclass;

// Create Property Data Class
public class Property {
    private String propertyID;
    private String category;
    private String status;
    private String address;
    private String size;
    private Integer number_room;
    private Integer number_bathroom;
    private String facilities;
    private String condition;
    private String rental_ask_for;
    private String contact_Number;
    private String agent_owner_acc;
    private Integer rental_fee;

    public String getPropertyID() {
        return propertyID;
    }

    public void setPropertyID(String propertyID) {
        this.propertyID = propertyID;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getSize() {
        return size;
    }

    public void setSize(String size) {
        this.size = size;
    }

    public Integer getNumberRoom() {
        return number_room;
    }

    public void setNumberRoom(Integer number_room) {
        this.number_room = number_room;
    }

    public Integer getNumberBathroom() {
        return number_bathroom;
    }

    public void setNumberBathroom(Integer number_bathroom) {
        this.number_bathroom = number_bathroom;
    }

    public String getFacilities() {
        return facilities;
    }

    public void setFacilities(String facilities) {
        this.facilities = facilities;
    }

    public String getCondition() {
        return condition;
    }

    public void setCondition(String condition) {
        this.condition = condition;
    }

    public String getRentalAskFor() {
        return rental_ask_for;
    }

    public void setRentalAskFor(String rental_ask_for) {
        this.rental_ask_for = rental_ask_for;
    }

    public String getContactNumber() {
        return contact_Number;
    }

    public void setContactNumber(String contact_Number) {
        this.contact_Number = contact_Number;
    }

    public String getAgentOwnerAcc() {
        return agent_owner_acc;
    }

    public void setAgentOwnerAcc(String agent_owner_acc) {
        this.agent_owner_acc = agent_owner_acc;
    }

    public Integer getRentalFee() {
        return rental_fee;
    }

    public void setRentalFee(Integer rental_fee) {
        this.rental_fee = rental_fee;
    }
}
