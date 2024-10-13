<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1" %>
    <!DOCTYPE html>
    <html>

    <head>
        <meta charset="ISO-8859-1">
        <title>Boutique en ligne</title>
    </head>

    <body>
        <h1>Sélection des produits</h1>
        <form action="store" method="post">
            <fieldset>
                <legend>Liste des produits</legend>
                <table>
                    <tr>
                        <td>Stylo</td>
                        <td><input type="number" min="0" step="1" name="penNb" value="${requestScope.USER_CART.penNumber}" required/>
                        <td></td>
                    </tr>
                    <tr>
                        <td>Feutre</td>
                        <td><input type="number" min="0" step="1" name="feltNb" value="${requestScope.USER_CART.feltNumber}" required/>
                        <td></td>
                    </tr>
                    <tr>
                        <td>Gomme</td>
                        <td><input type="number" min="0" step="1" name="rubberNb" value="${requestScope.USER_CART.rubberNumber}" required/>
                        <td></td>
                    </tr>
                </table>
            </fieldset>
            <input type="submit" value="Valider" />
        </form>

        <fieldset>
            <legend>Récapitulatif du panier</legend>
            <table>
                <tr>
                    <td>Panier :</td>
                    <td>
                        ${requestScope.USER_CART.cartPrice}
                    </td>
                </tr>
                <tr>
                    <td>Frais livraison :</td>
                    <td>
                        ${requestScope.USER_CART.shippingCost}
                    </td>
                </tr>
                <tr>
                    <td>Prix total :</td>
                    <td>
                        ${requestScope.USER_CART.totalPrice}
                    </td>
                </tr>
            </table>
        </fieldset>
    </body>

    </html>