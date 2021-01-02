package Sokoban;

//import SokobanTest.Sokoban;
import javafx.scene.image.Image;

/**
 * @author: Callum Jenkins
 * 09/11/2020
 * <p>
 * Class: PlayerCharacter
 */

public class PlayerCharacter extends MapElement {

    private Image image;

    public PlayerCharacter(int i, int j) {
        super(i, j);
        this.image = new Image(SokobanMain.class.getResourceAsStream("assets/WarehouseKeeper.png"));
    }

    @Override
    public Image getImage() {
        return this.image;
    }

}
