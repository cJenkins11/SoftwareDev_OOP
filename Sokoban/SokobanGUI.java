package Sokoban;

import javafx.application.Application;
import javafx.beans.property.SimpleBooleanProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Insets;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Tooltip;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Font;
import javafx.scene.text.FontPosture;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.stage.Stage;

import java.util.List;

/**
 * @author: Callum Jenkins
 * 09/01/2021
 * <p>
 * Class: SokobanGUI
 */

public class SokobanGUI extends Application {

    private GridPane gridPane;
    private GridMovement grid;
    //private Gameplay gameplay;


    private VBox menuBox;
    private VBox gridBox;
    private HBox layoutBox;
    private ChoiceBox levelSelect;
    private Text moveCounterText;
    private Text winningMessage;
    private String level;

    private SimpleIntegerProperty moveCount = new SimpleIntegerProperty();
    private SimpleStringProperty moves = new SimpleStringProperty("Moves: ");



    public static void main(String[] args) {
        launch(SokobanGUI.class, args);
    }



    public void init(String level) {
        //this.gameplay = gameplay;
        this.level = level;
    }

    /*private Gameplay getGameplay() {
        return this.gameplay;
    }*/

    @Override
    public void start(Stage stage) throws Exception {


        Parent root = FXMLLoader.load(getClass().getResource("SokobanGUI.fxml"));

        menuBox = lookupNode(root, "#menuBox", VBox.class);
        layoutBox = lookupNode(root, "#layoutBox", HBox.class);


        Text instructions = new Text("GOAL:" +
                "\n\nMove all the crates to the " +
                "\ngoals marked by a red circle." +
                "\n\nRULES:" +
                "\n\nCrates can only be pushed " +
                "\nif there is nothing blocking " +
                "\nits path." +
                "\n\nCONTROLS:" +
                "\n\nMovement : Arrow keys" +
                "\nRestart: R" +
                "\n\n\n");

        instructions.setFont(Font.font("verdana", FontWeight.BOLD, FontPosture.REGULAR, 16));


        moveCounterText = new Text("Moves: #");
        moveCounterText.setFont(Font.font("verdana", FontWeight.BOLD, FontPosture.REGULAR, 16));


        menuBox.getChildren().addAll(instructions, moveCounterText);

        gridBox = new VBox();
        gridPane = new GridPane();
        winningMessage = new Text();

        gridPane.setFocusTraversable(true);

        levelSelect = lookupNode(root, "#levelSelect", ChoiceBox.class);
        levelSelect.setTooltip(new Tooltip("Select a level"));
        levelSelect.getItems().add("1");
        levelSelect.getItems().add("2");
        levelSelect.getItems().add("3");
        levelSelect.getItems().add("4");
        levelSelect.getItems().add("5");

        levelSelect.setOnAction((event) -> {
            grid = null;
            gridPane.getChildren().clear();

            grid = new GridMovement((String) levelSelect.getValue());

            moveCounterText.textProperty().bind(moves.concat(grid.getMoveCount().asString()));

            drawMap();
            this.level = levelSelect.getValue().toString();
        });

        gridBox.getChildren().addAll(gridPane, winningMessage);
        layoutBox.getChildren().addAll(gridBox);
        levelSelect.setFocusTraversable(false);

        gridPane.setOnKeyPressed(e -> {
            if (e.getCode() == KeyCode.UP) {

                grid.move(MovementDirections.UP);
                drawMap();

            } else if (e.getCode() == KeyCode.DOWN) {

                grid.move(MovementDirections.DOWN);
                drawMap();

            } else if (e.getCode() == KeyCode.LEFT) {

                grid.move(MovementDirections.LEFT);
                drawMap();

            } else if (e.getCode() == KeyCode.RIGHT) {

                grid.move(MovementDirections.RIGHT);
                drawMap();

            } else if (e.getCode() == KeyCode.R) {
                grid = new GridMovement(this.level);
                moveCount.setValue(0);
                moveCounterText.textProperty().bind(moves.concat(grid.getMoveCount().asString()));
                drawMap();
            }


        });

        stage.setScene(new Scene(root, 950, 500));
        stage.show();
    }

    public void incrementMoves() {
        this.moveCount.setValue((moveCount.getValue() + 1));
        updateMoveText();
    }

    private void updateMoveText() {
        this.moveCounterText.textProperty().bind(moves.concat(this.moveCount.getValue().toString()));
    }


    private <T extends Node> T lookupNode(Node root, String selector, Class<T> c) {
        Node node = root.lookup(selector);
        return (c.isInstance(node) ? (T) node : null);
    }


    public void drawMap() {
        ImageView iv = null;
        char[][] charGrid = grid.getLevelGrid().getGrid();

        for (int i = 0; i < charGrid.length; i++) {
             for (int j = 0; j < charGrid[0].length; j++) {

                 switch (charGrid[i][j]) {
                     case 'X' : {

                         iv = new ImageView(new Image(SokobanGUI.class.getResourceAsStream("assets/Wall.png")));
                         gridPane.add(iv, j, i, 1, 1);
                         break;
                     }

                     case ' ' : {

                         iv = new ImageView(new Image(SokobanGUI.class.getResourceAsStream("assets/Floor.png")));
                         gridPane.add(iv, j, i, 1, 1);
                         break;
                     }

                     case '*' : {

                         iv = new ImageView(new Image(SokobanGUI.class.getResourceAsStream("assets/Crate.png")));
                         gridPane.add(iv, j, i, 1, 1);
                         break;
                     }

                     case '.' : {

                         iv = new ImageView(new Image(SokobanGUI.class.getResourceAsStream("assets/Diamond.png")));
                         gridPane.add(iv, j, i, 1, 1);
                         break;
                     }

                     case '@' :
                         case '+' : {
                         iv = new ImageView(new Image(SokobanGUI.class.getResourceAsStream("assets/WarehouseKeeper.png")));
                         gridPane.add(iv, j, i, 1, 1);
                         break;
                     }

                     case '$' :  {

                         iv = new ImageView(new Image(SokobanGUI.class.getResourceAsStream("assets/CrateInPlace.png")));
                         gridPane.add(iv, j, i, 1, 1);
                         break;
                     }
                 }
             }
        }
        if (grid.hasWon()) {
            winningMessage.setFont(Font.font("verdana", FontWeight.BOLD, FontPosture.REGULAR, 16));
            this.winningMessage.textProperty().setValue("Congratulations! You beat this level in: ".concat(this.moveCount.getValue().toString() + " moves"));
        }
    }

}
