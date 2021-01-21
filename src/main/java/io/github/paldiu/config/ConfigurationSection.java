package io.github.paldiu.config;

import java.util.List;
import java.util.Map;
import java.util.Set;

public interface ConfigurationSection {
    void addDefault(String path, Object value);

    boolean contains(String path);

    boolean contains(String path, boolean ignoreDefault);

    ConfigurationSection createSection(String path);

    ConfigurationSection createSection(String path, Map<?, ?> map);

    Object get(String path);

    Object get(String path, Object def);

    boolean getBoolean(String path);

    boolean getBoolean(String path, boolean def);

    List<Boolean> getBooleanList(String path);

    List<Byte> getByteList(String path);

    List<Character> getCharacterList(String path);

    ConfigurationSection getConfigurationSection(String path);

    String getCurrentPath();

    ConfigurationSection getDefaultSection();

    double getDouble(String path);

    double getDouble(String path, double def);

    List<Double> getDoubleList(String path);

    List<Float> getFloatList(String path);

    int getInt(String path);

    int getInt(String path, int def);

    List<Integer> getIntegerList(String path);

    Set<String> getKeys(boolean deep);

    List<?> getList(String path);

    List<?> getList(String path, List<?> def);

    long getLong(String path);

    long getLong(String path, long def);

    List<Long> getLongList(String path);

    List<Map<?, ?>> getMapList(String path);

    String getName();

    <T> T getObject(String path, Class<T> clazz);

    <T> T getObject(String path, Class<T> clazz, T def);

    ConfigurationSection getParent();

    Configuration getRoot();

    List<Short> getShortList(String path);

    String getString(String path);

    String getString(String path, String def);

    List<String> getStringList(String path);

    Map<String, Object> getValues(boolean deep);

    boolean isBoolean(String path);

    boolean isConfigurationSection(String path);

    boolean isDouble(String path);

    boolean isInt(String path);

    boolean isList(String path);

    boolean isLong(String path);

    boolean isSet(String path);

    boolean isString(String path);

    void set(String path, Object value);
}
