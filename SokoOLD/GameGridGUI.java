/*
package SokoOLD;

import javafx.application.Application;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.input.*;
import javafx.scene.text.Text;
import javafx.stage.FileChooser;
import javafx.stage.Stage;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

*/
/**
 * @author: Callum Jenkins
 * 03/01/2021
 * <p>
 * Class: GameGridGUI
 *//*


public class GameGridGUI extends Application implements GameOutput, GridListener {

    private GameGrid gameGrid;
    private String level = null;

    private TextInputControl levelTextField;
    private Button startButton;

    private TextInputControl inputTextField;
    private Button inputButton;

    private SimpleIntegerProperty moveCount;
    private Text movesText;


    private Button LEFT;
    private Button UP;
    private Button DOWN;
    private Button RIGHT;
    private Button UNDO;
    private Button REDO;

    private Button browseButton;
    private FileChooser fileChooser;

    private GameGridPane gridPane;
    private GridProvider gridProvider;

    private Node messageText;

    private Map<KeyCombination, Node> keyCombinationNodes;

    public static void main(String[] args) throws Exception {
        launch(GameGridGUI.class, args);
    }

    private void init(GameGrid sokoban, String level) {
        this.gameGrid = sokoban;
        this.level = level;
    }

    private GameGrid getGameGrid() {
        return this.gameGrid;
    }

   */
/* public void start() {

    }*//*


    */
/**
     * @param message
     *//*

    @Override
    public void info(String message) {

    }

    */
/**
     * @param message
     *//*

    @Override
    public void warning(String message) {

    }

    */
/**
     * @param message
     *//*

    @Override
    public void error(String message) {

    }

    */
/**
     * @param grid
     * @param x
     * @param y
     * @param w    width
     * @param h    height
     *//*

    @Override
    public void gridChanged(GridProvider grid, int x, int y, int w, int h) {
        if (gridProvider == this.gridProvider) {
            updateGrid(x, y, w, h);
        }
    }

    private void initGrid() {

        gridPane.setDimensions(gridProvider.getGridWidth(), gridProvider.getGridHeight());
        updateGrid(0, 0, gridProvider.getGridWidth(), gridProvider.getGridHeight());
        gridPane.setPrefSize(gridProvider.getGridWidth() * 20, gridProvider.getGridHeight() * 20);
    }

    private void updateGrid(int x, int y, int w, int h) {
        for (int column = x; column < x + w; column++) {
            for (int row = y; row < y + h; row++) {

                Object gridElement = gridProvider.getGridElement(column, row);
                
                */
/*System.out.println(gridProvider.getGridHeight());
                System.out.println(gridProvider.getGridWidth());*//*


                String text = getGameGrid().getTextFor(gridElement);
                //System.out.println("Grid element:" + gridElement);

                String imageKey = getGameGrid().getImageFor(text);
                System.out.println(imageKey);

                //gridPane.setText(text, column, row);
                //node -> GridPane.getRowIndex(node) == null || GridPane.getRowIndex(node) == 0
                if (gridElement != null) {
                    gridPane.setImage(imageKey, column, row, getGameGrid(), this);
                }
            }
        }
    }

    @Override
    public void start(Stage stage) throws Exception {
       */
