/**
 * @author: Callum Jenkins
 * 28/10/2020
 * Class: Main
 * Main logic for pontoon
 */

package Pontoon_GUI;

import javafx.application.Application;
import javafx.beans.property.SimpleBooleanProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Slider;
import javafx.scene.control.Spinner;
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
    private Hand house;
    private Player player;
    private Text alert = new Text();

    private SimpleBooleanProperty playable = new SimpleBooleanProperty(false);
    private SimpleIntegerProperty startingCash = new SimpleIntegerProperty(5000);

    private HBox houseCards = new HBox(20);
    private HBox playerCards = new HBox(20);


    private Parent createMenu() {
        Pane base = new Pane();
        base.setPrefSize(850, 600);
        Region background = new Region();
        background.setPrefSize(850, 600);
        background.setStyle("-fx-background-color: rgba(255,255,255,1)");

        VBox menuBox = new VBox(10);
        HBox startingCashBox = new HBox(5);

        Text title = new Text("PONTOON");
        title.setFont(Font.font("verdana", FontWeight.BOLD, FontPosture.REGULAR, 28));

        Button start = new Button("START");

        Text startingCashText = new Text("BUY IN: ");
        Slider startingCash = new Slider(0, 10000, 50);
        startingCash.setShowTickMarks(true);
        startingCash.setShowTickLabels(true);
        startingCash.setMajorTickUnit(1000);
        startingCash.setBlockIncrement(100);
        startingCash.snapToTicksProperty();

        startingCashBox.getChildren().addAll(startingCashText, startingCash);

        Button exit = new Button("EXIT");

        menuBox.getChildren().addAll(title, startingCashBox, start, exit);

        base.getChildren().addAll(menuBox);

        return base;
    }

    /**
     * Creates game window and function buttons.
     * @return base - Main window that holds game content
     */
    private Parent createContent() {
        house = new Hand(houseCards.getChildren());
        player = new Player(playerCards, startingCash);

        Pane base = new Pane();
        base.setPrefSize(850, 600);
        Region background = new Region();
        background.setPrefSize(850, 600);
        background.setStyle("-fx-background-color: rgba(0,0,0,1)");

        HBox baseLayout = new HBox(5);
        baseLayout.setPadding(new Insets(5, 5, 5, 5));

        Rectangle leftBackground = new Rectangle(550, 560);
        leftBackground.setFill(Color.GREEN);

        Rectangle rightBackground = new Rectangle(285, 560);
        rightBackground.setFill(Color.LIGHTCYAN);

        //LEFT SIDE (GAME TABLE)

        VBox leftBox = new VBox(50);

        Text houseScore = new Text("House: ");
        houseScore.setFont(Font.font("verdana", FontWeight.BOLD, FontPosture.REGULAR, 20));

        Text playerScore = new Text("Player: ");
        playerScore.setFont(Font.font("verdana", FontWeight.BOLD, FontPosture.REGULAR, 20));

        leftBox.getChildren().addAll(houseScore, houseCards, alert, playerCards, playerScore);

        //RIGHT SIDE (GAME BUTTONS)

        VBox rightBox = new VBox(20);
        rightBox.setAlignment(Pos.CENTER);

        Text wagerText = new Text("Wager: £");
        wagerText.setFont(Font.font("verdana", FontWeight.BOLD, FontPosture.REGULAR, 20));
        final Spinner<Integer> wager = new Spinner<>(0, 1000, 50, 50);

        Text cashText = new Text("Cash: £");
        cashText.setFont(Font.font("verdana", FontWeight.BOLD, FontPosture.REGULAR, 20));


        Button play = new Button("PLAY");
        Button hit = new Button("HIT");
        Button stick = new Button("STICK");

        HBox betBox = new HBox(5, wagerText, wager);
        HBox buttonBox = new HBox(15, hit, stick);
        buttonBox.setAlignment(Pos.CENTER);

        rightBox.getChildren().addAll(cashText, betBox, play, buttonBox);


        //ADD LEFT AND RIGHT LAYOUTS TO THE BASE PANE

        baseLayout.getChildren().addAll(new StackPane(leftBackground, leftBox), new StackPane(rightBackground, rightBox));
        base.getChildren().addAll(background, baseLayout);

        wager.disableProperty().bind(playable);
        play.disableProperty().bind(playable);
        hit.disableProperty().bind(playable.not());
        stick.disableProperty().bind(playable.not());

        playerScore.textProperty().bind(new SimpleStringProperty("Player: ").concat(player.getHand().getValue().asString()));
        houseScore.textProperty().bind(new SimpleStringProperty("House: ").concat(house.getValue().asString()));
        cashText.textProperty().bind(new SimpleStringProperty("Cash: £").concat(player.getCash()));

        /**
         * CHECK HANDS. CHANGE LISTENER: (PROPERTY THAT CHANGED*, PREVIOUS VALUE, NEW VALUE)
         * *THE VALUE OF THE HANDS
         */
        //player goes bust
        player.getHand().getValue().addListener((obs, oldValue, newValue) -> {
            if (newValue.intValue() >= 21) {
                stopGame();
            }
        });

        /*//5 card trick
        player.getHand().getNumberCards().addListener((obs, oldValue, newValue) -> {
            if (newValue.intValue() == 5){
                stopGame();
            }
        });*/

        //house goes bust
        house.getValue().addListener((obs, oldValue, newValue) -> {
            if (newValue.intValue() >= 21) {
                stopGame();
            }
        });

        player.getCash().addListener((obs, oldValue, newValue) -> {
            if (newValue.intValue() <= 0) {
                finishGame();
            }
        });

        /**
         * Play button starts game
         */

        play.setOnAction(event -> {
            player.setBet(wager.getValue());
            startGame();
        });

        /**
         * When player hits, player takes a drawn card
         */
        hit.setOnAction(event -> {
            player.getHand().takeCard(deck.drawCard());
        });

        /**
         * When player sticks, house draws to try beat the player
         */
        stick.setOnAction(event -> {
            while (house.getValue().get() < player.getHand().getValue().get()) {
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
        player.getHand().reset();

        house.takeCard(deck.drawCard());
        house.takeCard(deck.drawCard());
        player.getHand().takeCard(deck.drawCard());
        player.getHand().takeCard(deck.drawCard());
    }

    public void stopGame() {
        playable.set(false);

        int houseValue = house.getValue().get();
        int playerValue = player.getHand().getValue().get();
        String winner = "Exceptional case: h: " + houseValue + " p: " + playerValue;

        if (houseValue == 21 || playerValue > 21 || houseValue == playerValue
                || (houseValue < 21 && houseValue > playerValue)) {
            player.collectWinnings(-player.getBet());
            winner = "HOUSE";
        }
        else if (playerValue == 21 || houseValue > 21 || playerValue > houseValue) {
            player.collectWinnings(player.getBet());
            winner = "PLAYER";
        }

        player.setBet(0);
        alert.setText(winner + " wins!");
    }


    private void finishGame() {

    }

    public void start(Stage primaryStage) throws Exception {
        primaryStage.setScene(new Scene(createContent()));
        //primaryStage.setScene(new Scene(createMenu()));
        primaryStage.setWidth(865);
        primaryStage.setHeight(600);
        primaryStage.setResizable(false);
        primaryStage.setTitle("Pontoon");
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }

}
