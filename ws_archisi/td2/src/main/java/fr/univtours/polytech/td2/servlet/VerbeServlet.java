package fr.univtours.polytech.td2.servlet;

import java.io.IOException;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet(name = "VerbeServlet", urlPatterns = { "/verbe" })
public class VerbeServlet extends HttpServlet {

    public void service(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String verbe = request.getParameter("verbe");
        System.out.println(verbe);
        switch (verbe) {
            case "GET":
                doGet(request, response);
                break;
            case "POST":
                doPost(request, response);
                break;
            case "PUT":
                doPut(request, response);
                break;
            case "DELETE":
                doDelete(request, response);
                break;
        }
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html");
        response.getWriter().append("<html><head></head><body>Verbe GET appelé</body></html>");
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html");
        response.getWriter().append("<html><head></head><body>Verbe POST appelé</body></html>");
    }

    @Override
    protected void doPut(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html");
        response.getWriter().append("<html><head></head><body>Verbe PUT appelé</body></html>");
    }

    @Override
    protected void doDelete(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html");
        response.getWriter().append("<html><head></head><body>Verbe DELETE appelé</body></html>");
    }

}
