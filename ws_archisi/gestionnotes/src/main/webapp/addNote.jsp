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
                <h1>Ajout d'une note</h1>
                <form action="add" method="post">
                    <label for="num">Numero de l'étudiant</label>
                    <input type="number" name="num" id="num" min="0" required>

                    <label for="note">Note de l'étudiant</label>
                    <input type="number" name="note" id="note" min="0" max="20" required>

                    <input type="submit" value="Ajouter la note">
                </form>
            </section>
            <section>
                <form action="home" method="get">
                    <input type="submit" value="Home">
                </form>
            </section>
        </body>

        </html>