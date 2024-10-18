package fr.univtours.polytech.gestionnotes_v2.dao;

import fr.univtours.polytech.gestionnotes_v2.model.StudentBean;

public interface StudentDao {
    public StudentBean getStudent(Integer id);

    public void insertStudent(StudentBean student);

    public void updateStudent(StudentBean student);
}
