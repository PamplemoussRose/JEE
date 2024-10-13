package fr.univtours.polytech.td2.servlet;

import java.io.IOException;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet(name = "ConnectionServlet", urlPatterns = { "/connection", "/login" })
public class ConnectionServlet extends HttpServlet {

    public void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        RequestDispatcher dispatcher = request.getRequestDispatcher("formEx4.html");
        dispatcher.forward(request, response);
    }

    public void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String mdp = request.getParameter("mdp");
        if (mdp.equals("password")) {
            RequestDispatcher dispatcher = request.getRequestDispatcher("logedIn.html");
            dispatcher.forward(request, response);
        } else {
            RequestDispatcher dispatcher = request.getRequestDispatcher("formEx4Error.html");
            dispatcher.forward(request, response);
        }
    }
}