<%@ taglib prefix="c" uri="jakarta.tags.core" %>
    <%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1" %>
        <!DOCTYPE html>
        <html>

        <head>
            <meta charset="ISO-8859-1">
            <title>Gestion des notes</title>
            <link rel="stylesheet" href="styles.css">
        </head>

        <body>
            <section>
                <h1>Liste des notes</h1>
                <table border=1>
                    <tr>
                        <th>Prénom</th>
                        <th>Nom</th>
                        <th>Note</th>
                    </tr>
                    <c:forEach items="${requestScope.LISTE_NOTES}" var="note">
                        <tr>
                            <td>${note.getStudentBean().firstName}</td>
                            <td>${note.getStudentBean().name}</td>
                            <td>${note.getNoteBean().note}
                        </tr>
                    </c:forEach>
                </table>
                <c:if test="${not empty requestScope.RESULTS_MEAN}">
                    La moyenne est de ${requestScope.RESULTS_MEAN}
                </c:if>
            </section>
            <section>
                <form action="add" method="get">
                    <input type="submit" value="Ajout Note">
                </form>
            </section>
        </body>

        </html>