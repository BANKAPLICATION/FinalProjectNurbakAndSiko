package sample;

import Server.ClientHandler;
import com.jfoenix.controls.*;
import de.jensd.fx.glyphs.fontawesome.FontAwesomeIcon;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import javafx.scene.control.*;
import javafx.util.StringConverter;

import java.io.IOException;
import java.sql.Date;
import java.time.LocalDate;
import java.util.ArrayList;

public class RegistrationController {

    @FXML
    private AnchorPane VB;

    @FXML
    private Button Exitbutton;

    @FXML
    private JFXTextField loginField;

    @FXML
    private JFXPasswordField passwrodField;

    @FXML
    private Button Registrbutton;
    @FXML
    private JFXComboBox<String> ChoiceBoxRegion;

    @FXML
    private JFXComboBox<String> ChoiceBoxNumberPhone;

    @FXML
    private JFXToggleNode RegionLabel;

    @FXML
    private JFXToggleNode OperatorLabel;

    @FXML
    private JFXTextField numberPhoneField;

    @FXML
    private JFXTextField answerField;

    @FXML
    private JFXDatePicker Date;

    @FXML
    private Button closebtn;

    ObservableList <String> list = FXCollections.observableArrayList();
    ObservableList <String> list1 = FXCollections.observableArrayList();
    private ClientHandler clientHandler = new ClientHandler();
    public void initialize() throws IOException {
            ArrayList <User> users = new ArrayList<>();
        clientHandler.writeRequest("GET_USERS");
        if (clientHandler.checkRequest("USERS_GOT")) {
            users = ClientHandler.users;
            System.out.println("nagan kirgish");
        }
        System.out.println(users);
        RegionloadData();
        OperatorloadData();
        Registrbutton.setOnAction(event -> {
            Database database = new Database() ;
            String nickname = loginField.getText();
            String password = passwrodField.getText();
            if (nickname.isEmpty() || password.isEmpty()) {
                Alert alert = new Alert(Alert.AlertType.ERROR);
                alert.setContentText("Username field or password field is empty!!!");
                alert.showAndWait();
                loginField.setText("");
                passwrodField.setText("");
                answerField.setText("");
                numberPhoneField.setText("");
                ChoiceBoxNumberPhone.setValue(null);
                ChoiceBoxRegion.setValue(null);
                Date.setValue(null);
            }
            else if(database.checkUser(nickname)) {
                String city = ChoiceBoxRegion.getValue();
                String operator =  ChoiceBoxNumberPhone.getValue();
                String numberPhone = numberPhoneField.getText();
                LocalDate date = Date.getValue();
                String answer = answerField.getText();
                boolean check = checkNumberPhone(operator,numberPhone);;
                if (check) {
                    try {
                        if (!(answer.isEmpty() || city.isEmpty() || operator.isEmpty() || numberPhone.isEmpty() || date.toString().isEmpty() || ChoiceBoxRegion.toString().isEmpty() || ChoiceBoxNumberPhone.toString().isEmpty())) {
                            Alert alert = new Alert(Alert.AlertType.INFORMATION);
                            alert.setContentText("You are Registered!!!");
                            alert.showAndWait();
//        socket                    database.addUser(nickname, password, city, numberPhone, operator, date, answer);
                            clientHandler.writeRequest("ADD_USER",nickname,password,city,numberPhone,operator,date,answer);
                            loginField.setText("");
                            passwrodField.setText("");
                            answerField.setText("");
                            numberPhoneField.setText("");
                            ChoiceBoxNumberPhone.setValue(null);
                            ChoiceBoxRegion.setValue(null);
                            Date.setValue(null);
                        }
                    }
                    catch (Exception e) {

                        Alert alert = new Alert(Alert.AlertType.ERROR);
                        alert.setContentText("One ComboBox is empty!!!");
                        alert.showAndWait();
                        loginField.setText("");
                        passwrodField.setText("");
                        answerField.setText("");
                        numberPhoneField.setText("");
                        ChoiceBoxNumberPhone.setValue(null);
                        ChoiceBoxRegion.setValue(null);
                        Date.setValue(null);
                    }
                }
                else  {
                    System.out.println("Zahodit");
                    Alert alert = new Alert(Alert.AlertType.ERROR);
                    alert.setContentText("Number phone do not right or One or more fields Empty !!!");
                    alert.showAndWait();
                    loginField.setText("");
                    passwrodField.setText("");
                    answerField.setText("");
                    numberPhoneField.setText("");
                    ChoiceBoxNumberPhone.setValue(null);
                    ChoiceBoxRegion.setValue(null);
                    Date.setValue(null);
                }
            }
            else  {
                Alert alert = new Alert(Alert.AlertType.ERROR);
                alert.setContentText("Sorry but this login already exist!!!");
                alert.showAndWait();
                loginField.setText("");
                passwrodField.setText("");
                loginField.setText("");
                passwrodField.setText("");
                answerField.setText("");
                numberPhoneField.setText("");
                ChoiceBoxNumberPhone.setValue(null);
                ChoiceBoxRegion.setValue(null);
                Date.setValue(null);
            }

        });

        Exitbutton.setOnAction(event -> {
            change(Exitbutton,  "sample");
        });
        closebtn.setOnAction(event->{
            System.exit(0);
        });

    }
    public void RegionloadData() {
        String a = "Almaty";
        String b = "Nursyltan";
        String c = "Karaganda";
        String d = "Pavlodar";
        String o = "Oskemen";
        list.addAll(a,b,c,d,o);
        ChoiceBoxRegion.setItems(list);
    }
    public boolean checkNumberPhone(String s, String p) {
        try {
            String Activ = "Activ";
            String Beline = "Beeline";
            String Tele2 = "Tele2";
            String Altel = "Altel";
            String[] Activnumber = {"8775", "8778"};
            String[] Beelinenumber = {"8705", "8701"};
            String[] Tele2number = {"8777", "8747"};
            String[] Altelnumber = {"8702", "8700"};
            if (s.equals(Activ)) {
                String q = p.substring(0, 4);
                for (int i = 0; i < Activnumber.length; i++) {
                    if (q.equals(Activnumber[i])) {
                        return true;
                    }
                }
            }
            if (s.equals(Beline)) {
                String q = p.substring(0, 4);
                for (int i = 0; i < Beelinenumber.length; i++) {
                    if (q.equals(Beelinenumber[i])) {
                        return true;
                    }
                }
            }
            if (s.equals(Tele2)) {
                String q = p.substring(0, 4);
                for (int i = 0; i < Tele2number.length; i++) {
                    if (q.equals(Beelinenumber[i])) {
                        return true;
                    }
                }
            }
            if (s.equals(Altel)) {
                String q = p.substring(0, 4);
                for (int i = 0; i < Altelnumber.length; i++) {
                    if (q.equals(Altelnumber[i])) {
                        return true;
                    }
                }
            }
        }
        catch (Exception e) {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setContentText("Number Phone is Empty!!!");
            alert.showAndWait();
        }
        return false;
    }
    public void OperatorloadData() {
        String a = "Activ";
        String b = "Beeline";
        String c = "Tele2";
        String d = "Altel";
        list1.addAll(a,b,c,d);
        ChoiceBoxNumberPhone.setItems(list1);
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
