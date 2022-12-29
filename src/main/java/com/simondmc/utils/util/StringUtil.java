package com.simondmc.utils.util;

import com.simondmc.utils.config.Config;

public class StringUtil {

    /**
     * Formats a string array into a command string.
     * @param args The string array to format.
     * @param startAt The index of the first element to include in the string
     *                (where the command starts).
     * @return The formatted string.
     */
    public static String formatCommand(String[] args, int startAt) {
        String cmd = joinStringArray(args, " ", startAt);
        if (!(cmd.charAt(0) == '/')) cmd = "/" + cmd;
        return cmd;
    }

    /**
     * Replaces all instances of the color delimiter specified in the config with the
     * default color code delimiter.
     * @param message The message to replace the color delimiter in.
     * @return The message with the color delimiter replaced.
     */
    public static String translateColorCode(String message) {
        Object colorCharObj = Config.get("color-char", "config");
        String colorChar = colorCharObj == null ? "&" : (String) colorCharObj;
        message = message.replace(colorChar, "§");
        return message;
    }

    /**
     * Appends a string to the end of an array
     * @param array The array to append to
     * @param toAdd The string to append
     * @return The new array
     */
    public static String[] addToArray(String[] array, String toAdd) {
        String[] newArray = new String[array.length + 1];
        System.arraycopy(array, 0, newArray, 0, array.length);
        newArray[array.length] = toAdd;
        return newArray;
    }

    /**
     * Joins a string array into a single string.
     * @param array The String array to join.
     * @param delimiter The delimiter to use between each element.
     * @param startAt The index of the first element to include in the string.
     * @return The joined String.
     */
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

    /**
     * Get words after a certain index in a string array.
     * @param string The string to get words from.
     * @param n The index to start at.
     * @return The words after the index.
     */
    public static String getWordsFromN(String string, int n) {
        String[] words = string.split(" ");
        StringBuilder builder = new StringBuilder();
        for (int i = n; i < words.length; i++) {
            builder.append(words[i]);
            if (i < words.length - 1) {
                builder.append(" ");
            }
        }
        return builder.toString();
    }
}
