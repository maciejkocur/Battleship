package configuration;

import controller.MainController;
import javafx.fxml.FXMLLoader;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;


import java.io.IOException;
import java.io.InputStream;

/**
 * Created by bartlomiej on 03.08.16.
 */
@Configuration
@ComponentScan
public class BattleshipConfiguration {

    @Bean
    public MainController mainController() throws IOException{
        return loadController(MainController.VIEW);
    }

    private MainController loadController(String url) throws IOException {
        try (InputStream fxmlStream = getClass().getResourceAsStream(url)) {
            FXMLLoader loader = new FXMLLoader();
            loader.load(fxmlStream);
            return loader.getController();
        }
    }
}

