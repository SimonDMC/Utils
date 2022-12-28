package com.simondmc.utils.util;

import com.simondmc.utils.Utils;
import com.simondmc.utils.config.Config;

public class StringUtil {

    public static String formatCommand(String[] args, int startAt) {
        String cmd = DataType.joinStringArray(args, " ", startAt);
        if (!(cmd.charAt(0) == '/')) cmd = "/" + cmd;
        return cmd;
    }

    public static String translateColorCode(String message) {
        char colorChar = ((String) Config.get("color-char", "config")).charAt(0);
        message = message.replace(colorChar, '§');
        return message;
    }

    public static String[] addToArray(String[] array, String toAdd) {
        String[] newArray = new String[array.length + 1];
        System.arraycopy(array, 0, newArray, 0, array.length);
        newArray[array.length] = toAdd;
        return newArray;
    }
}
