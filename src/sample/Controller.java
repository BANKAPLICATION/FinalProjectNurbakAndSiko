package sample;

import com.jfoenix.controls.JFXPasswordField;
import com.jfoenix.controls.JFXTextField;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

import java.io.IOException;


public class Controller {
    @FXML
    private AnchorPane cv;

    @FXML
    private AnchorPane content_area;

    @FXML
    private Button SigninButton;

    @FXML
    private Button closebtn;

    @FXML
    private Button Forgotbutton;

    @FXML
    private JFXTextField textfieldusername;

    @FXML
    private JFXPasswordField textfieldpassword;



    @FXML
    private Button RegisterButton;



    public void initialize() {
        Database database = new Database();
        SigninButton.setOnAction(event -> {
            String login = textfieldusername.getText();
            String password = textfieldpassword.getText();
            if (login.isEmpty() || password.isEmpty()) {
                Alert alert = new Alert(Alert.AlertType.ERROR);
                alert.setContentText("Login or Password field is empty!!!");
                alert.showAndWait();
                // database.deleteUser(1);

            }
            else {
                int index = -1;
                if (database.checkUseronLogin(login,password) >= 0) {
                    Alert alert = new Alert(Alert.AlertType.INFORMATION);
                    alert.setContentText("You are Logged!!!");
                    alert.showAndWait();
                    database.getUserId(database.checkUseronLogin(login,password));
                    change(SigninButton,"clientt");
                }
                else if(database.admin(login,password)) {
                    Alert alert = new Alert(Alert.AlertType.INFORMATION);
                    alert.setContentText("Hello Admin!!!");
                    alert.showAndWait();
                    change(SigninButton,"admin");
                }
//               else if(database.employee(login,password)){
//                    Alert alert = new Alert(Alert.AlertType.INFORMATION);
//                    alert.setContentText("Hello Employee");
//                    alert.showAndWait();
//                    change(SigninButton,"employee");
//                }
                else {
                    Alert alert = new Alert(Alert.AlertType.ERROR);
                    alert.setContentText("In correct please try again!!!");
                    alert.showAndWait();
                    textfieldusername.setText("");
                    textfieldpassword.setText("");
                }
            }
        });

        RegisterButton.setOnAction(event -> {
            change(RegisterButton,"Registration");
        });

        Forgotbutton.setOnAction(event ->{
            change(Forgotbutton,"forgotpassword");
        });
        closebtn.setOnAction(event -> {
            System.exit(0);
        });
    }
//    public void open_Registration(MouseEvent event) throws IOException {
//    Parent fxml = FXMLLoader.load(getClass().getResource("/sample/Registration.fxml"));
//    }

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

    public void open_Registration(javafx.scene.input.MouseEvent mouseEvent) {

    }
}
