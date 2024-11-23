package fr.univtours.polytech.td9.servlet;

import java.io.IOException;

import fr.univtours.polytech.td9.business.CapBusiness;
import jakarta.inject.Inject;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet(name = "capServlet", urlPatterns = { "/capitale" })
public class CapServlet extends HttpServlet {

    @Inject
    private CapBusiness business;

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        RequestDispatcher dispatcher = request.getRequestDispatcher("capitale.jsp");
        dispatcher.forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String code = request.getParameter("pays");
        String capitale = business.getCapitalCity(code);
        request.setAttribute("CAPITALE", capitale);
        RequestDispatcher dispatcher = request.getRequestDispatcher("capitale.jsp");
        dispatcher.forward(request, response);
    }

}
