/**
 * @author: Callum Jenkins
 * 27/10/2020
 * Class: Deck
 */

package Pontoon_GUI;

import Pontoon_GUI.Card.Rank;
import Pontoon_GUI.Card.Suit;

public class Deck {

    private Card[] cards = new Card[52];

    public Deck() {
        reloadDeck();
    }

    public final void reloadDeck() {
        int i = 0;
        for (Suit suit : Suit.values())
        {
            for (Rank rank : Rank.values())
            {
                cards[i++] = new Card(suit, rank);
            }
        }
    }

    public Card drawCard() {
        Card card = null;
        while (card == null)
        {
            int index = (int)(Math.random()*cards.length);
            card = cards[index];
            cards[index] = null;
        }
        return card;
    }

}
