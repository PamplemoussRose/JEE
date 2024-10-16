package fr.univtours.polytech.gestionnotes.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import fr.univtours.polytech.gestionnotes.model.NoteBean;

public class NoteDaoImpl implements NoteDao {

    @Override
    public List<NoteBean> getNotesList() {
        Statement st = null;
        ResultSet rs = null;
        Connection connection = null;
        List<NoteBean> notesList = null;

        try {
            // Lecture de la table NOTE :
            final String sql = "SELECT ID_NOTE, ID_STUDENT, NOTE from gestion_notes.NOTE;";
            connection = ConnectionDB.createConnection();
            st = connection.createStatement();
            rs = st.executeQuery(sql);
            notesList = mapResultSetToList(rs);
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
        return notesList;
    }

    @Override
    public void insertNote(NoteBean note) {
        // On utilisera ici des PreparedStatement plutôt que des Statement pour des
        // raisons de sécurité.
        PreparedStatement st = null;
        Connection connection = null;

        try {
            connection = ConnectionDB.createConnection();
            final String sqlInsert = "INSERT INTO NOTE (ID_STUDENT, NOTE) values (?, ?);";
            st = connection.prepareStatement(sqlInsert);
            st.setInt(1, note.getIdStudent());
            st.setDouble(2, note.getNote());
            st.execute();
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
    public void updateNote(NoteBean note) {
        // On utilisera ici des PreparedStatement plutôt que des Statement pour des
        // raisons de sécurité.
        PreparedStatement st = null;
        Connection connection = null;

        try {
            connection = ConnectionDB.createConnection();
            final String sqlInsert = "UPDATE note SET ID_STUDENT = ?, NOTE = ? WHERE note.ID_NOTE = ? ;";
            st = connection.prepareStatement(sqlInsert);
            st.setInt(1, note.getIdStudent());
            st.setDouble(2, note.getNote());
            st.setInt(3, note.getIdNote());
            st.executeUpdate();
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
     * requête, et la liste d'objets {@link NoteBean}.
     * 
     * @param rs Le {@link ResultSet} à transformer.
     * @return La liste de {@link NoteBean} qui correspond.
     * @throws SQLException
     */
    private final List<NoteBean> mapResultSetToList(final ResultSet rs) throws SQLException {
        List<NoteBean> notesList = new ArrayList<NoteBean>();
        while (rs.next()) {
            // Pour chaque ligne de la table,
            // on instancie un nouveau NoteBean.
            final NoteBean noteBean = new NoteBean();
            noteBean.setIdNote(rs.getInt("ID_NOTE")); // Il faut indiquer le nom du champ en BDD, ici, 'ID_NOTE'.
            noteBean.setIdStudent(rs.getInt("ID_STUDENT"));
            noteBean.setNote(rs.getFloat("NOTE"));
            // On ajoute ce bean à la liste des résultats.
            notesList.add(noteBean);
        }
        return notesList;
    }

}
