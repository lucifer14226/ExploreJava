package com.example.staticTesting.Addition;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ConfigUtilTest {

    @AfterEach
    void tearDown() {
        // Clean up system property after each test
        System.clearProperty("config.value");

        // Reset the cached value (impossible without modifying ConfigUtil)
        // ConfigUtil.cachedValue = null; // Not possible since cachedValue is private
    }

    @Test
    void testGetConfigValue_DefaultValue() {
        assertEquals("default", ConfigUtils.getConfigValue(), "Expected default value when property is not set");
    }

    @Test
    void testGetConfigValue_WithSystemProperty() {
        System.setProperty("config.value", "testValue");
        assertEquals("testValue", ConfigUtils.getConfigValue(), "Expected value from system property");
    }

    @Test
    void testGetConfigValue_CachingIssue() {
        System.setProperty("config.value", "firstValue");
        assertEquals("firstValue", ConfigUtils.getConfigValue());

        // Change system property after first call
        System.setProperty("config.value", "secondValue");

        // Expected issue: The cached value is still "firstValue"
        assertEquals("firstValue", ConfigUtils.getConfigValue(), "Caching prevents fetching the new system property value");
    }
}
