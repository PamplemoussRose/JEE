package fr.univtours.polytech.boutique.controller;

import java.io.IOException;

import fr.univtours.polytech.boutique.business.StoreBusiness;
import fr.univtours.polytech.boutique.business.StoreBusinessImpl;
import fr.univtours.polytech.boutique.model.CartBean;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class StoreServlet extends HttpServlet {

    private StoreBusiness storeBusiness;;

    @Override
    public void init() throws ServletException {
        this.storeBusiness = new StoreBusinessImpl();
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        CartBean cartBean = new CartBean();
        request.setAttribute("USER_CART", cartBean);

        RequestDispatcher dispatcher = request.getRequestDispatcher("store.jsp");
        dispatcher.forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String penNumber = request.getParameter("penNb");
        String feltNumber = request.getParameter("feltNb");
        String rubberNumber = request.getParameter("rubberNb");

        CartBean cart = new CartBean();
        cart.setPenNumber(Integer.parseInt(penNumber));
        cart.setFeltNumber(Integer.parseInt(feltNumber));
        cart.setRubberNumber(Integer.parseInt(rubberNumber));

        cart = this.storeBusiness.computePrices(cart);

        request.setAttribute("USER_CART", cart);
        RequestDispatcher dispatcher = request.getRequestDispatcher("store.jsp");
        dispatcher.forward(request, response);
    }
}
