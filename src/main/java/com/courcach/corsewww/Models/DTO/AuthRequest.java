package com.courcach.corsewww.Models.DTO;

public class AuthRequest implements java.io.Serializable {
    private final String username;
    private final String password;

    public AuthRequest(String username, String password) {
        this.username = username;
        this.password = password;
    }

    // Геттеры
    public String getUsername() { return username; }
    public String getPassword() { return password; }
}