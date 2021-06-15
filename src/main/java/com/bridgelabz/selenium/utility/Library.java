/**
 * Description : News_Heading.java is test file which is having test cases for News_Heading.
 * Author      : Tushar Chawat
 * Date        : 12/06/2021
 */

package com.bridgelabz.selenium.utility;

public class Library {
    public static String getString(String Itr) {
        Itr = Itr.replaceAll("[^\\d]", " ");
        Itr = Itr.trim();
        Itr = Itr.replaceAll(" +", " ");
        return Itr;
    }

    public static int getValue(String Itr) {
        return Integer.parseInt(Itr);
    }

    public static String[] getArray(String Itr) {
        String ItrArray[] = Itr.split(" ");
        return ItrArray;
    }
}
