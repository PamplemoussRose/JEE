package fr.univtours.polytech.gestionnotes_v2.business;

import java.util.ArrayList;
import java.util.List;

import fr.univtours.polytech.gestionnotes_v2.dao.NoteDao;
import fr.univtours.polytech.gestionnotes_v2.dao.StudentDao;
import fr.univtours.polytech.gestionnotes_v2.model.NoteBean;
import fr.univtours.polytech.gestionnotes_v2.model.ResultBean;
import fr.univtours.polytech.gestionnotes_v2.model.StudentBean;
import jakarta.ejb.Stateless;
import jakarta.inject.Inject;

@Stateless
public class NoteBusinessImpl implements NoteBusiness {
    // Dépendances vers les différents DAO utiles pour ce service métier.
    @Inject
    private NoteDao noteDao;
    @Inject
    private StudentDao studentDAO;

    @Override
    public List<ResultBean> getResultsList() {
        List<ResultBean> results = new ArrayList<ResultBean>();
        List<NoteBean> notes = noteDao.getNotesList();
        System.out.println("Nb results : " + notes.size());
        for (NoteBean noteBean : notes) {
            ResultBean resultBean = new ResultBean();
            resultBean.setNoteBean(noteBean);
            // System.out.println(noteBean.getIdStudent() + " - " + noteBean.getNote());
            resultBean.setStudentBean(this.studentDAO.getStudent(noteBean.getIdStudent()));
            // System.out.println(resultBean.getStudentBean().getFirstName() + " - " +
            // resultBean.getNoteBean().getNote());
            results.add(resultBean);
        }
        return results;
    }

    @Override
    public void insertNote(NoteBean noteBean) {
        this.noteDao.insertNote(noteBean);
    }

    @Override
    public void insertStudent(StudentBean studentBean) {
        this.studentDAO.insertStudent(studentBean);
    }

    @Override
    public void updateResult(ResultBean resultBean) {
        this.noteDao.updateNote(resultBean.getNoteBean());
        this.studentDAO.updateStudent(resultBean.getStudentBean());
    }

    @Override
    public void deleteNote(NoteBean note) {
        this.noteDao.deleteNote(note);
    }

    @Override
    public Float computeMean(List<ResultBean> resultsList) {
        List<ResultBean> results = getResultsList();
        if (results.size() != 0) {
            float sum = 0;
            for (Integer index = 0; index < results.size(); index++) {
                sum += results.get(index).getNoteBean().getNote();
            }
            return sum / results.size();
        } else {
            return null;
        }
    }
}
