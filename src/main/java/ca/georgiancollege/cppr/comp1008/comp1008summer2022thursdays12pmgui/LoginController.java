package ca.georgiancollege.cppr.comp1008.comp1008summer2022thursdays12pmgui;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;

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


    //is called BEFORE any of JavaFX components are rendered
    public LoginController(){}

    //called AFTER all JavaFX components are rendered
    @FXML
    void initialize(){
        labelError.setText("");
    }

    @FXML
    void onLogin(ActionEvent event){
        fieldUsername.setText("Hi from login button");
    }
    @FXML
    void onRegister(ActionEvent event){
        labelError.setText(fieldUsername.getText());
    }

}
