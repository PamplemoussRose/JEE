package fr.univtours.polytech.td2.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet(name = "maPremiereServlet", urlPatterns = { "/maPremiere" })
public class MaPremiereServlet extends HttpServlet {

    public void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        RequestDispatcher dispatcher = request.getRequestDispatcher("premierFormulaire.html");
        dispatcher.forward(request, response);
    }

    public void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html");
        // Récupération de la valeur du champ dont l'attribut "name" est "prenom".
        String prenom = request.getParameter("prenom");
        // Génération du code HTML.
        PrintWriter out = response.getWriter();
        out.println("<html><head></head><body>Salut " + prenom + " !</body></html>");
    }
}