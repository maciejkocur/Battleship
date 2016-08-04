package controller;

import javafx.fxml.FXML;
import javafx.scene.Node;
import org.springframework.stereotype.Component;


import javax.annotation.PostConstruct;

/**
 * Created by bartlomiej on 03.08.16.
 */

@Component
public class MainController {
    public static final String VIEW = "gui.fxml";

    @FXML
    private Node root;

    @PostConstruct
    public void init(){}

    public Node getRoot(){
        return root;
    }
}
