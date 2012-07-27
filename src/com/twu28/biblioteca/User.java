package com.twu28.biblioteca;

public class User {
    private String username;
    private String password;
    private String regularExpression;

    public User() {
        regularExpression = "[0-9]{3}-{1}[0-9]{4}";
    }

    public User(String username, String password) throws Exception {
        this();
        setUsername(username);
        this.password = password;
    }

    private void setUsername(String username) throws Exception {
        if (username.matches(regularExpression))
            this.username = username;
        else
            throw new IllegalArgumentException("Invalid Username");
    }

    public String getUsername() {
        return this.username;
    }

    public boolean confirmAuthentication(String username, String password) {
        if (this.username.equals(username) && this.password.equals(password))
            return true;
        else
            return false;
    }
}
