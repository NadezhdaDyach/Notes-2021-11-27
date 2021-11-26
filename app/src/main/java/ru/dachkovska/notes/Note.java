package ru.dachkovska.notes;

public class Note {
    private String noteName;
    private String description;
    private String crDate;



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

    public String getCrDate() {
        return crDate;
    }

    public void setCrDate(String crDate) {
        this.crDate = crDate;
    }

    public Note() {
    }

    public Note(String noteName, String description, String crDate) {
        this.noteName = noteName;
        this.description = description;
        this.crDate = crDate;
    }
}
