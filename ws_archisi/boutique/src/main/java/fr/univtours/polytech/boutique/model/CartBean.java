package fr.univtours.polytech.boutique.model;

import java.io.Serializable;

public class CartBean implements Serializable {

    private Integer penNumber = 0; // Le nombre de stylo.
    private Integer feltNumber = 0; // Le nombre de feutre.
    private Integer rubberNumber = 0; // Le nombre de gomme.
    private Double cartPrice = 0D; // Le prix du panier.
    private Double shippingCost = 0D; // Les éventuels frais de livraison.
    private Double totalPrice = 0D; // Le prix total.

    public Integer getPenNumber() {
        return penNumber;
    }

    public void setPenNumber(Integer penNumber) {
        this.penNumber = penNumber;
    }

    public Integer getFeltNumber() {
        return feltNumber;
    }

    public void setFeltNumber(Integer feltNumber) {
        this.feltNumber = feltNumber;
    }

    public Integer getRubberNumber() {
        return rubberNumber;
    }

    public void setRubberNumber(Integer rubberNumber) {
        this.rubberNumber = rubberNumber;
    }

    public Double getCartPrice() {
        return cartPrice;
    }

    public void setCartPrice(Double cartPrice) {
        this.cartPrice = cartPrice;
    }

    public Double getShippingCost() {
        return shippingCost;
    }

    public void setShippingCost(Double shippingCost) {
        this.shippingCost = shippingCost;
    }

    public Double getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(Double totalPrice) {
        this.totalPrice = totalPrice;
    }


    
}
