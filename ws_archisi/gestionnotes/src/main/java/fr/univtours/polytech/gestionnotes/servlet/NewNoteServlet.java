package fr.univtours.polytech.gestionnotes.servlet;

import java.io.IOException;

import fr.univtours.polytech.gestionnotes.business.NoteBusiness;
import fr.univtours.polytech.gestionnotes.business.NoteBusinessImpl;
import fr.univtours.polytech.gestionnotes.model.NoteBean;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet(name = "newNoteServlet", urlPatterns = { "/add" })
public class NewNoteServlet extends HttpServlet {
    // Dépendances vers les différents services métiers utiles.
    // Il n'y en a qu'un seul ici.
    private NoteBusiness business;

    @Override
    public void init() throws ServletException {
        // Instanciation de ces (cette ici) dépendances.
        this.business = new NoteBusinessImpl();
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        RequestDispatcher dispatcher = request.getRequestDispatcher("addNote.jsp");
        dispatcher.forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String studentId = request.getParameter("num");
        String studentNote = request.getParameter("note");
       
        NoteBean note = new NoteBean();
        note.setIdStudent(Integer.parseInt(studentId));
        note.setNote(Float.parseFloat(studentNote));

        business.insertNote(note);

        response.sendRedirect("home");
    }
}
