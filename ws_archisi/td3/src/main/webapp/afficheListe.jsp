<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
    <%@page import="java.util.List" %>
        <html>

        <head>
            <title>Affiche une liste dynamique</title>
            <meta charset="UTF-8" />
        </head>

        <body>
            <form action="liste" method="post">
                <input type="number" name="taille" value="<%=((List<String>)request.getAttribute(" LISTE")).size()%>"/>
                <input type="submit" name="Valider" />
            </form>
            <table>
                <% List<String> liste = (List<String>)request.getAttribute("LISTE");
                        for (String mot : liste) {
                        %>
                        <tr>
                            <td>
                                <%=mot %>
                            </td>
                        </tr>
                        <% } %>
            </table>
        </body>

        </html>