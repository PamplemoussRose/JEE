<%@ taglib prefix="c" uri="jakarta.tags.core" %>
    <%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1" %>
        <!DOCTYPE html>
        <html>

        <head>
            <meta charset="ISO-8859-1">
            <title>Capitale</title>
        </head>

        <body>
            <form action="capitale" method="post">
                <label for="pays">Code ISO du pays</label>
                <input type="text" name="pays" id="pays" required>
                <input type="submit" value="Afficher">
            </form>
            <c:if test="${not empty requestScope.CAPITALE}">
                ${requestScope.CAPITALE}
            </c:if>
        </body>

        </html>