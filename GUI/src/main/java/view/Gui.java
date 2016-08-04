package view;

import controller.MainController;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import model.Player;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

/**
 * Created by DELL on 2016-07-18.
 */
@SpringBootApplication
public class Gui extends Application{

    private static String [] args;
    private Player player;


    @Override
    public void start(Stage primaryStage) throws Exception {
        player = Player.getPlayer();
        ApplicationContext context = SpringApplication.run(Gui.class,args);
       // MainController mainController = context.getBean(MainController.class);
        Parent root = FXMLLoader.load(getClass().getClassLoader().getResource("gui.fxml"));
        Scene scene = new Scene(root, 1200, 800);
       // Scene scene = new Scene((Parent) mainController.getRoot());


        primaryStage.setResizable(false);
        primaryStage.setTitle("Battleship");
        primaryStage.setScene(scene);
        primaryStage.show();
        }




    public static void main(String[] args){
        Gui.args=args;
        launch(args);
    }
}
