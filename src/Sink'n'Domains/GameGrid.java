package Sink

/**
 * @author: Callum Jenkins
 * 04/10/2020
 * <p>
 * Class: GameGrid
 */

public class GameGrid {

    private int[][] gameboard;

    public GameGrid() {
        gameboard = new int[7][7];
    }

    public enum Cells {
        A1, A2, A3, A4, A5, A6, A7,
        B1, B2, B3, B4, B5, B6, B7,
        C1, C2, C3, C4, C5, C6, C7,
        D1, D2, D3, D4, D5, D6, D7,
        E1, E2, E3, E4, E5, E6, E7,
        F1, F2, F3, F4, F5, F6, F7,
        G1, G2, G3, G4, G5, G6, G7,
    }

}
