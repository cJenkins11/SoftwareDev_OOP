/*
package Sokoban;

import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.*;
import javafx.scene.text.Text;
import javafx.stage.Stage;

import java.io.IOException;

*/
/**
 * @author: Callum Jenkins
 * 08/11/2020
 * <p>
 * Class: Controller
 *//*


public class LevelSelectController {

    private HBox hbox;
    private VBox vbox;
    private Level level;
    private Button undo;
    private Button reset;
    private Button exit;
    //private Text movesText;

    public void loadLevel(ActionEvent actionEvent) throws IOException {

        Object node = actionEvent.getSource();
        Button b = (Button) node;

        AnchorPane root = new AnchorPane();
        Stage stage = (Stage) ((Node)actionEvent.getSource()).getScene().getWindow();

        level = new Level(b.getText());
        */
/*ReadFile filereader = new ReadFile();
        filereader.run("1");
        System.out.println(filereader.toString());*//*


        hbox = new HBox();
        vbox = new VBox();

        undo = new Button("UNDO");

        reset = new Button("RESET");
        reset.setOnAction(e -> {
            try {
                level.loadMap();
                level.getMoveCount().setValue(0);
                level.getMoveText().textProperty().bind(new SimpleStringProperty("# of Moves: 0"));
            } catch (IOException ioException) {
                ioException.printStackTrace();
            }
        });

        exit = new Button("EXIT");
        exit.setOnAction(e -> {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("LevelSelect.fxml"));
            try {
                stage.setScene(new Scene(loader.load()));
            } catch (IOException ioException) {
                ioException.printStackTrace();
            }
        });

        Button test = new Button("SWAP UP");
        test.setOnAction(e -> {

            System.out.println(level.getPlayerCharacter().getPosition().getY());
            System.out.println(level.getPlayerCharacter().getPosition().getX());

            level.swap(level.getPlayerCharacter(), MovementDirections.UP);

            System.out.println(level.getPlayerCharacter().getPosition().getY());
            System.out.println(level.getPlayerCharacter().getPosition().getX());

        });

        Button test2 = new Button("SWAP RIGHT");
        test2.setOnAction(e -> {

            System.out.println(level.getPlayerCharacter().getPosition().getY());
            System.out.println(level.getPlayerCharacter().getPosition().getX());

            level.swap(level.getPlayerCharacter(), MovementDirections.RIGHT);

            System.out.println(level.getPlayerCharacter().getPosition().getY());
            System.out.println(level.getPlayerCharacter().getPosition().getX());
        });

        Button test3 = new Button("SWAP DOWN");
        test3.setOnAction(e -> {

            System.out.println(level.getPlayerCharacter().getPosition().getY());
            System.out.println(level.getPlayerCharacter().getPosition().getX());

            level.swap(level.getPlayerCharacter(), MovementDirections.DOWN);

            System.out.println(level.getPlayerCharacter().getPosition().getY());
            System.out.println(level.getPlayerCharacter().getPosition().getX());
        });

        Button test4 = new Button("SWAP LEFT");
        test4.setOnAction(e -> {

            System.out.println(level.getPlayerCharacter().getPosition().getY());
            System.out.println(level.getPlayerCharacter().getPosition().getX());

            level.swap(level.getPlayerCharacter(), MovementDirections.LEFT);

            System.out.println(level.getPlayerCharacter().getPosition().getY());
            System.out.println(level.getPlayerCharacter().getPosition().getX());
        });

        Button test5 = new Button("CHECK GOALS");
        test5.setOnAction(e -> {
            level.checkGoals();
            System.out.println(level.hasWon());
            System.out.println("PC(" + level.getPlayerCharacter().getPosition().getX() + ", " + level.getPlayerCharacter().getPosition().getY() + ")");
        });


        vbox.getChildren().addAll(level.getMoveText(), undo, reset, exit, test, test2, test3, test4, test5);
        hbox.getChildren().addAll(vbox, level.getGrid());
        root.getChildren().addAll(hbox);

        stage.setScene(new Scene(root, 810, 400));
    }
}
*/
