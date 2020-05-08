package sample;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import java.io.IOException;
import java.sql.Date;
import java.sql.Time;
import java.util.ArrayList;

public class ClientController {


    @FXML
    private Button HistoryButton;

    @FXML
    private Button TransferButton;

    @FXML
    private Button ExitButton;

    @FXML
    private Label datapasswordLabel;

    @FXML
    private Label AmountMoneyLabel;

    @FXML
    private Button myBankButton;

    @FXML
    private Button TranslateButton;

    @FXML
    private TableColumn<History, Integer> CreditTableColumn;

    @FXML
    private TextField addemailField;

    @FXML
    private Label AmountMoneyData;

    @FXML
    private Label passwordLabel;

    @FXML
    private Label addEmailLabel;

    @FXML
    private AnchorPane MyBankAnchorPane;

    @FXML
    private Button ProfilButton;

    @FXML
    private TextField RecipientPhoneNumberLabel;

    @FXML
    private Label informationlabel;

    @FXML
    private TableColumn<History, Integer> TableColumnId;

    @FXML
    private Button Exitbutton;

    @FXML
    private Button addemailButton;

    @FXML
    private AnchorPane profilAnchorPane;

    @FXML
    private Label profilLabel;

    @FXML
    private Label SenderLabel;

    @FXML
    private Label MybankLabel;

    @FXML
    private Label TransferLabel;

    @FXML
    private TableColumn<History, String> TableColumnTransfer;

    @FXML
    private ImageView imageUser;

    @FXML
    private Label labelHistory;

    @FXML
    private Label dataLoginlabel;

    @FXML
    private Button exitButton;

    @FXML
    private TextField TakeDepositField;

    @FXML
    private TextField AmountField;

    @FXML
    private AnchorPane VboxAnchorPane;

    @FXML
    private Button editButton;

    @FXML
    private Label LoginLabel;

    @FXML
    private TextField SenderNumberPhoneField;

    @FXML
    private Label RecipientLabel;

    @FXML
    private TableView<History> HistoryTableView;

    @FXML
    private AnchorPane TransferAnchorPane;

    @FXML
    private TableColumn<History, String> TableColumnLogin;

    @FXML
    private Label TakeDepositLabel;

    @FXML
    private Button TakeDepositButton;

    @FXML
    private Label TransferAmountLabel;

    @FXML
    private TableColumn<History,Time> TableColumnTime;

    @FXML
    private AnchorPane HistoryAnchorPane;

    private static Database database = new Database();
    private static ArrayList<History> list = new Database().getHistory();
    @FXML
    private static ArrayList<History> list1 = new Database().getHistory();
    @FXML
    private static  ObservableList<History> o_list = FXCollections.observableArrayList();
    private static ObservableList <History> t_list = FXCollections.observableArrayList();


