package com.jorgeMassaru.desafio3.dto;

import java.util.UUID;

public class NotifyDto {

    private UUID userId;
    private String NotifyTo;
    private String subject;
    private String text;

    public UUID getUserId() {
        return userId;
    }

    public void setUserId(UUID userId) {
        this.userId = userId;
    }

    public String getNotifyTo() {
        return NotifyTo;
    }

    public void setNotifyTo(String notifyTo) {
        NotifyTo = notifyTo;
    }

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }
}
