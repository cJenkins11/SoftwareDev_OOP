package Pontoon;

public class Dealer {

    private int houseHand;

    /*
    On construction, generate a number between 16-21
    */
    public Dealer() {
        this.houseHand = (int)(Math.random()*6) + 16;
    }

    /*
    Return house number to beat
    */
    public int GetHouseHand() {
        return this.houseHand;
    }

    /*
    Check player total against dealer
    Returns true if player wins
    */
    public boolean GetResult(int playerTotal){
        boolean win;

        win = playerTotal >= this.houseHand;

        return win;
    }

}
