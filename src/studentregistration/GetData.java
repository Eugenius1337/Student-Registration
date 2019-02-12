/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package studentregistration;

import javax.swing.*;

/**
 * This class allows the reading of Strings, ints, and doubles.
 * @author eugeniomartin-carreras
 */
public class GetData {

    /**
     * Reads double from input
     * @param s Parses a String as a double
     * @return double value
     */
    public static double getDouble(String s) {
        return Double.parseDouble(getWord(s));
    }

    /**
     * Reads int from input
     * @param s Parses a String as an int
     * @return int value
     */
    public static int getInt(String s) {
        return Integer.parseInt(getWord(s));
    }

    /**
     * Reads string from input
     * @param s Gets a String from input
     * @return String value
     */
    public static String getWord(String s) {
        return JOptionPane.showInputDialog(s);
    }
}
