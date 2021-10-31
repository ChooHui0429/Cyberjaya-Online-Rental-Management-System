package dataclass;

/**
 * Verified user class, extends user account class
 * 
 * @author Tan Choo Hui
 * @author Lim Tian Hee
 */
public class VerifiedUser extends UserAccount {
    // Create properties of Admin Data Class
    private String userID;
    private String loginPassword;

    public String getuserID() {
        return userID;
    }

    public void setuserID(String userID) {
        this.userID = userID;
    }

    public String getloginPassword() {
        return loginPassword;
    }

    public void setloginPassword(String loginPassword) {
        this.loginPassword = loginPassword;
    }
}
