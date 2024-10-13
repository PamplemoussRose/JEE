package fr.univtours.polytech.gestionnotes.servlet;

import java.io.IOException;

import fr.univtours.polytech.gestionnotes.business.NoteBusiness;
import fr.univtours.polytech.gestionnotes.business.NoteBusinessImpl;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet(name = "modifyNoteServlet", urlPatterns = { "/modify" })
public class ModifyNoteServlet extends HttpServlet {
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
        RequestDispatcher dispatcher = request.getRequestDispatcher("modifyNote.jsp");
        dispatcher.forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        RequestDispatcher dispatcher = request.getRequestDispatcher("notesList.jsp");
        dispatcher.forward(request, response);
    }
}
