package fr.univtours.polytech.gestionnotes.dao;

import java.util.List;

import fr.univtours.polytech.gestionnotes.model.NoteBean;

public interface NoteDao {
    public List<NoteBean> getNotesList();

    public void insertNote(NoteBean note);

    public void updateNote(NoteBean note);
}
