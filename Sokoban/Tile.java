package Sokoban;

import javafx.scene.image.Image;

/**
 * @author: Callum Jenkins
 * 09/11/2020
 * <p>
 * Class: Tile
 */

public class Tile extends MapElement {

    private Image image;

    public Tile(int i, int j) {
        super(i, j);
        this.image = new Image(SokobanMain.class.getResourceAsStream("assets/Floor.png"));
    }

    public Image getImage() {
        return this.image;
    }
}
