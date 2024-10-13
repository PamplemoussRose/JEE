package fr.univtours.polytech.td2.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.rmi.server.UID;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet(name = "CookieServlet", urlPatterns = { "/cookie" })
public class CookieServlet extends HttpServlet {

    public void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        Cookie[] cookies = request.getCookies();
        PrintWriter out = response.getWriter();
        if (null != cookies) {
            for (Cookie cookie : cookies) {
                if (cookie.getName().equals("id_mon_site")) {
                    out.println("<html><head></head><body>Encore vous !</body></html>");
                }
            }
        } else {
            UID idMonSite = new UID();
            String id = idMonSite.toString();
            Cookie cookie = new Cookie("id_mon_site", id);
            cookie.setMaxAge(5);
            response.addCookie(cookie);
            out.println("<html><head></head><body>Bienvenue !</body></html>");
        }

    }
}