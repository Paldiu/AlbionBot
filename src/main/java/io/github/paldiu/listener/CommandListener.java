package io.github.paldiu.listener;

import io.github.paldiu.commands.GrabCommand;
import io.github.paldiu.commands.ICommand;
import io.github.paldiu.commands.InfoCommand;
import net.dv8tion.jda.api.entities.Message;
import net.dv8tion.jda.api.entities.User;
import net.dv8tion.jda.api.events.message.MessageReceivedEvent;

public class CommandListener extends AbstractListener {
    @Override
    public void onMessageReceived(MessageReceivedEvent event) {
        Message message = event.getMessage();
        User user = event.getAuthor();

        if (!checkPrefix(message)) {
            return;
        }

        if (rawNoPrefix(message).equalsIgnoreCase("info")) {
            new InfoCommand(message, user).execute();
        }

        if (rawNoPrefix(message).equalsIgnoreCase("grab")) {
            new GrabCommand(message, user).execute();
        }
    }
}
