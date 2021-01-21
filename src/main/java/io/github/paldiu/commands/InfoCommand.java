package io.github.paldiu.commands;

import net.dv8tion.jda.api.entities.ChannelType;
import net.dv8tion.jda.api.entities.Message;
import net.dv8tion.jda.api.entities.TextChannel;
import net.dv8tion.jda.api.entities.User;
import net.dv8tion.jda.api.requests.restaction.MessageAction;

public class InfoCommand extends AbstractCommand {

    protected Message message;
    protected User user;

    public InfoCommand(Message message, User user) {
        super(message, user);
    }

    @Override
    public void execute() {
        message.getChannel().sendMessage("The albion bot was created by Predicate<? super T>#0001!").submit();
    }

    @Override
    public InfoCommand getCommand() {
        return this;
    }
}
