/*
package SokoOLD;

import Sokoban.ReadFile;

*/
/**
 * @author: Callum Jenkins
 * 08/11/2020
 * <p>
 * Class: Main
 *//*


public class SokobanMain implements GameGrid {

    */
/*private static final int WIDTH = 700;
    private static final int HEIGHT = 500;

    @Override
    public void start(Stage stage) throws Exception {
        Parent loader = FXMLLoader.load(getClass().getResource("Menu.fxml"));
        stage.setTitle("SOKOBAN");
        stage.setScene(new Scene(loader, WIDTH, HEIGHT));
        stage.show();
    }
*//*


    private GridMove   sokoban;
    private GameOutput output;

    public static void main(String[] args) throws Exception {
        GameGridGUI.main(new String[] { SokobanMain.class.getName()});
    }

    @Override
    public void init(String string) {

        sokoban = new GridMove();
        loadGame(string);

    }

    public void loadGame(String levelString) {
        ReadFile reader = new ReadFile();
        reader.run(levelString);
        sokoban.getLevelGrid().loadGrid(reader.getGrid());
        //System.out.println(sokoban.getLevelGrid().toString());
    }

    @Override
    public void run(GameOutput output) {
        this.output = output;
    }

    @Override
    public Integer doCommand(String action) {
        System.out.println(action);
        if ("LUDR".contains(action.charAt(0) + "")) {
           */
/* if (action.equals("UNDO")) {
                System.out.println(sokoban.undo());
                //sokoban.getLevelGrid().loadGrid();
            } else if (action.equals("REDO")) {
                sokoban.redo();
            } else {*//*


                char move = action.charAt(0);
                sokoban.moveTo(move);
                if (sokoban.hasWon()) {
                    output.info("Congratulations! You win!");
                    return 1;
                }
            }
        */
/*} else if (action.startsWith("<")) {// read a game
            if(action.length()<3){
                output.info("wrong input! use format: '< <name>'");
                return null;
            }else{
                loadGame(action.substring(2));
                //output.info(loadMessage);
            }
        } else if (action.startsWith(">")) {
            if (action.length() >= 3 && action.charAt(1) == ' '
                    && action.charAt(2) != ' ') {
                //saveGame(action.substring(2));
            } else {
                output.error("Wrong format! use format: '< <name>");
            }
        } else if (action.startsWith("u")) {
            String returnMessage = sokoban.undo();
            if (returnMessage == "done") {
                output.info("undo successed!");
            } else {
                output.error(returnMessage);
            }
        } else if (action.startsWith("r")) {
            String returnMessage = sokoban.redo();
            if (returnMessage == "") {
                output.info("redo action done!");
            } else {
                output.error(returnMessage);
            }
        }*//*

        return null;
    }

    @Override
    public GridProvider getGridProvider() {
        return sokoban.getLevelGrid();
    }

    @Override
    public String getTextFor(Object object) {
        return object.toString();
    }

    @Override
    public String getImageFor(String objectChar) {

        String imagePath = null;

        if (objectChar == null) {
            return null;
        }
        else {
            if (objectChar.equals("X")) {
                imagePath = "assets/Wall.png";
            } else if (objectChar.equals(" ")) {
                imagePath = "assets/Floor.png";
            } else if (objectChar.equals("*")) {
                imagePath = "assets/Crate.png";
            } else if (objectChar.equals(".")) {
                imagePath = "assets/Diamond.png";
            } else if (objectChar.equals("+")) {
                imagePath = "assets/WarehouseKeeper.png";
            } else if (objectChar.equals("$")) {
                imagePath = "assets/CrateInPlace.png";
            } else if (objectChar.equals("@")) {
                imagePath = "assets/WarehouseKeeper.png";
            }
            return imagePath;
        }
    }

    @Override
    public Integer gridElementInput(int x, int y) {
        return null;
    }

    @Override
    public Integer directionInput(int dx, int dy) {
        // up dx:0 dy: -1
        if (dx == 0 && dy == -1) {
            doCommand("U");
        }
        // down dx:0 dy: 1
        else if (dx == 0 && dy == 1) {
            doCommand("D");
        }
        // leftdx:-1 dy: 0
        else if (dx == -1 && dy == 0) {
            doCommand("L");
        }
        // right dx:1 dy: 0
        else if (dx == 1 && dy == 0) {
            doCommand("R");
        }
        return null;
    }
}
*/
