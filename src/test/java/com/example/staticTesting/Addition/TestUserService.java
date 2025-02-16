package com.example.staticTesting.Addition;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class UserServiceTest {

    @Test
    void testGetUserName() {
        long startTime = System.currentTimeMillis();
        String userName = UserService.getUserName(1);
        long endTime = System.currentTimeMillis();

        assertEquals("User_1", userName, "Expected User_1");

        long duration = endTime - startTime;
        assertTrue(duration < 1000, "Test took too long! Static dependencies slow down testing.");
    }
}
