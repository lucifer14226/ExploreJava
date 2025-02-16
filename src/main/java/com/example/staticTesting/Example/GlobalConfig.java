package com.example.staticTesting.Example;

class GlobalConfig {
    private static String globalSetting = "default";

    public static void setConfig(String value) {
        globalSetting = value;
    }

    public static String getConfig() {
        return globalSetting;
    }
}