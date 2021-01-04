package Sokoban;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.Scanner;

/**
 * @author: Callum Jenkins
 * 03/01/2021
 * <p>
 * Class: ReadFile
 */

public class ReadFile {

    private char[][] grid;
    private int      gridHeight;
    private int      gridWidth;

    public ReadFile() {

    }

    public void run(String name) {
        Scanner scanner;
        scanner = new Scanner(System.in);
        String filname = "H:\\HND\\Semester 1\\Software Dev - OOP\\Repos\\SoftwareDev_OOP\\Sokoban\\levels\\level"+name+".txt";

        try {
            scanner = new Scanner(new FileReader(filname));

            grid = new char[30][30];

            for (int row = 0; scanner.hasNextLine() && row < grid.length; row++) {
                char[] chars = scanner.nextLine().toCharArray();
                for (int i = 0; i < grid[0].length && i < chars.length; i++) {
                    grid[row][i] = chars[i];
                }
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

        /*try {
            in = new Scanner(new FileReader(filnavn));
            String line = in.nextLine();
            gridHeight = Integer.parseInt(line);
            line = in.nextLine();
            gridWidth = Integer.parseInt(line);
            grid = new char[gridHeight][gridWidth];
            String gridContent = in.nextLine();
            for (int i = 0; i < grid.length; i++) {
                for (int j = 0; j < grid[0].length; j++) {
                    grid[i][j] = gridContent.charAt(j + gridWidth * i);
                }
            }
            in.close();
        } catch (FileNotFoundException e) {
            errMessage = "Error: " + filnavn + " not found!";
        }*/
    }

    /*public String getMessage() {
        return errMessage;
    }*/

    public char[][] getGrid() {
        return this.grid;
    }

    public String toString() {
        String s="";
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                s+=grid[i][j];
            }
            s+="\n";
        }
        return s;
    }

}
