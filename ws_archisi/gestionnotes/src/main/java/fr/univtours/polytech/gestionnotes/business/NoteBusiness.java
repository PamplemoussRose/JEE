package fr.univtours.polytech.gestionnotes.business;

import java.util.List;

import fr.univtours.polytech.gestionnotes.model.NoteBean;
import fr.univtours.polytech.gestionnotes.model.ResultBean;
import fr.univtours.polytech.gestionnotes.model.StudentBean;

public interface NoteBusiness {
    public List<ResultBean> getResultsList();

    public void insertNote(NoteBean note);

    public void insertStudent(StudentBean studentBean);

    public void updateResult(ResultBean result);

    public Float computeMean(List<ResultBean> notesList);
}
