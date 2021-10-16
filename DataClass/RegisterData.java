package DataClass;

// Create Register Data Class
public class RegisterData {
    // Create properties of Register Data Class
    private String name;
    private String email;
    private String securityPassword;
    private String acc_type;

    public String getName(){
        return name;
    }

    public void setName(String name){
        this.name = name;
    }

    public String getEmail(){
        return email;
    }

    public void setEmail(String email){
        this.email = email;
    }

    public String getSecurityPassword(){
        return securityPassword;
    }

    public void setSecurityPassword(String securityPassword){
        this.securityPassword = securityPassword;
    }

    public String getAccType(){
        return acc_type;
    }

    public void setAccType(String acc_type){
        this.acc_type = acc_type;
    }
}
