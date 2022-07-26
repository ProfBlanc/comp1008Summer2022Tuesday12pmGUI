package ca.georgiancollege.cppr.comp1008.comp1008summer2022thursdays12pmgui;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class RegisterModel {

    private String username, password, confirmPassword;
    private final String atLeast = "should be at least 5 characters";
    void setFields(String username, String password, String confirmPassword){
        this.username = username;
        this.password = password;
        this.confirmPassword = confirmPassword;
    }
    public void process() throws Exception{
        determineIfFieldsAreAtLeastFiveCharacters();
        ensurePasswordsMatch();
        addUserToList();
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
    void addUserToList() throws Exception{

        Path file = Paths.get("src\\main\\resources\\ca\\georgiancollege\\cppr\\comp1008\\comp1008summer2022thursdays12pmgui\\data\\" + username + ".txt");

        try {
            Files.createFile(file);
            Files.writeString(file, password);
        }
        catch (Exception e){
            System.err.println(e);
            throw new Exception("Could not write to file");
        }

    }


}
