package com.aston.memoroid.model;


import java.util.UUID;
import java.util.concurrent.ThreadLocalRandom;

public class Task {

    private long dateCreation;
    private String title;
    private int priority;
    private String description;
    private boolean done;
    private long dateModification;
    private boolean isDeleted;
    private long deadline;
    private String id;

    public Task(String title, int priority) {
        this.title = title;
        this.priority = priority;
        this.dateCreation = System.currentTimeMillis();
        this.id = UUID.randomUUID().toString();
    }

    public long getDateCreation() {
        return dateCreation;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getPriority() {
        return priority;
    }

    public void setPriority(int priority) {
        this.priority = priority;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public boolean isDone() {
        return done;
    }

    public void setDone(boolean done) {
        this.done = done;
    }

    public long getDateModification() {
        return dateModification;
    }

    public void setDateModification(long dateModification) {
        this.dateModification = dateModification;
    }

    public boolean isDeleted() {
        return isDeleted;
    }

    public void setDeleted(boolean deleted) {
        isDeleted = deleted;
    }

    public long getDeadline() {
        return deadline;
    }

    public void setDeadline(long deadline) {
        this.deadline = deadline;
    }

    public String getId() {
        return id;
    }
}
