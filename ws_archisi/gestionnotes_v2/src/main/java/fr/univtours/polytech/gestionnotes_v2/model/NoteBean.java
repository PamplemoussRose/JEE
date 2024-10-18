package fr.univtours.polytech.gestionnotes_v2.model;

import java.io.Serializable;

public class NoteBean implements Serializable {
    private Integer idNote;
    private Integer idStudent;
    private float note;

    public Integer getIdNote() {
        return idNote;
    }

    public void setIdNote(Integer idNote) {
        this.idNote = idNote;
    }

    public Integer getIdStudent() {
        return idStudent;
    }

    public void setIdStudent(Integer idStudent) {
        this.idStudent = idStudent;
    }

    public float getNote() {
        return note;
    }

    public void setNote(float note) {
        this.note = note;
    }

}
