package fr.univtours.polytech.gestionnotes_v2.dao;

import java.util.List;

import fr.univtours.polytech.gestionnotes_v2.model.NoteBean;
import jakarta.ejb.Stateless;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.Query;

@Stateless
public class NoteDaoImplJpa implements NoteDao {

    // L'objet EntityManager qui va permettre d'effectuer les requêtes en BDD.
    @PersistenceContext(unitName = "GestionNotes")
    private EntityManager em;

    @SuppressWarnings("unchecked")
    @Override
    public List<NoteBean> getNotesList() {
        // Exemple de requête HQL (ou JPAQL).
        Query requete = em.createNativeQuery("select * from NOTE_JPA", NoteBean.class);
        return requete.getResultList();
    }

    @Override
    public void updateNote(NoteBean note) {
        String sql = "update NOTE_JPA set ID_STUDENT = "+note.getIdStudent()+", NOTE = "+note.getNote()+" where NOTE_JPA.ID_NOTE = "+note.getIdNote()+";";
        em.createNativeQuery(sql);
    }

    @Override
    public void insertNote(NoteBean note) {
        em.persist(note);
    }
}