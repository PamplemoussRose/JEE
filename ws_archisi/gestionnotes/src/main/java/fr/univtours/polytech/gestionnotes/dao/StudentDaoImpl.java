package fr.univtours.polytech.gestionnotes.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import fr.univtours.polytech.gestionnotes.model.StudentBean;

public class StudentDaoImpl implements StudentDao {

    @Override
    public StudentBean getStudent(Integer id) {
        PreparedStatement st = null;
        ResultSet rs = null;
        Connection connection = null;
        List<StudentBean> studentsList = null;

        try {
            // Lecture de la table student :
            final String sql = "SELECT * from gestion_notes.STUDENT where ID_STUDENT = ?;";
            connection = ConnectionDB.createConnection();
            st = connection.prepareStatement(sql);
            st.setInt(1, id);
            rs = st.executeQuery();
            studentsList = mapResultSetToList(rs);
        } catch (Exception e) {
            // S'il y a eu un problème, on le fait remonter.
            throw new RuntimeException(e);
        } finally {
            try {
                // Dans tous les cas, on ferme tout ce qui doit l'être.
                st.close();
                connection.close();
            } catch (Exception e) {
                // S'il y a eu un problème, on le fait remonter.
                throw new RuntimeException(e);
            }
        }
        return studentsList.get(0);
    }

    @Override
    public void insertStudent(StudentBean student) {
        PreparedStatement st = null;
        Connection connection = null;

        try {
            final String sql = "INSERT INTO student (NAME, FIRST_NAME) VALUES (?, ?);";
            connection = ConnectionDB.createConnection();
            st = connection.prepareStatement(sql);
            st.setString(1, student.getName());
            st.setString(2, student.getFirstName());
            st.executeQuery();
        } catch (Exception e) {
            // S'il y a eu un problème, on le fait remonter.
            throw new RuntimeException(e);
        } finally {
            try {
                // Dans tous les cas, on ferme tout ce qui doit l'être.
                st.close();
                connection.close();
            } catch (Exception e) {
                // S'il y a eu un problème, on le fait remonter.
                throw new RuntimeException(e);
            }
        }
    }

    @Override
    public void updateStudent(StudentBean student) {
        PreparedStatement st = null;
        Connection connection = null;

        try {
            // ----------- MODIFIER LA REQUETTE -----------
            final String sql = "UPDATE student SET NAME = ?, FIRST_NAME = ? WHERE student.ID_STUDENT = ? ;";
            connection = ConnectionDB.createConnection();
            st = connection.prepareStatement(sql);
            st.setString(1, student.getName());
            st.setString(2, student.getFirstName());
            st.setInt(3, student.getIdStudent());
            st.executeQuery();
        } catch (Exception e) {
            // S'il y a eu un problème, on le fait remonter.
            throw new RuntimeException(e);
        } finally {
            try {
                // Dans tous les cas, on ferme tout ce qui doit l'être.
                st.close();
                connection.close();
            } catch (Exception e) {
                // S'il y a eu un problème, on le fait remonter.
                throw new RuntimeException(e);
            }
        }
    }

    /**
     * Permet d'effectuer le mapping entre le {@link ResultSet} renvoyé par la
     * requête, et la liste d'objets {@link StudentBean}.
     * 
     * @param rs Le {@link ResultSet} à transformer.
     * @return La liste de {@link StudentBean} qui correspond.
     * @throws SQLException
     */
    private final List<StudentBean> mapResultSetToList(final ResultSet rs) throws SQLException {
        List<StudentBean> studentsList = new ArrayList<StudentBean>();
        while (rs.next()) {
            // Pour chaque ligne de la table,
            // on instancie un nouveau studentsBean.
            final StudentBean studentBean = new StudentBean();
            studentBean.setIdStudent(rs.getInt("ID_STUDENT")); // Il faut indiquer le nom du champ en BDD, ici,
            studentBean.setName(rs.getString("NAME"));
            studentBean.setFirstName(rs.getString("FIRST_NAME"));
            // On ajoute ce bean à la liste des résultats.
            studentsList.add(studentBean);
        }
        return studentsList;
    }

}
