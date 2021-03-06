package ru.dachkovska.notes;

import android.os.Parcel;
import android.os.Parcelable;

public class Note implements Parcelable {
    private String noteName;
    private String description;
    private String crDate;


    protected Note(Parcel in) {
        noteName = in.readString();
        description = in.readString();
        crDate = in.readString();
    }

    public static final Creator<Note> CREATOR = new Creator<Note>() {
        @Override
        public Note createFromParcel(Parcel in) {
            return new Note(in);
        }

        @Override
        public Note[] newArray(int size) {
            return new Note[size];
        }
    };

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

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(noteName);
        dest.writeString(description);
        dest.writeString(crDate);
    }
}
