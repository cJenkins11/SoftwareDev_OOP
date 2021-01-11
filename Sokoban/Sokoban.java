package Sokoban;


/**
 * @author: Callum Jenkins
 * 09/01/2021
 * <p>
 * Class: Sokoban
 */


public class Sokoban {

    private GridMovement movementHandler;


    public static void main(String[] args) {
        SokobanGUI.main(new String[] {Sokoban.class.getName()});
    }


    private void loadGame(String level) {
        ReadFile filereader = new ReadFile();
        filereader.run(level);
        movementHandler.getLevelGrid().loadBoard(filereader.getGrid());

        //this.board = filereader.getGrid();
    }

    /*@Override
    public void init(String level) {
        loadGame(level);
    }

    @Override
    public PullFromGrid getPullFromGrid() {
        return null;
    }*/
}
