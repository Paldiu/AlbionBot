package io.github.paldiu.utils;

import java.util.logging.Level;
import java.util.logging.Logger;

public class Logging {
    private static final Logger logger = Logger.getLogger("Albion");

    static {
        logger.setLevel(Level.ALL);
    }

    public static void info(String message) {
        logger.info(message);
    }

    public static void info(Throwable th) {
        logger.info(th.getMessage());
    }

    public static void info(Object raw) {
        if (raw instanceof Throwable) {
            logger.info(((Throwable) raw).getMessage());
        } else if (raw instanceof String) {
            logger.info((String)raw);
        } else {
            logger.info(raw.toString());
        }
    }

    public static void warning(String message) {
        logger.warning(message);
    }

    public static void warning(Throwable th) {
        logger.warning(th.getMessage());
    }

    public static void warning(Object raw) {
        if (raw instanceof Throwable) {
            logger.warning(((Throwable) raw).getMessage());
        } else if (raw instanceof String) {
            logger.warning((String)raw);
        } else {
            logger.warning(raw.toString());
        }
    }

    public static void severe(String message) {
        logger.severe(message);
    }

    public static void severe(Throwable th) {
        logger.severe(th.getMessage());
    }

    public static void severe(Object raw) {
        if (raw instanceof Throwable) {
            logger.severe(((Throwable) raw).getMessage());
        } else if (raw instanceof String) {
            logger.severe((String)raw);
        } else {
            logger.severe(raw.toString());
        }
    }
    
    
}
