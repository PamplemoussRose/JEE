package fr.univtours.polytech.gestionnotes_v2.servlet;

import java.io.IOException;
import java.util.List;

import fr.univtours.polytech.gestionnotes_v2.business.NoteBusiness;
import fr.univtours.polytech.gestionnotes_v2.model.ResultBean;
import jakarta.inject.Inject;
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
    @Inject
    private NoteBusiness business;

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        RequestDispatcher dispatcher = request.getRequestDispatcher("modifyNote.jsp");
        dispatcher.forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String method = request.getParameter("_method");
        if ("delete".equalsIgnoreCase(method)) {
            doDelete(request, response); // Appel de la méthode doDelete
        } else {

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

            resultAct.getNoteBean().setNote(Float.parseFloat(request.getParameter("note")));
            resultAct.getStudentBean().setFirstName(request.getParameter("firstName"));
            resultAct.getStudentBean().setName(request.getParameter("name"));

            business.updateResult(resultAct);

            response.sendRedirect("home");
        }
    }

    @Override
    protected void doDelete(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        // Recupere l'ID de la note
        Cookie[] cookies = request.getCookies();
        String idNote = null;

        for (Cookie cookie : cookies) {
            if (cookie.getName().equals("idNote")) {
                idNote = cookie.getValue(); // Récupérer la valeur du cookie "idNote"
                break;
            }
        }

        // Recupere le bean de la note
        List<ResultBean> results = business.getResultsList();
        ResultBean resultAct = null;

        for (ResultBean result : results) {
            if (result.getNoteBean().getIdNote().equals(Integer.parseInt(idNote))) {
                resultAct = result;
                break;
            }
        }

        // Fait le traitement sur la note
        business.deleteNote(resultAct.getNoteBean());

        // Redirige vers la page 'home'
        response.sendRedirect("home");
    }
}
