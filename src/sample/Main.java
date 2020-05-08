package sample;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.Socket;

public class Main extends Application {

        public static Socket socket;
        static {
            try {
                socket = new Socket("127.0.0.1",23456);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

    public void start(Stage primaryStage) throws Exception{
        Parent root = FXMLLoader.load(getClass().getResource("sample.fxml"));
        primaryStage.setTitle("DATABASE");
        primaryStage.setScene(new Scene(root, 834, 600));
        primaryStage.show();
        primaryStage.setResizable(false);
        //primaryStage.setFullScreen(true);
    }


    public static void main(String[] args) {
        launch(args);
    }
}