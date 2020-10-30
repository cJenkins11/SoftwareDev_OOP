/**
 * @author: Callum Jenkins
 * 29/10/2020
 * Class: Card
 * Used for displaying cards and storing rank and suit values
 */

package Pontoon_GUI;

import javafx.scene.Parent;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Text;

public class Card extends Parent {

    public final Suit suit;
    public final Rank rank;
    public final int value;

    /**
     * Card suits
     */
    enum Suit {DIAMONDS, HEARTS, CLUBS, SPADES};

    /**
     * Card ranks and values
     */
    enum Rank {
        TWO(2),
        THREE(3),
        FOUR(4),
        FIVE(5),
        SIX(6),
        SEVEN(7),
        EIGHT(8),
        NINE(9),
        TEN(10),
        JACK(10),
        QUEEN(10),
        KING(10),
        ACE(11);

        final int value;

        /**
         * Sets card value based on its rank
         * @param value - Integer value of card rank
         */
        private Rank(int value) {
            this.value = value;
        }
    };

    /**
     * Constructor:
     * Sets card properties and sets how the card will look in the GUI
     * @param suit - Suit of the card
     * @param rank - Rank of the card
     */
    public Card(Suit suit, Rank rank) {
        this.suit = suit;
        this.rank = rank;
        this.value = rank.value;

        Rectangle cardBack = new Rectangle(80, 100);
        cardBack.setArcHeight(20);
        cardBack.setArcWidth(20);
        cardBack.setFill(Color.WHITE);

        Text text = new Text(toString());
        text.setWrappingWidth(70);

        getChildren().add(new StackPane(cardBack, text));
    }

    public String toString() {
        return rank.toString() + " of " + suit.toString();
    }

}
