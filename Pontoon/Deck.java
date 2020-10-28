package Pontoon;

/**
 * @author: Callum Jenkins
 * 27/10/2020
 * <p>
 * Class: Deck
 */

public class Deck {

    private Card[] cards;

    public Deck() {
        this.cards = new Card[52];
        int cardCount = 0;
        for (Suits s : Suits.values())
        {
            for (Ranks r : Ranks.values())
            {
                Card c = new Card(s, r);
                this.cards[cardCount] = c;
                cardCount++;
            }
        }
    }

    public Card[] getCards() {
        return this.cards;
    }



}
