package DataClass;

// Create Property Rate Class
public class PropertyRateData {
    private String propertyID;
    private Integer rentedNum;
    private Integer rateMark;

    public String getPropertyID() {
        return propertyID;
    }

    public void setPropertyID(String propertyID) {
        this.propertyID = propertyID;
    }

    public Integer getRentedNum() {
        return rentedNum;
    }

    public void setRentedNum(Integer rentedNum) {
        this.rentedNum = rentedNum;
    }

    public Integer getRateMark() {
        return rateMark;
    }

    public void setRateMark(Integer rateMark) {
        this.rateMark = rateMark;
    }
}