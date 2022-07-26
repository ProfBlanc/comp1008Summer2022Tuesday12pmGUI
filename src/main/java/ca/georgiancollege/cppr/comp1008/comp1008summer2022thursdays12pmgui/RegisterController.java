package ca.georgiancollege.cppr.comp1008.comp1008summer2022thursdays12pmgui;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.control.*;
import javafx.stage.Stage;

public class RegisterController {

    @FXML
    private TextField fieldUsername;

    @FXML
    private PasswordField fieldPassword;

    @FXML
    private PasswordField fieldConfirmPassword;

    @FXML
    private Label labelError;

    RegisterModel model = new RegisterModel();

    @FXML
    void onReset(ActionEvent event) {

       Button clicked =  (Button)event.getSource();
        System.out.println("clicked on button with text " + clicked.getText());

        resetFields();

    }

    @FXML
    void onSubmit(ActionEvent event) {

        model.setFields(fieldUsername.getText(), fieldPassword.getText(), fieldConfirmPassword.getText());
        try{
            model.process();
            Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
            alert.setTitle("Good Job");
            alert.setContentText("Thank you for registering");
            alert.show();
            resetFields();

            Node node = (Node)event.getSource();
            Stage stage = (Stage)node.getScene().getWindow();
            stage.close();

        }
        catch (Exception e){
            labelError.setText(e.getMessage());
        }
    }
    void resetFields(){
        fieldUsername.setText("");
        fieldPassword.setText("");
        fieldConfirmPassword.setText("");
        labelError.setText("");
    }
    @FXML
    void initialize(){
        resetFields();

    }

}
