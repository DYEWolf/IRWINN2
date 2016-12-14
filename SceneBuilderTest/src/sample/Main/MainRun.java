package sample.Main;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class MainRun extends Application {


    @Override
    public void start(Stage stage) throws Exception{
        Parent root = FXMLLoader.load(getClass().getResource("MainWindow.fxml"));
        stage.setTitle("Project I.R.WI.N.N");
        stage.setScene(new Scene(root, 400, 300));
        stage.show();

    }

    public static void main(String[] args) {
        launch(args);

    }



}
