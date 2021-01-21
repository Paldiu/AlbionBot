package io.github.paldiu.tasks;


import net.dv8tion.jda.api.entities.MessageChannel;

public class Announcements extends RecurringTask {
    protected MessageChannel channel = null;

    protected volatile boolean running = false;

    public Announcements() {
        
    }

    @Override
    public void run() {
        while (running) {

        }
    }

    public boolean isRunning() {
        return running;
    }

    public void setRunning(boolean running) {
        this.running = running;
    }
}
