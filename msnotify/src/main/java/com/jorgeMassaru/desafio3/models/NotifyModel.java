package com.jorgeMassaru.desafio3.models;

import com.jorgeMassaru.desafio3.enums.StatusNotify;
import jakarta.persistence.*;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.UUID;

@Entity
@Table(name= "tb_notify")
public class NotifyModel implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID notifyId;
    private UUID userId;
    private String notifyFrom;
    private String notifyTo;
    private String subject;
    @Column(columnDefinition = "TEXT")
    private String text;
    private LocalDateTime sendDateEmail;
    private StatusNotify statusNotify;

    public UUID getNotifyId() {
        return notifyId;
    }

    public void setNotifyId(UUID notifyId) {
        this.notifyId = notifyId;
    }

    public UUID getUserId() {
        return userId;
    }

    public void setUserId(UUID userId) {
        this.userId = userId;
    }

    public String getNotifyFrom() {
        return notifyFrom;
    }

    public void setNotifyFrom(String notifyFrom) {
        this.notifyFrom = notifyFrom;
    }

    public String getNotifyTo() {
        return notifyTo;
    }

    public void setNotifyTo(String notifyTo) {
        this.notifyTo = notifyTo;
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

    public LocalDateTime getSendDateEmail() {
        return sendDateEmail;
    }

    public void setSendDateEmail(LocalDateTime sendDateEmail) {
        this.sendDateEmail = sendDateEmail;
    }

    public StatusNotify getStatusNotify() {
        return statusNotify;
    }

    public void setStatusNotify(StatusNotify statusNotify) {
        this.statusNotify = statusNotify;
    }
}
