package controller;

import components.ClientFactory;
import components.Ship;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.input.*;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Pane;
import model.Coordinates;
import model.client.Client;

/**
 * Created by bartlomiej on 19.07.16.
 */
public class GuiController {
    @FXML
    public Pane shipsContainer;
    @FXML
    public GridPane userBoard;
    @FXML
    public AnchorPane rootPane;


    private Ship invship;
    private Ship movableShip;
    private DataFormat dataFormat = new DataFormat("Ship");
    private EventHandler<DragEvent> shipDragOverRoot;
    private EventHandler<DragEvent> shipDragDropped;
    private EventHandler<DragEvent> shipDragOverUserBoard;
    private Coordinates coordinates;
    private Client client;

    @FXML
    private void fireAway(ActionEvent event) {
        Node source = (Node) event.getSource();
        client = ClientFactory.getClient();
        source.setOpacity(1.0);
        coordinates = Coordinates.getCoordinates();

        System.out.println("Hello " + "This is the row : " + GridPane.getRowIndex(source) + "\nAnd column: " + GridPane.getColumnIndex(source));
        coordinates.setPlayerId(client.toString());
        coordinates.setX(GridPane.getRowIndex(source));
        coordinates.setY(GridPane.getRowIndex(source));

        source.setDisable(true);
    }

    @FXML
    public void initialize() {
        userBoard.toFront();
        Ship ship = new Ship();
        shipsContainer.getChildren().add(ship);
        addDragDetection(ship);
        buildDragHandlers();
        for (int i = 0; i < 10; i++) {
            for (int j = 0; j < 10; j++) {
                Pane label = new Pane();
                label.setOnDragDropped(event -> {
                    event.acceptTransferModes(TransferMode.ANY);
                    System.out.println(GridPane.getRowIndex(label) + " " + GridPane.getColumnIndex(label));
                });
                userBoard.getChildren().add(label);
                GridPane.setColumnIndex(label, i);
                GridPane.setRowIndex(label, j);
            }

        }

    }

    private void addDragDetection(Ship ship) {

        ship.setOnDragDetected(new EventHandler<MouseEvent>() {

            @Override
            public void handle(MouseEvent event) {
                System.out.println("test");
                rootPane.setOnDragOver(shipDragOverRoot);
                userBoard.setOnDragOver(shipDragOverUserBoard);
                userBoard.setOnDragDropped(shipDragDropped);

                movableShip = (Ship) event.getSource();
                invship = ((Ship) event.getSource()).clone();
                rootPane.getChildren().add(invship);
                System.out.println(invship);
                ClipboardContent content = new ClipboardContent();
                content.put(dataFormat, movableShip);
                invship.relocate(event.getSceneX() - invship.getWidth() / 2, event.getSceneY() - invship.getHeight() / 4);
                invship.setMouseTransparent(true);
                invship.startDragAndDrop(TransferMode.ANY).setContent(content);
                invship.setVisible(true);
                invship.toFront();

                movableShip.setVisible(false);
                Pane group = (Pane) movableShip.getParent();
                group.getChildren().remove(movableShip);
                event.consume();
            }
        });

    }

    private void buildDragHandlers() {

        shipDragOverRoot = new EventHandler<DragEvent>() {

            @Override
            public void handle(DragEvent event) {
                event.acceptTransferModes(TransferMode.ANY);
                invship.relocate(event.getSceneX() - invship.getWidth() / 2, event.getSceneY() - invship.getHeight() / 4);
                event.consume();
            }
        };

        shipDragOverUserBoard = new EventHandler<DragEvent>() {

            @Override
            public void handle(DragEvent event) {
                event.acceptTransferModes(TransferMode.ANY);
                invship.relocate(event.getSceneX() - invship.getWidth() / 2, event.getSceneY() - invship.getHeight() / 4);
                event.consume();
            }
        };

        shipDragDropped = new EventHandler<DragEvent>() {

            @Override
            public void handle(DragEvent event) {
                event.acceptTransferModes(TransferMode.ANY);
                event.consume();
            }
        };


    }
}
