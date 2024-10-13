package fr.univtours.polytech.td2.servlet;

import java.io.IOException;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet(name = "ChoixPageServlet", urlPatterns = { "/choix" })
public class ChoixPageServlet extends HttpServlet {

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        RequestDispatcher dispatcher = request.getRequestDispatcher("choixPage.html");
        dispatcher.forward(request, response);
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String page = request.getParameter("page");
        if (page.equals("1")) {
            RequestDispatcher dispatcher = request.getRequestDispatcher("page1.html");
            dispatcher.forward(request, response);
        } else if (page.equals("2")) {
            RequestDispatcher dispatcher = request.getRequestDispatcher("page2.html");
            dispatcher.forward(request, response);
        } else {
            RequestDispatcher dispatcher = request.getRequestDispatcher("page3.html");
            dispatcher.forward(request, response);
        }
    }
}
