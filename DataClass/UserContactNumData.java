package DataClass;

// Create User Contact Number Data Class
public class UserContactNumData {
    private String userID;
    private String contactNumber;

    public String getUserID(){
        return userID;
    }

    public void setUserID(String userID){
        this.userID = userID;
    }

    public String getContactNumber(){
        return contactNumber;
    }

    public void setContactNumber(String contactNumber){
        this.contactNumber = contactNumber;
    }

    @Override
    public String toString(){
        return "\"UserContactNumData [User ID ="+ userID + ",Contact Number =" + contactNumber +"]";
    }
}
