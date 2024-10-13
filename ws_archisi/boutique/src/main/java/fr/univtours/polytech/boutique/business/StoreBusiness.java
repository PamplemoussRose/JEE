package fr.univtours.polytech.boutique.business;

import fr.univtours.polytech.boutique.model.CartBean;

public interface StoreBusiness {
    public CartBean computePrices(CartBean cart);
}
