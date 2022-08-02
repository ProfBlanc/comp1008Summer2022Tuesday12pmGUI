package ca.georgiancollege.cppr.comp1008.comp1008summer2022thursdays12pmgui;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class LoginController {


    /*
        any time you refer to an FXML item (Node or a method)
        @FXML
     */

    @FXML
    TextField fieldUsername;

    @FXML
    PasswordField fieldPassword;

    @FXML
    Label labelError;

    LoginModel model = new LoginModel();

    //is called BEFORE any of JavaFX components are rendered
    public LoginController(){}

    //called AFTER all JavaFX components are rendered
    @FXML
    void initialize(){
        clearFields();
        System.out.println("Started!");
        //error message to the labelError
    }

    @FXML
    void onLogin(ActionEvent event){

        labelError.setText("");
        //fieldUsername.setText("Hi from login button");
        /*
        String username = fieldUsername.getText();
        String password = fieldPassword.getText();
        if(username.equals("admin") && password.equals("pass")){
            System.out.println("Congrats");
        }
        else{
            labelError.setText(String.format("Username/Password combo of '%s'/'%s' is incorrect", username, password));
        }

         */
        model.setValues(fieldUsername.getText(), fieldPassword.getText());
        try{
            model.process();
            Alert alert = Utlities.createAlert("info", "Wahoo", "Congrats, "+ fieldUsername.getText()+"! You may enter the site");
            alert.show();
            clearFields();
        }
        catch (Exception e){
            labelError.setText(e.getMessage());
        }
    }
    void clearFields(){
        fieldUsername.setText("");
        fieldPassword.setText("");
        labelError.setText("");

    }
    @FXML
    void onRegister(ActionEvent event){
        //labelError.setText(fieldUsername.getText());

    try {
        Utlities.openWindow("register", "Registration Example");
    }
    catch (Exception e){
        labelError.setText("Unable to able Register view");
    }

    }

}
