package fr.univtours.polytech.gestionnotes.dao;

import fr.univtours.polytech.gestionnotes.model.StudentBean;

public interface StudentDao {
    public StudentBean getStudent(Integer id);

    public void insertStudent(StudentBean student);

    public void updateStudent(StudentBean student);
}
