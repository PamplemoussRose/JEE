package fr.univtours.polytech.gestionnotes_v2.servlet;

import java.io.IOException;

import fr.univtours.polytech.gestionnotes_v2.business.NoteBusiness;
import fr.univtours.polytech.gestionnotes_v2.model.NoteBean;
import fr.univtours.polytech.gestionnotes_v2.model.StudentBean;
import jakarta.inject.Inject;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet(name = "fillDBServlet", urlPatterns = { "/fillDB" })
public class FillDBServlet extends HttpServlet {

    @Inject
    private NoteBusiness noteBusiness;

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        // Ajout de étudiants.
        StudentBean alice = new StudentBean();
        alice.setFirstName("Alice");
        alice.setName("A");
        StudentBean bob = new StudentBean();
        bob.setFirstName("Bob");
        bob.setName("B");

        noteBusiness.insertStudent(alice);
        noteBusiness.insertStudent(bob);

        // Ajout de notes.
        NoteBean noteAlice = new NoteBean();
        noteAlice.setIdStudent(alice.getIdStudent());
        noteAlice.setNote(20.0F);
        NoteBean noteBob = new NoteBean();
        noteBob.setIdStudent(bob.getIdStudent());
        noteBob.setNote(14.5F);

        noteBusiness.insertNote(noteAlice);
        noteBusiness.insertNote(noteBob);
    }
}