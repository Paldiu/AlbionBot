package io.github.paldiu.commands;

import net.dv8tion.jda.api.entities.Message;
import net.dv8tion.jda.api.entities.User;

public interface ICommand {
    ICommand getCommand();

    Message getMessage();

    User getUser();

    void execute();
}
