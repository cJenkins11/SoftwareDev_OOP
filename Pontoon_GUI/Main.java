/**
 * @author: Callum Jenkins
 * 28/10/2020
 * Class: Main
 * Main logic for pontoon
 */

package Pontoon_GUI;

import javafx.application.Application;
import javafx.beans.property.SimpleBooleanProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.Region;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.*;
import javafx.stage.Stage;

public class Main extends Application {

    private Deck deck = new Deck();
    private Hand house, player;
    private Text alert = new Text();

    private SimpleBooleanProperty playable = new SimpleBooleanProperty(false);

    private HBox houseCards = new HBox(20);
    private HBox playerCards = new HBox(20);

    /**
     * Creates game window and function buttons.
     * @return base - Main window that holds game content
     */
    private Parent createContent() {
        house = new Hand(houseCards.getChildren());
        player = new Hand(playerCards.getChildren());

        Pane base = new Pane();
        base.setPrefSize(800, 600);
        Region background = new Region();
        background.setPrefSize(800, 600);
        background.setStyle("-fx-background-color: rgba(0,0,0,1)");

        HBox baseLayout = new HBox(5);
        baseLayout.setPadding(new Insets(5, 5, 5, 5));

        Rectangle leftBackground = new Rectangle(550, 560);
        leftBackground.setFill(Color.GREEN);

        Rectangle rightBackground = new Rectangle(230, 560);
        rightBackground.setFill(Color.ORANGE);

        //LEFT SIDE

        VBox leftBox = new VBox(50);

        Text houseScore = new Text("House: ");
        houseScore.setFont(Font.font("verdana", FontWeight.BOLD, FontPosture.REGULAR, 20));

        Text playerScore = new Text("Player: ");
        playerScore.setFont(Font.font("verdana", FontWeight.BOLD, FontPosture.REGULAR, 20));

        leftBox.getChildren().addAll(houseScore, houseCards, alert, playerCards, playerScore);

        //RIGHT SIDE

        VBox rightBox = new VBox(20);
        rightBox.setAlignment(Pos.CENTER);

/*
        final TextField bet = new TextField("BET");
        bet.setDisable(true);
        bet.setMaxWidth(50);
*/
//      Text money = new Text("MONEY");

        Button play = new Button("PLAY");
        Button hit = new Button("HIT");
        Button stick = new Button("STICK");

        HBox buttonBox = new HBox(15, hit, stick);
        buttonBox.setAlignment(Pos.CENTER);

        rightBox.getChildren().addAll(play, buttonBox);

        //ADD LEFT AND RIGHT LAYOUTS TO THE BASE PANE

        baseLayout.getChildren().addAll(new StackPane(leftBackground, leftBox), new StackPane(rightBackground, rightBox));
        base.getChildren().addAll(background, baseLayout);

        play.disableProperty().bind(playable);
        hit.disableProperty().bind(playable.not());
        stick.disableProperty().bind(playable.not());

        playerScore.textProperty().bind(new SimpleStringProperty("Player: ").concat(player.getValue().asString()));
        houseScore.textProperty().bind(new SimpleStringProperty("House: ").concat(house.getValue().asString()));



        player.getValue().addListener((obs, oldValue, newValue) -> {
            if (newValue.intValue() >= 21) {
                stopGame();
            }
        });

        house.getValue().addListener((obs, oldValue, newValue) -> {
            if (newValue.intValue() >= 21) {
                stopGame();
            }
        });

        play.setOnAction(event -> {
            startGame();
        });

        hit.setOnAction(event -> {
            player.takeCard(deck.drawCard());
        });

        stick.setOnAction(event -> {
            while (house.getValue().get() < 17) {
                house.takeCard(deck.drawCard());
            }
            stopGame();
        });

        return base;
    }

    /**
     * Makes buttons usable, clears any messages, refills the deck of cards,
     * and draws 2 cards each for player and house.
     */
    private void startGame() {
        playable.set(true);
        alert.setText("");

        deck.reloadDeck();
        house.reset();
        player.reset();

        house.takeCard(deck.drawCard());
        house.takeCard(deck.drawCard());
        player.takeCard(deck.drawCard());
        player.takeCard(deck.drawCard());
    }

    public void stopGame() {
        playable.set(false);

        int houseValue = house.getValue().get();
        int playerValue = player.getValue().get();
        String winner = "Exceptional case: h: " + houseValue + " p: " + playerValue;

        if (houseValue == 21 || playerValue > 21 || houseValue == playerValue
                || (houseValue < 21 && houseValue > playerValue)) {
            winner = "HOUSE";
        }
        else if (playerValue == 21 || houseValue > 21 || playerValue > houseValue) {
            winner = "PLAYER";
        }

        alert.setText(winner + " wins!");
    }

    public void start(Stage primaryStage) throws Exception {
        primaryStage.setScene(new Scene(createContent()));
        primaryStage.setWidth(800);
        primaryStage.setHeight(600);
        primaryStage.setResizable(false);
        primaryStage.setTitle("Pontoon");
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }

}
