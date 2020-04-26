package sample;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;

public class MyBankController extends Methods {
    @FXML
    private Button backbutton;

    @FXML
    private Label ScoreMoney;

    public void initialize(){
        backbutton.setOnAction(event ->{
            super.change(backbutton,"Client");
        } );

    }
}
