package io.github.paldiu.commands;

import net.dv8tion.jda.api.entities.*;
import org.apache.commons.collections4.Bag;

import java.util.Arrays;
import java.util.List;
import java.util.Set;
import java.util.function.Consumer;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public abstract class AbstractCommand implements ICommand {
    private final MessageChannel channel;
    private final User user;
    private final Message message;
    private final Guild guild;
    
    protected AbstractCommand(Message message, User user) {
        this(message, user, message.getGuild());
    }
    
    protected AbstractCommand(Message message) {
        this(message, message.getAuthor());
    }
    
    protected AbstractCommand(Message message, User user, Guild guild) {
        this.message = message;
        this.user = user;
        this.channel = message.getChannel();
        this.guild = guild;
    }
    
    @Override
    public Message getMessage() {
        return message;
    }
    
    @Override
    public User getUser() {
        return user;
    }
    
    protected MessageChannel getChannel() {
        return channel;
    }
    
    protected Bag<Emote> emoteBag(Message message) {
        return message.getEmotesBag();
    }
    
    protected List<Emote> emoteList(Message message) {
        return message.getEmotes();
    }
    
    protected Guild getGuild() {
        return guild;
    }

    final <T> Stream<T> stream(T[] array) {
        return Arrays.stream(array);
    }

    final <T> Set<T> collect(Stream<T> stream) {
        return stream.collect(Collectors.toSet());
    }

    protected final <T> void forEach(T[] array, Consumer<? super T> action) {
        collect(stream(array)).forEach(action);
    }
}
