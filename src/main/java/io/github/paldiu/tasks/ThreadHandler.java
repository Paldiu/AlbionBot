package io.github.paldiu.tasks;

public class ThreadHandler {
    protected final Thread announcementThread;
    protected final Announcements announcements;
    //
    private static final ThreadHandler handler = new ThreadHandler();

    private ThreadHandler() {
        this.announcements = new Announcements();
        //
        this.announcementThread = new Thread(announcements);
    }

    public static ThreadHandler getInstance() { return handler; }

    public void startAnnouncements() {
        if (announcementThread.isAlive() || announcements.isRunning()) {
            return;
        }

        announcementThread.start();
        announcements.setRunning(true);
    }

    public void stopAnnouncements() {
        if (!announcementThread.isAlive() || !announcements.isRunning()) {
            return;
        }

        announcements.setRunning(false);

        try {
            announcementThread.join();
        } catch (InterruptedException ignored) {
        }
    }
}