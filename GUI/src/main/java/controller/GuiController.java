package controller;

import components.Ship;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.input.ClipboardContent;
import javafx.scene.input.DataFormat;
import javafx.scene.input.DragEvent;
import javafx.scene.input.TransferMode;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Pane;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;


/**
 * Created by bartlomiej on 19.07.16.
 */
public class GuiController {
    private static Logger log = LogManager.getLogger(GuiController.class);
    private final int BOARD_SIZE = 10;
    @FXML
    public FlowPane shipsContainer;
    @FXML
    public GridPane userBoard;
    @FXML
    public AnchorPane rootPane;

    private Ship invShip;
    private Ship movableShip;
    private DataFormat dataFormat = new DataFormat("Ship");

    private int userBoardColumn;
    private int userBoardRow;


    @FXML
    private void fireAway(ActionEvent event) {
        Node source = (Node) event.getSource();
        source.setOpacity(1.0);
        log.info("Hello " + "This is the row : " + GridPane.getRowIndex(source) + "\nAnd column: " + GridPane.getColumnIndex(source));
        source.setDisable(true);
    }

    public void allShipsCoordinates() {
        userBoard.getChildren().stream().filter(node -> node instanceof Ship).forEach(node -> {
            Ship ship = (Ship) node;
            log.info(ship.getCoordinates());
        });
    }

    @FXML
    public void initialize() {

        userBoard.toFront();
        Ship ship = new Ship();
        Ship ship1 = new Ship();
        shipsContainer.getChildren().add(ship);
        shipsContainer.getChildren().add(ship1);

        addDragDetection(ship);
        addDragDetection(ship1);
        userBoardInit();
        rootPane.setOnDragOver(shipDragOverRoot());
        rootPane.setOnDragDropped(shipOnDragDroppedOnRoot());
        userBoard.setOnDragDropped(shipDragDropped());
    }

    private void addDragDetection(Ship ship) {
        ship.setOnDragDetected(event -> {
            log.info("Drag Detected");
            movableShip = (Ship) event.getSource();
            if (event.isSecondaryButtonDown()) {
                movableShip.rotateShip();
            }

            invShip = movableShip.clone();

            rootPane.getChildren().add(invShip);
            ClipboardContent content = new ClipboardContent();
            content.put(dataFormat, movableShip);
            invShip.relocate(event.getSceneX() - invShip.getMaxWidth() / 2, event.getSceneY() - invShip.getMaxWidth() / 4);
            invShip.setMouseTransparent(true);
            invShip.startDragAndDrop(TransferMode.ANY).setContent(content);
            invShip.setVisible(true);
            invShip.toFront();

            Pane group = (Pane) movableShip.getParent();
            group.getChildren().remove(movableShip);
            event.consume();
        });
    }


    private EventHandler<DragEvent> shipDragOverRoot() {
        return event -> {
            event.acceptTransferModes(TransferMode.ANY);
            invShip.relocate(event.getSceneX() - invShip.getWidth() / 4, event.getSceneY() - invShip.getHeight() / 3);
            event.consume();
        };
    }

    private EventHandler<DragEvent> shipOnDragDroppedOnRoot() {
        return event -> {
            invShip.toBack();
            rootPane.getChildren().remove(invShip);
            shipsContainer.getChildren().add(movableShip);
            movableShip.setVisible(true);
            if (!movableShip.isOrientationVertical())
                movableShip.rotateShip();
            event.consume();
        };
    }

    private EventHandler<DragEvent> shipDragDropped() {
        return event -> {
            event.acceptTransferModes(TransferMode.ANY);
            invShip.toBack();
            if ((movableShip.isOrientationVertical() ? userBoardRow : userBoardColumn) + movableShip.countToSpawn() < BOARD_SIZE) {
                rootPane.getChildren().remove(invShip);
                userBoard.getChildren().add(movableShip);
                movableShip.generateCoordinates(userBoardColumn, userBoardRow);
                GridPane.setRowIndex(movableShip, userBoardRow);
                GridPane.setColumnIndex(movableShip, userBoardColumn);
                if (movableShip.isOrientationVertical()) {
                    GridPane.setRowSpan(movableShip, movableShip.countToSpawn() + 1);
                    GridPane.setColumnSpan(movableShip, 1);
                } else {
                    GridPane.setRowSpan(movableShip, 1);
                    GridPane.setColumnSpan(movableShip, movableShip.countToSpawn() + 1);
                }
                movableShip.setVisible(true);
                event.consume();
            }
        };
    }

    private void userBoardInit() {
        for (int i = 0; i < BOARD_SIZE; i++) {
            for (int j = 0; j < BOARD_SIZE; j++) {
                Pane label = new Pane();
                label.setOnDragDropped(event -> {
                    event.acceptTransferModes(TransferMode.ANY);
                    userBoardColumn = GridPane.getColumnIndex(label);
                    userBoardRow = GridPane.getRowIndex(label);
                });
                userBoard.getChildren().add(label);
                GridPane.setColumnIndex(label, i);
                GridPane.setRowIndex(label, j);
            }
        }
    }
}
