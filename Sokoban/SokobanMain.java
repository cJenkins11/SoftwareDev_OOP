package Sokoban;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
/**
 * @author: Callum Jenkins
 * 08/11/2020
 * <p>
 * Class: Main
 */

public class SokobanMain extends Application {

    private static final int WIDTH = 700;
    private static final int HEIGHT = 500;

    @Override
    public void start(Stage stage) throws Exception {
        Parent loader = FXMLLoader.load(getClass().getResource("Menu.fxml"));
        stage.setTitle("SOKOBAN");
        stage.setScene(new Scene(loader, WIDTH, HEIGHT));
        stage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }

}
