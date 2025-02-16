package com.example.staticTesting.Addition;

public class ConfigUtils {
    private static String cachedValue;

    public static String getConfigValue() {
        if (cachedValue != null) {
            return cachedValue;
        }
        String value = System.getProperty("config.value");
        if (value == null) {
            value = "default";
        }
        cachedValue = value;
        return cachedValue;
    }
}
