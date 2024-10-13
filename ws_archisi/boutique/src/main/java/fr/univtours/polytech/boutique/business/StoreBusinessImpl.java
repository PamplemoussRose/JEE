package fr.univtours.polytech.boutique.business;

import fr.univtours.polytech.boutique.model.CartBean;

public class StoreBusinessImpl implements StoreBusiness {

    private final static Double PEN_PRICE = 1.2D;
    private final static Double FELT_PRICE = 1.8D;
    private final static Double RUBBER_PRICE = 2D;;

    @Override
    public CartBean computePrices(CartBean cart) {
        // Application de la RG1 :
        Double cartPrice = cart.getPenNumber() * PEN_PRICE + cart.getFeltNumber() * FELT_PRICE
                + cart.getRubberNumber() * RUBBER_PRICE;
        // Application de la RG2 :
        Double shippingCost = 5D;
        if (cartPrice >= 15) {
            shippingCost = 0D;
        }
        // Application de la RG3 :
        Double totalPrice = cartPrice + shippingCost;

        // Mise à jour du panier :
        cart.setCartPrice(cartPrice);
        cart.setShippingCost(shippingCost);
        cart.setTotalPrice(totalPrice);

        return cart;
    }

}