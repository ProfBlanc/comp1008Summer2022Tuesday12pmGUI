package ca.georgiancollege.cppr.comp1008.comp1008summer2022thursdays12pmgui;

public class LoginModel {

    private String username, password;
    private final String targetUsername = "admin", targetPassword = "pass";
    public void setValues(String username, String password){
        this.username = username;
        this.password = password;
    }
    public void process(){
        if(username.equals(targetUsername) && password.equals(targetPassword)){
            //good job!
        }
        else{
            throw new IllegalArgumentException(String.format("Username/Password combo of '%s'/'%s' is incorrect", username, password));
        }
    }
}
