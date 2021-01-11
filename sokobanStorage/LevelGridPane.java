/*
package Sokoban;

import javafx.scene.layout.ColumnConstraints;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.RowConstraints;

*/
/**
 * @author: Callum Jenkins
 * 09/01/2021
 * <p>
 * Class: LevelGridPane
 *//*


public class LevelGridPane extends GridPane {

    private PullFromGrid grid ;

    public LevelGridPane() {

        initGrid();
    }

    public void initGrid() {

        ColumnConstraints column = new ColumnConstraints(grid.getGridWidth());
        RowConstraints row = new RowConstraints(grid.getGridHeight());
        getColumnConstraints().add(column);
        getRowConstraints().add(row);
        */
/* for (int i = 0; i < grid.getGrid().length; i++) {
            for (int j = 0; j < grid.getGrid()[i].length; j++) {

            }
        }*//*

    }

    public String getImageFor(char objectChar) {

        String imagePath = null;

        if (objectChar == '\u0000') {
            return null;
        }
        else {
            if (objectChar == 'X') {
                imagePath = "assets/Wall.png";
            } else if (objectChar == ' ') {
                imagePath = "assets/Floor.png";
            } else if (objectChar == '*') {
                imagePath = "assets/Crate.png";
            } else if (objectChar == '.') {
                imagePath = "assets/Diamond.png";
            } else if (objectChar == '@' || objectChar == '+') {
                imagePath = "assets/WarehouseKeeper.png";
            } else if (objectChar == '$') {
                imagePath = "assets/CrateInPlace.png";
            }
            return imagePath;
        }
    }

    public void loadGrid() {
        for (int i = 0; i < grid.getGrid().length; i++) {
            for (int j = 0; j < grid.getGrid()[i].length; j++) {
                
            }
        }
    }
}
*/
