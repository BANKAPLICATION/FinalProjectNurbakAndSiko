package sample;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;

import java.io.IOException;

public class AdminController {

    @FXML

    private Button showclientsButton;

    @FXML
    private Button exitbUTTON;

    @FXML
    private Button showemployee;

    @FXML
    public void initialize() {
        showclientsButton.setOnAction(event -> {
            change(showclientsButton,"showuser");
        });
        exitbUTTON.setOnAction(event -> {
            change(exitbUTTON,"sample");
        });
    }



    public void change(Button button, String url) {
        button.getScene().getWindow().hide();
        FXMLLoader loader  = new FXMLLoader();
        loader.setLocation(getClass().getResource("/sample/" + url + ".fxml"));
        try {
            loader.load();
        }
        catch (IOException e) {
            e.printStackTrace();
        }
        Parent root = loader.getRoot();
        Stage stage = new Stage();
        stage.setScene(new Scene(root));
        stage.show();
    }


}
