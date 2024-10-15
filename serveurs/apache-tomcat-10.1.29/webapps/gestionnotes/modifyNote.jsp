<%@ taglib prefix="c" uri="jakarta.tags.core" %>
    <%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1" %>
        <!DOCTYPE html>
        <html>

        <head>
            <meta charset="ISO-8859-1">
            <title>Gestion des notes</title>
            <link rel="stylesheet" href="styles.css">
            <script>
                window.onload = function() {
                  const params = new URLSearchParams(window.location.search);
                  document.getElementById('firstName').value = params.get('firstName') || '';
                  document.getElementById('name').value = params.get('name') || '';
                  document.getElementById('note').value = params.get('note') || '';
                };
              </script>
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
                    <input type="number" name="note" id="note" min="0" max="20" required>

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