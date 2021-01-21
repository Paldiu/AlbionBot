package io.github.paldiu;

import io.github.paldiu.listener.CommandListener;
import io.github.paldiu.listener.PrivateMessageListener;
import io.github.paldiu.tasks.Announcements;
import io.github.paldiu.tasks.RecurringTask;
import io.github.paldiu.tasks.ThreadHandler;
import net.dv8tion.jda.api.JDA;
import net.dv8tion.jda.api.JDABuilder;

import javax.security.auth.login.LoginException;

public class Bot extends BotBase {
    protected static JDABuilder builder;
    protected static JDA jda;

    public static void main(String[] args) {
        builder = JDABuilder.createDefault("BOT TOKEN HERE");
        try {
            jda = builder.build();
        } catch (LoginException ex) {
            printer().println(botMessage("Bot failed to initialize."));
            jda = null;
            return;
        }
        register();
        printer().println(botMessage("Bot has successfully initialized!"));
    }

    public static void register() {
        jda.addEventListener(new PrivateMessageListener());
        jda.addEventListener(new CommandListener());
        printer().println(botMessage("Successfully registered all listeners!"));
    }

    public static void startTasks() {
        ThreadHandler.getInstance().startAnnouncements();
    }

    public static void stopTasks() {
        ThreadHandler.getInstance().stopAnnouncements();
    }


}
