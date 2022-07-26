package ca.georgiancollege.cppr.comp1008.comp1008summer2022thursdays12pmgui;

public class RegisterModel {

    private String username, password, confirmPassword;
    private final String atLeast = "should be at least 5 characters";
    void setFields(String username, String password, String confirmPassword){
        this.username = username;
        this.password = password;
        this.confirmPassword = confirmPassword;
    }
    public void process(){
        determineIfFieldsAreAtLeastFiveCharacters();
        ensurePasswordsMatch();
    }
    private void determineIfFieldsAreAtLeastFiveCharacters(){

        if(username.length() < 5)
            throw new IllegalArgumentException("Username " + atLeast);
        else if(password.length() < 5)
            throw new IllegalArgumentException("Password " + atLeast);
    }

    private void ensurePasswordsMatch(){
        if(!password.equals(confirmPassword))
            throw new IllegalArgumentException("Passwords do not match");
    }

}
