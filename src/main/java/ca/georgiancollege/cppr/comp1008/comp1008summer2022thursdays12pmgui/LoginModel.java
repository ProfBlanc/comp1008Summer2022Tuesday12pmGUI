package ca.georgiancollege.cppr.comp1008.comp1008summer2022thursdays12pmgui;

import java.io.File;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Locale;

public class LoginModel {

    private String username, password;
    private final String targetUsername = "admin", targetPassword = "pass";
    public void setValues(String username, String password){
        this.username = username;
        this.password = password;
    }
    public void process() throws Exception{
        String rootPath = "src\\main\\resources\\ca\\georgiancollege\\cppr\\comp1008\\comp1008summer2022thursdays12pmgui\\data";
        Path path = Paths.get(rootPath);
        File[] allFiles = path.toFile().listFiles();

        boolean matchFound = false;
        for(File current : allFiles){
            System.out.println(current.getName() + "---" + username);
            String fileName = current.getName().split(".txt")[0];
            if(fileName.equals(username.toLowerCase())){
                try {
                    String content = Files.readString(Paths.get(rootPath, current.getName()));
                    if(content.equals(password)){
                        matchFound = true;
                        break;
                    }
                    else{
                        throw new Exception("Password for " + current.getName() + " is incorrect");

                    }
                }
                catch(Exception e){
                    throw new Exception("Could not read file " + current.toString());
                }
            }
        }
        if(!matchFound){
            throw new Exception("Username " + username + " does not exist in our database");
        }
        /*
        if(username.equals(targetUsername) && password.equals(targetPassword)){
            //good job!
        }
        else{
            throw new IllegalArgumentException(String.format("Username/Password combo of '%s'/'%s' is incorrect", username, password));
        }

         */
    }
}
