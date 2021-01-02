package Sokoban;


import javafx.scene.image.Image;

/**
 * @author: Callum Jenkins
 * 09/11/2020
 * <p>
 * Class: Crate
 */

public class Crate extends MapElement {

    private Image image;

    public Crate(int i, int j) {
        super(i, j);
        this.image = new Image(SokobanMain.class.getResourceAsStream("assets/Crate.png"));
    }

    @Override
    public Image getImage() {
        return this.image;
    }

}
