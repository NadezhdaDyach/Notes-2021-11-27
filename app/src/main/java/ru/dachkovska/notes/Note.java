package ru.dachkovska.notes;

import java.util.Date;

public class Note {
    private String noteName;

    public String getNoteName() {
        return noteName;
    }

    public void setNoteName(String noteName) {
        this.noteName = noteName;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Date getCrDate() {
        return crDate;
    }

    public void setCrDate(Date crDate) {
        this.crDate = crDate;
    }

    private String description;

    private Date crDate;

    public Note() {
    }

    public Note(String noteName, String description, Date crDate) {
        this.noteName = noteName;
        this.description = description;
        this.crDate = crDate;
    }
}
