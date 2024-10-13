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
                <h1>Modification d'une note</h1>
                <form action="modify" method="post">
                    <label for="firstName">Prenom de l'étudiant</label>
                    <input type="text" name="firstName" id="firstName" required>

                    <label for="name">Nom de l'étudiant</label>
                    <input type="text" name="name" id="name" required>

                    <label for="note">Note de l'étudiant</label>
                    <input type="number" name="note" id="note" min="0" required>

                    <input type="submit" value="Modifier la ligne">
                </form>
            </section>
            <section>
                <form action="home" method="get">
                    <input type="submit" value="Home">
                </form>
                <form action="add" method="get">
                    <input type="submit" value="Ajout Note">
                </form>
            </section>
        </body>

        </html>