package Tutorials_Week6;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * @author: Callum Jenkins
 * 19/10/2020
 * <p>
 * Class: Utilities
 */

public class Utilities {

    public Utilities() {

    }

    public String getUserInput(String prompt) {
        String inputLine = null;
        System.out.println(prompt + " ");
        try
        {
            BufferedReader is = new BufferedReader(new InputStreamReader(System.in));
            inputLine = is.readLine();
            if (inputLine.length() == 0) return null;
        }
        catch (IOException e)
        {
            System.out.println("IOException: " + e);
        }
        return inputLine.toLowerCase();
    }
}
