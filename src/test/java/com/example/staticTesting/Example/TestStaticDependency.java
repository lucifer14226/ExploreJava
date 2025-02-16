package com.example.staticTesting.Example;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

class StaticDependencyTest {

    @Test
    void testStaticStateIssue() {
        ServiceA serviceA = new ServiceA();
        ServiceB serviceB = new ServiceB();

        assertFalse(serviceA.isFeatureEnabled()); // Initially "default"

        serviceB.enableFeature(); // Changes static state

        assertTrue(serviceA.isFeatureEnabled()); // Now "enabled"
    }
}

/*
ServiceA depends on GlobalConfig, but it does not control when the config changes.

If we want to test ServiceA, we have to reset GlobalConfig after every test.

If two threads modify GlobalConfig at the same time, race conditions can occur.
 */
