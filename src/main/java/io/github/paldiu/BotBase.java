package io.github.paldiu;

import io.github.paldiu.utils.Constants;

import java.io.PrintStream;

public class BotBase {
    public static PrintStream printer() {
        return System.out;
    }
    public static String botMessage(String message) {
        return Constants.TIME_LOG +
                " " +
                Constants.BOT_PREFIX +
                " " +
                message;
    }
}
