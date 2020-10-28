package Pontoon;

public class Card {

    private Suits suit;
    private Ranks rank;

    public Card(Suits suit, Ranks rank) {
        this.suit = suit;
        this.rank = rank;
    }

    public void displayCard() {
        System.out.println(rank + " of " + suit);
    }

    /*private int value;


    //On construction assign a value from 1-10 to the card

    public Card() {
        this.value = RandomCardValue();
    }


    //Generate number from 1-10

    private int RandomCardValue() {
        return (int)(Math.random()*10) + 1;
    }


    //Return card value

    public int GetValue() {

        return this.value;
    }*/
}
