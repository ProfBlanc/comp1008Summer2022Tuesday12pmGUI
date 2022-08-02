package ca.georgiancollege.cppr.comp1008.comp1008summer2022thursdays12pmgui;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

public class GradeController {

    @FXML
    private Label labelLetter;

    @FXML
    private TextField fieldScore;


    GradeModel model = new GradeModel();
    @FXML
    void convertGradeToScore(ActionEvent event) {

        try{
            //use model
            model.process(fieldScore.getText());
            labelLetter.setText(model.getLetter());
        }
        catch (Exception e){
            Alert alert = Utlities.createAlert("Error", "Error!", e.getMessage());
            alert.show();
            reset();
        }

    }

    void reset(){
        labelLetter.setText("");
        fieldScore.setText("");
        fieldScore.requestFocus();
    }
    @FXML
    void initialize(){
        reset();
    }

}
