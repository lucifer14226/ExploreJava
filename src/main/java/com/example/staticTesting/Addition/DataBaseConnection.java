package com.example.staticTesting.Addition;

class DatabaseConnection {
    public String fetchUserName(int userId) {
        try {
            Thread.sleep(5000); // Simulate slow database call (5 sec delay)
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
        return "User_" + userId;
    }
}
