package fr.univtours.polytech.td3.servlet;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet(name = "listeServlet", urlPatterns = { "/liste" })
public class ListsServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        request.setAttribute("LISTE", new ArrayList<String>());
        request.getRequestDispatcher("afficheListe.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        Integer taille = Integer.parseInt(request.getParameter("taille"));
        List<String> liste = new ArrayList<String>();
        for (int i = 0; i < taille; i++) {
            liste.add("Bonjour !");
        }
        request.setAttribute("LISTE", liste);
        request.getRequestDispatcher("afficheListe.jsp").forward(request, response);
    }

}
