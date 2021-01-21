package io.github.paldiu.utils;

import java.text.SimpleDateFormat;
import java.util.Date;

public class Constants {
    public static final String COMMAND_PREFIX = "#";
    public static final String BOT_PREFIX = "[Albion]";
    public static final String TIME_LOG = SimpleDateFormat.getTimeInstance().format(new Date());
    public static final long PRUNE_TIME_SHORT = TIME.DAY * 7L;
    public static final long PRUNE_TIME_LONG = TIME.MONTH;

    public static final class TIME {
        public static final long SECOND = 20L;
        public static final long MINUTE = 1200L;
        public static final long HOUR = 72000L;
        public static final long DAY = 1728000L;
        public static final long MONTH = 51840000L;
        public static final long YEAR = 622080000L;
    }
}
