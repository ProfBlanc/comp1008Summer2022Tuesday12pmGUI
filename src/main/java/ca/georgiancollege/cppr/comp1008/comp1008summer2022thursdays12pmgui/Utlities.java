package ca.georgiancollege.cppr.comp1008.comp1008summer2022thursdays12pmgui;

import javafx.event.Event;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.stage.Stage;

import java.util.Locale;

public class Utlities {

    static void openWindow(String viewFile, String title) throws Exception{
        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource(viewFile+"-view.fxml"));
        Scene scene = new Scene(fxmlLoader.load());
        Stage stage = new Stage();
        stage.setTitle(title);
        stage.setScene(scene);
        stage.show();

    }
    static void closeWindow(Event event){
        Node node = (Node)event.getSource();
        Stage stage = (Stage)node.getScene().getWindow();
        stage.close();
    }

    static Alert createAlert(String type, String title, String content){
        Alert alert;
        type = type.toLowerCase();
        if(type.contains("error"))
            alert = new Alert(Alert.AlertType.ERROR);
        else if(type.contains("info"))
            alert = new Alert(Alert.AlertType.INFORMATION);
        else if(type.contains("confirm"))
            alert = new Alert(Alert.AlertType.CONFIRMATION);
        else
            alert = new Alert(Alert.AlertType.NONE);

        alert.setTitle(title);
        alert.setContentText(content);

        return alert;
    }
}
