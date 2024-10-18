package fr.univtours.polytech.gestionnotes_v2.model;

import java.io.Serializable;

public class ResultBean implements Serializable {
    private StudentBean studentBean;
    private NoteBean noteBean;

    public StudentBean getStudentBean() {
        return studentBean;
    }

    public void setStudentBean(StudentBean studentBean) {
        this.studentBean = studentBean;
    }

    public NoteBean getNoteBean() {
        return noteBean;
    }

    public void setNoteBean(NoteBean noteBean) {
        this.noteBean = noteBean;
    }

}
