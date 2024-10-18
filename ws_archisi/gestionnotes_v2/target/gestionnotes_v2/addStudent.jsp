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
                <h1>Ajout d'un eleve</h1>
                <form action="addStudent" method="post">
                    <label for="name">Nom de l'étudiant</label>
                    <input type="text" name="name" id="name" required>

                    <label for="firstName">Prenom de l'étudiant</label>
                    <input type="text" name="firstName" id="firstName" required>

                    <input type="submit" value="Ajouter l'eleve">
                </form>
            </section>
            <section>
                <form action="home" method="get">
                    <input type="submit" value="Home">
                </form>
                <form action="addNote" method="get">
                    <input type="submit" value="Ajout Note">
                </form>
            </section>
        </body>

        </html>