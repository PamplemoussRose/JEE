package fr.univtours.polytech.td3.servlet;

import java.io.IOException;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet(name = "counterServlet", urlPatterns = { "/counter" })
public class CounterServlet extends HttpServlet {
    private int passage;
    private String sessionId = "";

    public int getPassage() {
        return this.passage;
    }

    public void setPassage(int value) {
        this.passage = value;
    }

    public String gerSessionId() {
        return this.sessionId;
    }

    public void setSessionId(String value) {
        this.sessionId = value;
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        if (!request.getSession().getId().equals(sessionId)) {
            sessionId = request.getSession().getId();
            passage = 1;
        } else {
            passage += 1;
        }
        request.setAttribute("PASSAGE", getPassage());
        RequestDispatcher dispatcher = request.getRequestDispatcher("passage.jsp");
        dispatcher.forward(request, response);
    }

}
