package io.github.paldiu.commands;

import io.github.paldiu.BotBase;
import net.dv8tion.jda.api.entities.Emote;
import net.dv8tion.jda.api.entities.Message;
import net.dv8tion.jda.api.entities.User;
import net.dv8tion.jda.api.requests.restaction.MessageAction;
import org.jetbrains.annotations.NotNull;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;

public class GrabCommand extends AbstractCommand {
    public GrabCommand(Message message, User user) {
        super(message, user);
    }

    @Override
    public GrabCommand getCommand() {
        return null;
    }

    @Override
    public void execute() {
        if (!emoteList(getMessage()).isEmpty()) {
            Emote[] emotes = emoteList(getMessage()).toArray(new Emote[]{});
            forEach(emotes, emote -> {
                File f = processURL(emote.getImageUrl());
                getChannel().sendFile(f).submit();
            });
        }
    }

    @NotNull
    private File processURL(String url) {
        try {
            URL tempURL = new URL(url);
            BufferedImage tempImage = ImageIO.read(tempURL);
            File tempFile = File.createTempFile("temp_", ".png");
            ImageIO.write(tempImage, "png", tempFile);
            return tempFile;
        } catch (IOException exception) {
            BotBase.printer().println(exception.getMessage());
            return new File("invalid-item.mxb");
        }
    }
}
