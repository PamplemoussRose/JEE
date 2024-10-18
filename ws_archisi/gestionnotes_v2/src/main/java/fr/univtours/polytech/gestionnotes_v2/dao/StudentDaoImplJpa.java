package fr.univtours.polytech.gestionnotes_v2.dao;

import fr.univtours.polytech.gestionnotes_v2.model.StudentBean;
import jakarta.ejb.Stateless;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;

@Stateless
public class StudentDaoImplJpa implements StudentDao{

    @PersistenceContext(unitName = "GestionNotes")
    private EntityManager em;

    @Override
    public StudentBean getStudent(Integer id){
        return em.find(StudentBean.class, id);
    }

    @Override
    public void insertStudent(StudentBean student) {
        em.persist(student);
    }

    @Override
    public void updateStudent(StudentBean student) {
        String sql = "update STUDENT_JPA set NAME = "+student.getName()+", FIRST_NAME = "+student.getFirstName()+" where STUDENT_JPA.ID_STUDENT = "+student.getIdStudent()+";";
        em.createNativeQuery(sql);
    }

}
