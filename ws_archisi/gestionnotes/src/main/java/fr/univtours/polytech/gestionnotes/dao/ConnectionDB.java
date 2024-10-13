package fr.univtours.polytech.gestionnotes.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import javax.naming.NamingException;

/**
 * Cette classe gère la connexion à la base de données.
 * 
 * Elle propose une méthode statique createConnection() qui établit la connexion avec la BDD.
 */
public class ConnectionDB {

    /**
     * À adapter en fonction de vos paramètres !!
     */
    private static final String DB_URL = "jdbc:mysql://localhost:3307/gestion_notes";
    private static final String DB_USER = "root";
    private static final String DB_PWD = "";

    /**
     * Permet d'ouvrir la connexion.
     * 
     * @return L'object {@link ConnectionDB} correspondant.
     * @throws SQLException
     * @throws NamingException
     */
    public static Connection createConnection() throws SQLException, NamingException {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            return DriverManager.getConnection(DB_URL, DB_USER, DB_PWD);
        } catch (SQLException sqle) {
            sqle.printStackTrace();
        } catch (ClassNotFoundException ce) {
            ce.printStackTrace();
        }

        return null;
    }
}