package com.simondmc.utils.util;

import com.simondmc.utils.Utils;

public class StringUtil {

    public static String formatCommand(String[] args, int startAt) {
        String cmd = DataType.joinStringArray(args, " ", startAt);
        if (!(cmd.charAt(0) == '/')) cmd = "/" + cmd;
        return cmd;
    }

    public static String translateColorCode(String message) {
        char colorChar = Utils.plugin.getConfig().getString("color-char").charAt(0);
        message = message.replace(colorChar, '§');
        return message;
    }
}
