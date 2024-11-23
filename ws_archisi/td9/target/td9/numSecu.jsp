<%@ taglib prefix="c" uri="jakarta.tags.core" %>
    <%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1" %>
        <!DOCTYPE html>
        <html>

        <head>
            <meta charset="ISO-8859-1">
            <title>Numero de securite</title>
        </head>

        <body>
            <form action="num" method="post">
                <label for="numero">Numero de secu</label>
                <input type="number" name="numero" id="numero" required>
                <input type="submit" value="Verifier">
            </form>
            <c:if test="${not empty requestScope.VALIDE}">
                ${requestScope.VALIDE}
            </c:if>
        </body>

        </html>