<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
    <html>

    <head>
        <title>Affiche prenom</title>
        <meta charset="UTF-8" />
    </head>

    <body>
        <p>Salut <%=request.getSession().getAttribute("PRENOM")%> !</p>
        <form action="prenom" method="get">
            <button type="submit">retour page formulaire</button>
        </form>
        <form action="counter" method="get">
            <button type="submit">page counter</button>
        </form>

    </body>

    </html>