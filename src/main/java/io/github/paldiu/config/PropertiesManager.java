package io.github.paldiu.config;

import io.github.paldiu.utils.Logging;

import java.io.*;
import java.util.Properties;

public class PropertiesManager {
    private static final PropertiesManager instance = new PropertiesManager();

    private final Properties properties;
    private final File child;

    private PropertiesManager() {
        properties = new Properties();
        File parent = new File("%APPDATA%/AlbionBot/");
        child = new File(parent, "options.properties");
    }

    public static PropertiesManager getInstance() {
        return instance;
    }

    public PropertiesManager setDefaultProperties() {
        properties.setProperty("name", "");
        properties.setProperty("author", "Predicate<? super T>");
        properties.setProperty("version", "1.0.0");
        properties.setProperty("encoding", "UTF_8");
        properties.setProperty("token", "REPLACE ME");
        return this;
    }

    public Properties getProperties() {
        verify();
        return properties;
    }

    public void build() {
        if (child.exists()) {
            Logging.info("File already exists!");
            return;
        }

        verify();

        try (OutputStream stream = new FileOutputStream(child)) {
            properties.store(stream, null);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void load() {
        if (!child.exists()) {
            setDefaultProperties().build();
        }

        try (InputStream input = new FileInputStream(child)) {
            properties.load(input);
        } catch (IOException ignored) {
        }
    }

    public String getName() {
        return property("name");
    }

    public String getAuthor() {
        return property("author");
    }

    public String getVersion() {
        return property("version");
    }

    public String getEncoding() {
        return property("encoding");
    }

    public String getToken() {
        return property("token");
    }

    private void verify() {
        if (properties.isEmpty()) {
            setDefaultProperties();
        }
    }

    private String property(String name) {
        verify();
        return properties.getProperty(name);
    }
}
