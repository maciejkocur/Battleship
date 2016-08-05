package view;


import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;


public class Gui extends Application {


    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws Exception {


        Parent root = FXMLLoader.load(getClass().getClassLoader().getResource("gui.fxml"));
        Scene scene = new Scene(root, 1200, 800);

        primaryStage.setResizable(false);
        primaryStage.setTitle("Battleship");
        primaryStage.setScene(scene);
        primaryStage.show();

    }


}
