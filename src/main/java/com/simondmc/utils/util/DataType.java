package com.simondmc.utils.util;

public class DataType {

    public static boolean isIntegerWithinBounds(String value, int min, int max) {
        try {
            int i = Integer.parseInt(value);
            return i >= min && i <= max;
        } catch (NumberFormatException e) {
            return false;
        }
    }

    public static boolean isInteger(String value) {
        try {
            Integer.parseInt(value);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }
}
