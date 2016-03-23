package com.example.wasabi.firebasechatlab;

/**
 * Created by Wasabi on 3/23/2016.
 */
public class MessageObj {
    private String message;
    private String username;

    public MessageObj() {
    }

    public MessageObj(String message, String username) {
        this.username = username;
        this.message = message;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }
}