    public static String login1 = "";
    public void initialize() {

        TableColumnId.setCellValueFactory(new PropertyValueFactory<>("userid"));
        TableColumnLogin.setCellValueFactory(new PropertyValueFactory<>("Login"));
        TableColumnTransfer.setCellValueFactory(new PropertyValueFactory<>("Transfer"));
        TableColumnTime.setCellValueFactory(new PropertyValueFactory<>("Time"));
        CreditTableColumn.setCellValueFactory(new PropertyValueFactory<>("Credit"));
        o_list.setAll(list);
        t_list.setAll(list1);
        HistoryTableView.setItems(t_list);

        ArrayList <Schets> schets = database.getUserWithSchets();
        int index = -1;
        int userID = -1;
        for (int i = 0; i < schets.size(); i++) {
            if (schets.get(i).getUserid() == database.returnId()) {
                index = i;
                userID = schets.get(i).getUserid();
                break;
            }
        }
        System.out.println(index);
        String AmountMoney = Integer.toString(database.getUserWithSchets().get(index).getAmount());
        AmountMoneyData.setText(AmountMoney);
        ArrayList<User> users = database.getUser();
        int id = -1;
        int finalUserID = userID;
        for (int i = 0; i < users.size() ; i++) {
            if (users.get(i).getId() == Database.returnId()) {
                id = i;
                login1 = users.get(i).getLogin();
                Database.getUserIndex(id);
                break;
            }
        }
         TranslateButton.setOnAction(event -> {
            String senderPhone =  SenderNumberPhoneField.getText();
            String recipientPhone = RecipientPhoneNumberLabel.getText();
            int amount = Integer.parseInt(AmountField.getText());
            int a = database.Transfer(senderPhone,recipientPhone,amount);
            AmountMoneyData.setText(Integer.toString(a));
            String recipientLogin = database.getLoginRecipeintForHistory();
            String concat = recipientLogin.concat(" + " + Integer.toString(amount) + " TNG");
            Time time = new Time(54552323L);
            History history = new History(finalUserID,concat,time, Database.getCredit(),login1);
            database.addHistoryWithTransfer(history);
             ArrayList<History> list1 = new Database().getHistory();
            System.out.println(list1);
             ObservableList <History> o_list = FXCollections.observableArrayList();
             ObservableList <History> t_list = FXCollections.observableArrayList();
            o_list.setAll(list);
            t_list.setAll(list1);
             HistoryTableView.setItems(t_list);
        });
        HistoryTableView.setItems(t_list);
        TakeDepositButton.setOnAction(event -> {
            String depositfield = TakeDepositField.getText();
            System.out.println(depositfield);
            int credit = Integer.parseInt(depositfield);
            System.out.println(credit);
            int a = database.addUserCredit(finalUserID,credit);
            if (a != 0) {
                Alert alert = new Alert(Alert.AlertType.INFORMATION);
                alert.setContentText("Succesfully added credit!!!");
                alert.showAndWait();
                Database.saveCredit(a);
                TakeDepositField.setText("");
                AmountMoneyData.setText(Integer.toString(a));
                Time time = new Time(1451665447567L);
                History history = new History(finalUserID,time,credit,login1);
                database.addHistoryWithCredit(history);
            }
            else {
                Alert alert = new Alert(Alert.AlertType.ERROR);
                alert.setContentText("EROR");
                alert.showAndWait();
            }
        });
        System.out.println("GG");
        dataLoginlabel.setText(database.getUser().get(id).getLogin());
        datapasswordLabel.setText(database.getUser().get(id).getPassword());
        System.out.println(dataLoginlabel.getText());
        exitButton.setOnAction(event -> {
            change(exitButton,"sample");
        });
        addemailButton.setOnAction(event -> {
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setContentText("Succesufully add email!!!");
            alert.showAndWait();
            String email = addemailField.getText();
            String login = dataLoginlabel.getText();
            String password = datapasswordLabel.getText();
            database.updateEmail(Database.returnId(),email);
            addemailField.setText("");
        });
        editButton.setOnAction(event -> {
            change(editButton,"edit");
        });
        TransferAnchorPane.setVisible(false);
        profilAnchorPane.setVisible(false);
        MyBankAnchorPane.setVisible(false);
        HistoryAnchorPane.setVisible(false);
        HistoryButton.setOnAction(event -> {
            TableColumnId.setCellValueFactory(new PropertyValueFactory<>("userid"));
            TableColumnLogin.setCellValueFactory(new PropertyValueFactory<>("Login"));
            TableColumnTransfer.setCellValueFactory(new PropertyValueFactory<>("Transfer"));
            TableColumnTime.setCellValueFactory(new PropertyValueFactory<>("Time"));
            CreditTableColumn.setCellValueFactory(new PropertyValueFactory<>("Credit"));
            o_list.setAll(list);
            t_list.setAll(list1);
            HistoryTableView.setItems(t_list);
            MyBankAnchorPane.setVisible(false);
            profilAnchorPane.setVisible(false);
            TransferAnchorPane.setVisible(false);
            HistoryAnchorPane.setVisible(true);
        });
        ProfilButton.setOnAction(event -> {
            MyBankAnchorPane.setVisible(false);
            profilAnchorPane.setVisible(true);
            TransferAnchorPane.setVisible(false);
            HistoryAnchorPane.setVisible(false);
        });
        myBankButton.setOnAction(event -> {
            profilAnchorPane.setVisible(false);
            MyBankAnchorPane.setVisible(true);
            TransferAnchorPane.setVisible(false);
            HistoryAnchorPane.setVisible(false);
        });
        TransferButton.setOnAction(event -> {
             TransferAnchorPane.setVisible(true);
            MyBankAnchorPane.setVisible(false);
            profilAnchorPane.setVisible(false);
            HistoryAnchorPane.setVisible(false);
        });
        ExitButton.setOnAction(event -> {
            change(ExitButton,"sample");
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