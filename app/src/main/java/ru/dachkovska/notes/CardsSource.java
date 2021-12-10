package ru.dachkovska.notes;

public interface CardsSource {
    Note getNote(int position);
    int size();
}