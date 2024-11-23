package fr.univtours.polytech.td9.servlet;

import java.io.IOException;

import jakarta.inject.Inject;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import webService.Secu;

@WebServlet(name = "secuServlet", urlPatterns = "/num")
public class SecuServlet extends HttpServlet {

    @Inject
    private Secu ws;

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        RequestDispatcher dispatcher = request.getRequestDispatcher("numSecu.jsp");
        dispatcher.forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String numero = request.getParameter("numero");
        long num = Long.parseLong(numero);
        boolean valide = ws.cleCorrecte(num);
        request.setAttribute("VALIDE", valide);
        RequestDispatcher dispatcher = request.getRequestDispatcher("numSecu.jsp");
        dispatcher.forward(request, response);
    }
}
