<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
    <html>

    <head>
        <title>Affiche le nombre de passage sur la page</title>
        <meta charset="UTF-8" />
    </head>

    <body>
        <p><%=request.getSession().getAttribute("PRENOM")%> est passé <%=request.getAttribute("PASSAGE")%> fois sur cette page !</p>
        <form action="prenom" method="get">
            <button type="submit">page prenom</button>
        </form>
        
    </body>

    </html>