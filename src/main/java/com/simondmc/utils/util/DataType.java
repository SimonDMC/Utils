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

    public static String joinStringArray(String[] array, String delimiter, int startAt) {
        StringBuilder builder = new StringBuilder();
        for (int i = startAt; i < array.length; i++) {
            builder.append(array[i]);
            if (i < array.length - 1) {
                builder.append(delimiter);
            }
        }
        return builder.toString();
    }
}
