package com.musicstreaming.model;

public class Message {
    private int id;
    private String fromEmail;
    private String toEmail;
    private String content;

    public Message(int id, String fromEmail, String toEmail, String content) {
        this.id = id;
        this.fromEmail = fromEmail;
        this.toEmail = toEmail;
        this.content = content;
    }

    public int getId() {
        return id;
    }

    public String getFromEmail() {
        return fromEmail;
    }

    public String getToEmail() {
        return toEmail;
    }

    public String getContent() {
        return content;
    }
}