/* Parent loader = FXMLLoader.load(getClass().getResource("Menu.fxml"));
        stage.setTitle("SOKOBAN");
        stage.setScene(new Scene(loader));
        stage.show();*//*

        Parent loader = FXMLLoader.load(getClass().getResource("GameGridGUI.fxml"));
        stage.setTitle("SOKOBAN");

        List<String> parameters = getParameters().getRaw();
        GameGrid sokoban = (GameGrid) Class.forName(parameters.get(0)).newInstance();

        init(sokoban, parameters.size() > 1 ? parameters.get(1) : null);

        levelTextField = lookupNode(loader, "#levelTextField", TextInputControl.class, levelTextActionHandler);
        if (levelTextField != null && level != null) {
            levelTextField.setText(level);
        }

        gridPane = lookupNode(loader, "#gridPane", GameGridPane.class);
        //browseButton = lookupNode(loader, "#fileButton", Button.class, browseActionHandler);
        //startButton = lookupNode(loader, "#startButton", Button.class, levelTextActionHandler);
        //inputTextField = lookupNode(loader, "#inputTextField", TextInputControl.class, inputTextActionHandler);
        //inputButton = lookupNode(loader, "#inputButton", Button.class, inputTextActionHandler);

        messageText = lookupNode(loader, "#messageText", Text.class);

        moveCount  = new SimpleIntegerProperty(0);
        movesText = new Text("# of Moves: 0");
        
        //StackPane buttonStack = new StackPane();
        LEFT = lookupNode(loader, "#LEFT", Button.class, inputTextActionHandler);
        UP = lookupNode(loader, "#UP", Button.class, inputTextActionHandler);
        DOWN = lookupNode(loader, "#DOWN", Button.class, inputTextActionHandler);
        RIGHT = lookupNode(loader, "#RIGHT", Button.class, inputTextActionHandler);

        UNDO = lookupNode(loader, "#UNDO", Button.class, inputTextActionHandler);
        REDO = lookupNode(loader, "#REDO", Button.class, inputTextActionHandler);
*/
/*
        buttonStack.getChildren().addAll(LEFT, UP, DOWN, RIGHT);
        gridPane.add(buttonStack, 30, 30, 1, 3);
*//*


        //LEFT.setOnAction();



        if (gridPane == null) {
            gridPane.setFocusTraversable(true);

            keyCombinationNodes = new HashMap<KeyCombination, Node>();
            for (Node node : loader.lookupAll(".keyCombinationId")) {
                keyCombinationNodes.put(KeyCombination.valueOf(node.getId().replace('_', '+')), node);
            }
            for (Node node : loader.lookupAll(".inputTextButton")) {
                if (node instanceof Labeled) {
                    char firstChar = ((Labeled) node).getText().charAt(0);
                    KeyCharacterCombination kc = new KeyCharacterCombination(String.valueOf(firstChar));
                    keyCombinationNodes.put(kc, node);
                }
            }

            gridPane.setOnKeyTyped(keyCombinationHandler);
            gridPane.setOnKeyPressed(keyCombinationHandler);
            gridPane.setOnKeyPressed(directionKeyHandler);

        }



        stage.setScene(new Scene(loader, 800, 800));
        stage.show();
    }

    private <T extends Node> T lookupNode(Node root, String selector, Class<T> c) {
        Node node = root.lookup(selector);
        return (c.isInstance(node) ? (T) node : null);
    }

    private <T extends Node> T lookupNode(Node root, String selector, Class<T> c, EventHandler<ActionEvent> handler) {
        T node = lookupNode(root, selector, c);
        if (handler != null) {
            setActionHandler(node, handler);
        }
        return node;
    }

    private <T extends Node> void setActionHandler(T node, EventHandler<ActionEvent> handler) {
        if (node instanceof ButtonBase) {
            ((ButtonBase) node).setOnAction(handler);
        } else if (node instanceof TextField) {
            ((TextField) node).setOnAction(handler);
        }
    }

    private EventHandler<ActionEvent> levelTextActionHandler = new EventHandler<ActionEvent>() {

        @Override
        public void handle(ActionEvent actionEvent) {
            //GameGridPane gridPane = null;
            getGameGrid().init(levelTextField.getText());
            getGameGrid().run(GameGridGUI.this);
            if (getGameGrid()!= null) {
                gridProvider = getGameGrid().getGridProvider();
                gridProvider.addGridListener(GameGridGUI.this);
                initGrid();
                gridPane.requestFocus();
            }
            //inputButton.setDisable(false);
        }
    };

    private EventHandler<ActionEvent> inputTextActionHandler = new EventHandler<ActionEvent>() {
        @Override
        public void handle(ActionEvent actionEvent) {
            Object source = actionEvent.getSource();
            System.out.println(((Labeled) source).getText());
            */
/*if (source == inputTextField || source == inputButton) {
                doCommand(inputTextField.getText());
            } else*//*
 if (source instanceof Labeled && (((Node) source).getStyleClass().contains("inputTextButton"))
                                                        || source == LEFT || source == UP || source == DOWN || source == RIGHT
                                                        || source == UNDO || source == REDO) {

                doCommand(((Labeled) source).getText());
            }
        }
    };

    */
