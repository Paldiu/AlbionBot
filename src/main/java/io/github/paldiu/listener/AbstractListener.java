package io.github.paldiu.listener;

import io.github.paldiu.commands.ICommand;
import io.github.paldiu.utils.Constants;
import net.dv8tion.jda.api.entities.*;
import net.dv8tion.jda.api.hooks.ListenerAdapter;
import net.dv8tion.jda.api.requests.RestAction;
import net.dv8tion.jda.internal.requests.RestActionImpl;

import java.lang.reflect.Method;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Arrays;
import java.util.Set;
import java.util.concurrent.CompletableFuture;
import java.util.function.Consumer;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public abstract class AbstractListener extends ListenerAdapter {
    protected boolean checkPrefix(Message message) {
        return message.getContentRaw().startsWith(Constants.COMMAND_PREFIX);
    }

    protected String rawNoPrefix(Message message) {
        return message.getContentRaw().replace("#", "");
    }

    protected URL getURL(String url) {
        try {
            return new URL(url);
        } catch (MalformedURLException ignored) {
            return null;
        }
    }

    protected String getUsername(User user) {
        return user.getName();
    }

    protected String getDiscriminator(User user) {
        return user.getDiscriminator();
    }

    protected void clearReactions(Message message) {
        message.clearReactions().complete();
    }

    protected void addReaction(Message message, Emote reaction) {
        message.addReaction(reaction).complete();
    }

    protected void removeReaction(Message message, Emote reaction) {
        message.removeReaction(reaction).complete();
    }

    protected void removeReactions(Message message, Emote... reactions) {
        forEach(reactions, object -> {
            message.removeReaction(object).complete();
        });
    }

    protected final <T> Stream<T> stream(T[] array) {
        return Arrays.stream(array);
    }

    protected final <T> Set<T> collect(Stream<T> stream) {
        return stream.collect(Collectors.toSet());
    }

    protected final <T> void forEach(T[] array, Consumer<? super T> action) {
        collect(stream(array)).forEach(action);
    }
}
