/*
package Sokoban;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.image.ImageView;
import javafx.scene.layout.ColumnConstraints;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.RowConstraints;
import javafx.stage.Stage;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;


*
 * @author: Callum Jenkins
 * 15/11/2020
 * <p>
 * Class: test



public class test extends Application {


    private static final int WIDTH = 800;
    private static final int HEIGHT = 800;

    @Override
    public void start(Stage stage) throws Exception {

        try {
Label label1 = new Label("HELLO");
            Label label2 = new Label("BYE");

            final ImageView imv = new ImageView();
            Image image = new Image(Sokoban.class.getResourceAsStream("assets/Crate.png"));
            imv.setImage(image);

            final ImageView imvCrate = new ImageView();
            Crate crate = new Crate(0,0);
            imvCrate.setImage(crate.getImage());

            final ImageView imvCrate2 = new ImageView();
            Crate crate2 = new Crate(1,5);
            imvCrate2.setImage(crate2.getImage());

            final ImageView imvCrate3 = new ImageView();
            Crate crate3 = new Crate(2,10);
            imvCrate3.setImage(crate3.getImage());

            final ImageView imvCrate4 = new ImageView();
            Crate crate4 = new Crate(3,20);
            imvCrate4.setImage(crate4.getImage());

            //grid.addColumn(0, label1, label2, imv, imvCrate);
            //grid.getChildren().add(new ImageView(image));

            for (int i = 0; i <= 30; i++) {
                ColumnConstraints column = new ColumnConstraints(32);
                RowConstraints row = new RowConstraints(32);
                grid.getColumnConstraints().add(column);
                grid.getRowConstraints().add(row);
            }
            grid.add(imvCrate, crate.getPosition().getX(), crate.getPosition().getY(), 1, 1);
            grid.add(imvCrate2,crate2.getPosition().getX(), crate2.getPosition().getY(), 1, 1);
            grid.add(imvCrate3,crate3.getPosition().getX(), crate3.getPosition().getY(), 1, 1);
            grid.add(imvCrate4, crate4.getPosition().getX(), crate4.getPosition().getY(), 1, 1);


TestLevel test = new TestLevel();
            System.out.println(test.readFile("level1.txt"));


Button button = new Button("Look in the console");
            button.setOnAction(e -> {
                TestLevel test = new TestLevel();
                try {
                    System.out.println(test.readFile());
                } catch (IOException ioException) {
                    ioException.printStackTrace();
                }
            });

            grid.add(button, 0, 0, 1, 1);


Scanner scanner = null;

            try {
            scanner = new Scanner(new File("H:\\HND\\Semester 1\\Software Dev - OOP\\Repos\\SoftwareDev_OOP\\Sokoban\\levels\\level1.txt"));
            } catch (FileNotFoundException e) {
             e.printStackTrace();
            }
            

while (scanner.hasNextLine())
                System.out.println(scanner.nextLine());
            int[][] myArray = new int[20][20];

            for (int row = 0; scanner.hasNextLine() && row < 20; row++) {
                char[] chars = scanner.nextLine().toCharArray();
                for (int i = 0; i < 20 && i < chars.length; i++) {
                    myArray[row][i] = chars[i];
                }
            }

            System.out.println(Arrays.deepToString(myArray));

            for (int i = 0; i <= 30; i++) {
                ColumnConstraints column = new ColumnConstraints(32);
                RowConstraints row = new RowConstraints(32);
                grid.getColumnConstraints().add(column);
                grid.getRowConstraints().add(row);
            }

            MapElement[][] map = new MapElement[grid.getRowCount()][grid.getColumnCount()];
            Scanner scanner = null;
            PlayerCharacter playerCharacter;
            Wall wall;
            Crate crate;
            Tile tile;
            Goal goal;
            ImageView iv;

            try {
                scanner = new Scanner(new File("H:\\HND\\Semester 1\\Software Dev - OOP\\Repos\\SoftwareDev_OOP\\Sokoban\\levels\\level1.txt"));
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            }

            for (int row = 0; scanner.hasNextLine() && row < grid.getRowCount(); row++) {
                char[] chars = scanner.nextLine().toCharArray();
                for (int i = 0; i < grid.getColumnCount() && i < chars.length; i++) {

                    switch(chars[i]) {
                        //WALL
                        case 'X': {
                            iv = new ImageView();
                            wall = new Wall(row, i);
                            map[row][i] = wall;
                            iv.setImage(wall.getImage());
                            grid.add(iv, i, row, 1, 1);
                            break;
                        }
                        case ' ': {
                            iv = new ImageView();
                            tile = new Tile(row, i);
                            map[row][i] = tile;
                            iv.setImage(tile.getImage());
                            grid.add(iv, i, row, 1, 1);
                            break;
                        }
                        case '.': {
                            iv = new ImageView();
                            goal = new Goal(row, i);
                            map[row][i] = goal;
                            iv.setImage(goal.getImage());
                            grid.add(iv, i, row, 1, 1);
                            break;
                        }
                        case '*': {
                            iv = new ImageView();
                            crate = new Crate(row, i);
                            map[row][i] = crate;
                            iv.setImage(crate.getImage());
                            grid.add(iv, i, row, 1, 1);
                            break;
                        }
                        case '@': {
                            iv = new ImageView();
                            playerCharacter = new PlayerCharacter(row, i);
                            map[row][i] = playerCharacter;
                            iv.setImage(playerCharacter.getImage());
                            grid.add(iv, i, row, 1, 1);
                            break;
                        }
                    }
                }
            }

            stage.setScene(scene);
            stage.show();

        } catch (Exception e) {

        }
        Parent loader = FXMLLoader.load(getClass().getResource("Test.fxml"));
        stage.setTitle("SOKOBAN");
        stage.setScene(new Scene(loader, WIDTH, HEIGHT));
        stage.show();

    }

    GridPane grid = new GridPane();
    Scene scene = new Scene(grid, 700, 500);

    public static void main(String[] args) {
        launch(args);
    }
}
*/
