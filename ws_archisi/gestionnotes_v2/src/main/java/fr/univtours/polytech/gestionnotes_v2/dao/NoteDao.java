package fr.univtours.polytech.gestionnotes_v2.dao;

import java.util.List;

import fr.univtours.polytech.gestionnotes_v2.model.NoteBean;

public interface NoteDao {
    public List<NoteBean> getNotesList();

    public void insertNote(NoteBean note);

    public void updateNote(NoteBean note);

    public void deleteNote(NoteBean note);
}
