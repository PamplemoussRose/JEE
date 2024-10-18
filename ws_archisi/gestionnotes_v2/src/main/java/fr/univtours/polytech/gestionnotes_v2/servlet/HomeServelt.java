package fr.univtours.polytech.gestionnotes_v2.servlet;

import java.io.IOException;
import java.util.List;

import fr.univtours.polytech.gestionnotes_v2.business.NoteBusiness;
import fr.univtours.polytech.gestionnotes_v2.business.NoteBusinessImpl;
import fr.univtours.polytech.gestionnotes_v2.model.ResultBean;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet(name = "homeServlet", urlPatterns = { "/home" })
public class HomeServelt extends HttpServlet {
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
        List<ResultBean> results = business.getResultsList();
        request.setAttribute("LISTE_NOTES", results);
        if (results.size() != 0) {
            float mean = business.computeMean(results);
            request.setAttribute("RESULTS_MEAN", mean);
        }
        RequestDispatcher dispatcher = request.getRequestDispatcher("notesList.jsp");
        dispatcher.forward(request, response);
    }
}
