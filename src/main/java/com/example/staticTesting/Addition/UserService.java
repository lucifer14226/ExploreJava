package com.example.staticTesting.Addition;

public class UserService {
    private static final DatabaseConnection dbConnection = new DatabaseConnection();

    public static String getUserName(int userId) {
        return dbConnection.fetchUserName(userId);
    }
}
