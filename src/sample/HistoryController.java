package sample;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;

import java.sql.Date;
import java.util.ArrayList;

public class HistoryController {

    @FXML
    private TableColumn<History, Integer> TableColumnId;

    @FXML
    private TableColumn<History, Integer> CreditTableColumn;

    @FXML
    private TableView<History> HistoryTableView;

    @FXML
    private TableColumn<History, String> TableColumnLogin;

    @FXML
    private TableColumn<?, ?> TableColumnTransfer;

    @FXML
    private Label labelHistory;
    private ArrayList<History> list = new Database().getHistory();
    @FXML
    private ArrayList<History> list1 = new Database().getHistory();
    @FXML
    private TableColumn<History, Date> TableColumnTime;

    private ObservableList<History> o_list = FXCollections.observableArrayList();
    private ObservableList <History> t_list = FXCollections.observableArrayList();

    public void initialize() {
        TableColumnId.setCellValueFactory(new PropertyValueFactory<>("id"));
        TableColumnLogin.setCellValueFactory(new PropertyValueFactory<>("Login"));
        TableColumnTransfer.setCellValueFactory(new PropertyValueFactory<>("Transfer"));
        TableColumnTime.setCellValueFactory(new PropertyValueFactory<>("Time"));
        CreditTableColumn.setCellValueFactory(new PropertyValueFactory<>("Credit"));
        o_list.setAll(list);
        t_list.setAll(list1);
        HistoryTableView.setItems(t_list);
    }
}