/*private EventHandler<ActionEvent> browseActionHandler = new EventHandler<ActionEvent>() {
        @Override
        public void handle(ActionEvent actionEvent) {
            if (fileChooser == null) {
                fileChooser = new FileChooser();
            }
            fileChooser.setTitle("Open level file");
            File file = fileChooser.showOpenDialog(browseButton.getScene().getWindow());
            if (file != null) {
                levelTextField.setText(file.getAbsolutePath());
                doAction(startButton);
            }
        }
    };*//*


    private EventHandler<KeyEvent> directionKeyHandler = new EventHandler<KeyEvent>() {
        @Override
        public void handle(KeyEvent keyEvent) {
            if (! keyEvent.isConsumed()) {
                if (keyEvent.getCode() == KeyCode.UP) {
                    directionInput(0, -1);
                } else if (keyEvent.getCode() == KeyCode.DOWN) {
                    directionInput(0, 1);
                } else if (keyEvent.getCode() == KeyCode.LEFT) {
                    directionInput(-1, 0);
                } else if (keyEvent.getCode() == KeyCode.RIGHT) {
                    directionInput(1, 0);
                } else {
                    return;
                }
                keyEvent.consume();
            }
        }
    };

    private void directionInput(int dx, int dy) {
        //updateMessage(null, null, true);
        Integer result = getGameGrid().directionInput(dx, dy);
        handleInputResult(result);
    }

    private EventHandler<KeyEvent> keyCombinationHandler = new EventHandler<KeyEvent>() {
        @Override
        public void handle(KeyEvent keyEvent) {
            if (! keyEvent.isConsumed()) {
                Node node = getKeyCombinationNode(keyEvent);
                if (node != null && doAction(node)) {
                    keyEvent.consume();
                }
            }
        }
    };

    */
/*private EventHandler<MouseEvent> graphicsNodeMouseHandler = new EventHandler<MouseEvent>() {
        @Override
        public void handle(MouseEvent mouseEvent) {
            gridPane.requestFocus();
            for (Node child : gridPane.getChildrenUnmodifiable()) {
                Bounds bounds = child.getBoundsInParent();
                if (bounds.contains(mouseEvent.getX(), mouseEvent.getY())) {
                    Integer column = GridPane.getColumnIndex(child), row = GridPane.getRowIndex(child);
                    if (column != null && column < gridProvider.getGridWidth() && row != null && row < gridProvider.getGridHeight()) {
                        gridInput(column, row);
                    }
                }
            }
        }
    };*//*



    private boolean match(KeyCombination kc, KeyEvent keyEvent) {
        if (keyEvent.getEventType() == KeyEvent.KEY_TYPED) {
            if (kc instanceof KeyCharacterCombination) {
                return ((KeyCharacterCombination) kc).getCharacter().equals(keyEvent.getCharacter());
            }
        } else  {
            return kc.match(keyEvent);
        }
        return false;
    }

    private Node getKeyCombinationNode(KeyEvent keyEvent) {
        for (KeyCombination kc : keyCombinationNodes.keySet()) {
            if (match(kc, keyEvent)) {
                return keyCombinationNodes.get(kc);
            }
        }
        return null;
    }


    private void doCommand(String line) {
        //updateMessage(null, null, true);
        Integer result = getGameGrid().doCommand(line);
        handleInputResult(result);
        //this.inputTextField.selectAll();
    }

    private boolean doAction(Node node) {
        EventHandler<ActionEvent> handler = null;
        if (node instanceof ButtonBase) {
            handler = ((ButtonBase) node).getOnAction();
        } else if (node instanceof TextField) {
            handler = ((TextField) node).getOnAction();
        }
        if (handler != null) {
            handler.handle(new ActionEvent(node, null));
            return true;
        } else if (node instanceof ButtonBase) {
            ((ButtonBase) node).fire();
            return true;
        }
        return false;
    }

    private void handleInputResult(Integer result) {
        if (result != null) {
            info("Game over" + (result != 0 ? "" : ", no result") + "!");
            inputButton.setDisable(true);
        }
    }

    private void gridInput(int column, int row) {
        //updateMessage(null, null, true);
        Integer result = getGameGrid().gridElementInput(column, row);
        handleInputResult(result);
    }

    public SimpleIntegerProperty getMoveCount() {
        return this.moveCount;
    }

    public void incrementMoves() {
        this.moveCount.setValue((this.moveCount.getValue() + 1));
        //movesText.textProperty().bind(new SimpleStringProperty("# of Moves ").concat(moveCount.getValue().toString()));
    }

    public void decrementMoves() {
        this.moveCount.setValue((this.moveCount.getValue() - 1));
    }

    public void updateMoveText() {
        this.movesText.textProperty().bind(new SimpleStringProperty("# of Moves: ").concat(this.moveCount.getValue().toString()));
        */
/*for (int i = 0; i < goalPositions.size(); i++) {
            System.out.println("X: " + goalPositions.get(i).getX()
                             + "\nY: " + goalPositions.get(i).getY());
        }*//*


    }

    public Text getMoveText() {
        return this.movesText;
    }

}
*/
