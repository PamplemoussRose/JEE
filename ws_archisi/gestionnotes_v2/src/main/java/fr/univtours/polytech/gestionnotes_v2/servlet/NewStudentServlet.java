package fr.univtours.polytech.gestionnotes_v2.servlet;

import java.io.IOException;

import fr.univtours.polytech.gestionnotes_v2.business.NoteBusiness;
import fr.univtours.polytech.gestionnotes_v2.business.NoteBusinessImpl;
import fr.univtours.polytech.gestionnotes_v2.model.StudentBean;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet(name = "newStudentServlet", urlPatterns = { "/addStudent" })
public class NewStudentServlet extends HttpServlet {
    // Dépendances vers les différents services métiers utiles.
    // Il n'y en a qu'un seul ici.
    private NoteBusiness business;

    @Override
    public void init() throws ServletException {
        // Instanciation de ces (cette ici) dépendances.
        this.business = new NoteBusinessImpl();
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        RequestDispatcher dispatcher = request.getRequestDispatcher("addStudent.jsp");
        dispatcher.forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String studentName = request.getParameter("name");
        String studentFirstName = request.getParameter("firstName");
       
        StudentBean student = new StudentBean();
        student.setName(studentName);
        student.setFirstName(studentFirstName);

        business.insertStudent(student);

        response.sendRedirect("home");
    }
}
