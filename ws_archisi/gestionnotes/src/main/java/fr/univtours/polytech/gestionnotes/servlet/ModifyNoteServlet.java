package fr.univtours.polytech.gestionnotes.servlet;

import java.io.IOException;
import java.util.List;

import fr.univtours.polytech.gestionnotes.business.NoteBusiness;
import fr.univtours.polytech.gestionnotes.business.NoteBusinessImpl;
import fr.univtours.polytech.gestionnotes.model.ResultBean;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.Cookie;
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
        Cookie[] cookies = request.getCookies();
        String idNote = null;

        for (Cookie cookie : cookies) {
            if (cookie.getName().equals("idNote")) {
                idNote = cookie.getValue(); // Récupérer la valeur du cookie "idNote"
                break;
            }
        }

        List<ResultBean> results = business.getResultsList();
        ResultBean resultAct = null;

        for (ResultBean result : results) {
            if (result.getNoteBean().getIdNote().equals(Integer.parseInt(idNote))) {
                resultAct = result;
                break;
            }
        }
        System.out.println(request.getParameter("note") + " - " + request.getParameter("firstName") + " - "
                + request.getParameter("name"));

        resultAct.getNoteBean().setNote(Float.parseFloat(request.getParameter("note")));
        resultAct.getStudentBean().setFirstName(request.getParameter("firstName"));
        resultAct.getStudentBean().setName(request.getParameter("name"));

        business.updateResult(resultAct);

        response.sendRedirect("home");
    }
}
