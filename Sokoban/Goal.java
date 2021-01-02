package Sokoban;

/*import SokobanTest.Sokoban;
import SokobanTest2.MapElement;*/

import javafx.scene.image.Image;

/**
 * @author: Callum Jenkins
 * 09/11/2020
 * <p>
 * Class: Goal
 */

public class Goal extends MapElement {

    private final Image image;

    public Goal(int i, int j) {
        super(i, j);

        this.image = new Image(SokobanMain.class.getResourceAsStream("assets/Diamond.png"));
    }

    @Override
    public Image getImage() {
        return this.image;
    }

}
