import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.IOException;


public class Gui extends Application {

    private static Logger logger = LogManager.getLogger(Gui.class);

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        try {
            Parent root = FXMLLoader.load(getClass().getClassLoader().getResource("gui.fxml"));
            Scene scene = new Scene(root, 1200, 800);
            primaryStage.setResizable(false);
            primaryStage.setTitle("Battleship");
            primaryStage.setScene(scene);
            primaryStage.show();
        } catch (IOException e) {
            logger.error(e.getMessage());
        }
    }
}
