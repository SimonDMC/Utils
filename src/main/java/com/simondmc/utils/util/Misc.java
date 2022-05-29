package com.simondmc.utils.util;

public class Misc {

    public static String formatCommand(String[] args, int startAt) {
        String cmd = DataType.joinStringArray(args, " ", startAt);
        if (!(cmd.charAt(0) == '/')) cmd = "/" + cmd;
        return cmd;
    }
}
