package fr.univtours.polytech.gestionnotes.model;

import java.io.Serializable;

public class StudentBean implements Serializable {
    private Integer idStudent;
    private String name;
    private String firstName;

    public Integer getIdStudent() {
        return idStudent;
    }

    public void setIdStudent(Integer idStudent) {
        this.idStudent = idStudent;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

}
