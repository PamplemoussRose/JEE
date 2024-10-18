<%@ taglib prefix="c" uri="jakarta.tags.core" %>
    <%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1" %>
        <!DOCTYPE html>
        <html>

        <head>
            <meta charset="ISO-8859-1">
            <title>Gestion des notes</title>
            <link rel="stylesheet" href="styles.css">
            <script>
                // Fonction pour définir un cookie
                function setCookie(cname, cvalue) {
                    document.cookie = cname + "=" + cvalue + ";path=/";
                }

                // Fonction appelée lors du clic sur une ligne de note
                function handleNoteClick(idNote, firstName, name, note) {
                    // Définir l'ID de la note dans un cookie
                    setCookie('idNote', idNote); // Le cookie expire après 1 jour

                    // Rediriger vers la page de modification
                    window.location.href = "modify?firstName="+firstName+"&name="+name+"&note="+note;
                }
            </script>
        </head>

        <body>
            <section>
                <h1>Liste des notes</h1>
                <table border=1>
                    <tr style="background-color: lightgray;">
                        <th>Prénom</th>
                        <th>Nom</th>
                        <th>Note</th>
                    </tr>
                    <c:forEach items="${requestScope.LISTE_NOTES}" var="note">
                        <tr
                            onclick="handleNoteClick('${note.getNoteBean().idNote}', '${note.getStudentBean().firstName}', '${note.getStudentBean().name}', '${note.getNoteBean().note}')">
                            <td>${note.getStudentBean().firstName}</td>
                            <td>${note.getStudentBean().name}</td>
                            <td>${note.getNoteBean().note}</td>
                        </tr>
                    </c:forEach>
                </table>
                <c:if test="${not empty requestScope.RESULTS_MEAN}">
                    La moyenne est de ${requestScope.RESULTS_MEAN}
                </c:if>
            </section>
            <section>
                <form action="addNote" method="get">
                    <input type="submit" value="Ajout Note">
                </form>
                <form action="addStudent" method="get">
                    <input type="submit" value="Ajout Eleve">
                </form>
            </section>
        </body>

        </html>