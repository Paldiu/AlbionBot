package io.github.paldiu.listener;

import io.github.paldiu.BotBase;
import net.dv8tion.jda.api.entities.Emote;
import net.dv8tion.jda.api.entities.Message;
import net.dv8tion.jda.api.entities.PrivateChannel;
import net.dv8tion.jda.api.entities.User;
import net.dv8tion.jda.api.events.message.priv.PrivateMessageReceivedEvent;
import net.dv8tion.jda.api.events.message.priv.react.PrivateMessageReactionAddEvent;
import net.dv8tion.jda.api.events.message.priv.react.PrivateMessageReactionRemoveEvent;
import net.dv8tion.jda.api.requests.restaction.MessageAction;
import org.jetbrains.annotations.NotNull;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.List;

public class PrivateMessageListener extends AbstractListener {

    @Override
    public void onPrivateMessageReceived(@NotNull PrivateMessageReceivedEvent event) {
        Message message = event.getMessage();
        PrivateChannel channel = message.getPrivateChannel();
        User user = message.getAuthor();
        List<Emote> emotes = message.getEmotes();

        if (!emotes.isEmpty()) {
            emotes.forEach(emote -> {
                File f = processURL(emote.getImageUrl());
                MessageAction action = channel.sendFile(f);
                action.submit();
            });
            return;
        }
        channel.close().submit();
    }

    @Override
    public void onPrivateMessageReactionAdd(@NotNull PrivateMessageReactionAddEvent event) {
        super.onPrivateMessageReactionAdd(event);
    }

    @Override
    public void onPrivateMessageReactionRemove(@NotNull PrivateMessageReactionRemoveEvent event) {
        super.onPrivateMessageReactionRemove(event);
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
