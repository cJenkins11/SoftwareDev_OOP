package Sokoban;

/**
 * @author: Callum Jenkins
 * 01/12/2020
 * <p>
 * Class: Wall
 */
/*
import SokobanTest.Sokoban;*/
import javafx.scene.image.Image;

public class Wall extends MapElement {

    private Image image;

    public Wall (int i, int j) {
        super(i, j);
        this.image = new Image(SokobanMain.class.getResourceAsStream("assets/Wall.png"));
    }

    public Image getImage() {
        return this.image;
    }
}