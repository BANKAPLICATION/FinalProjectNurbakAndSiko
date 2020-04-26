package sample;

import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;

public class EmployeeController extends Methods  {

    @FXML
    private Button Backbutton;

    @FXML
    private Button ClientsButton;
    public void initialize(){
        Backbutton.setOnAction(event->{
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setContentText("Good bye!");
            alert.showAndWait();
            super.change(Backbutton,"sample");
        });
    }
}
