package com.cours.dao.impl.sql;

import com.cours.dao.IPersonneDao;
import com.cours.entities.Personne;
import com.cours.utils.Constants;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.log4j.chainsaw.Main;

public class SqlPersonneDaoImpl implements IPersonneDao {
	
	private static final Log log = LogFactory.getLog(Main.class);

    private static Connection connection = null;
	
	public SqlPersonneDaoImpl() {
		super();
	}

	public static Connection createConnection() {
        try {
            Class.forName(Constants.JDBC_DRIVER);
            connection = DriverManager.getConnection(Constants.DATABASE_URL, Constants.DATABASE_USER, Constants.DATABASE_PASSWORD);
        } catch (Exception e) {
            System.out.println("--> Erreur lors de l'execution, Exception: " + e.getMessage());
        }
        return connection;
    }

    public static void closeSqlResources(PreparedStatement preparedStatement, ResultSet result) {
        try {
            if (preparedStatement != null) {
                preparedStatement.close();
            }
        } catch (SQLException e) {
            System.out.println("Erreur lors de la fermeture du PreparedStatement , Exception : " + e);
        }
        try {
            if (result != null) {
                result.close();
            }
        } catch (SQLException e) {
            System.out.println("Erreur lors de la fermeture du ResultSet , Exception : " + e);
        }
        try {
            if (connection != null) {
            	connection.close();
            }
        } catch (SQLException e) {
            System.out.println("Erreur lors de la fermeture de Connection , Exception : " + e);
        }
    }

	@Override
    public List<Personne> findAll() {
    	createConnection();
    	List<Personne> personnes = new ArrayList<>();
        ResultSet result = null;
        PreparedStatement preparedStatement = null;
        try {
            String sqlCommand = "SELECT * FROM Personne";
            preparedStatement = (PreparedStatement) connection.prepareStatement(sqlCommand);
            result = preparedStatement.executeQuery();
            while (result.next()) {
            	Personne personne = new Personne(result.getInt("idPersonne"), result.getString("prenom"), result.getString("nom"), result.getDouble("poids"), result.getDouble("taille"), result.getString("rue"), result.getString("ville"), result.getString("codePostal"), result.getString("pays"));
            	personnes.add(personne);
            }
        } catch (Exception e) {
            System.out.println(" Erreur lors de l'execution de la methode, Exception : " + e);
        } finally {
            closeSqlResources(preparedStatement, result);
        }
        System.out.println("personnes récupérer : " + personnes);
        return personnes; 	
//        return new ArrayList<Personne>(Arrays.asList(
//                new Personne(1, "Maurice", "Dupont", 100.0, 170.0, "rue du paradis", "Rouen", "76000", "France"),
//                new Personne(2, "Martin", "Marshall", 55.0, 150.0, "rue de Nantes", "Laval", "53000", "France"),
//                new Personne(3, "Claire", "Chazal", 65.0, 175.0, "rue de Rennes", "Laval", "53000", "France"),
//                new Personne(4, "Celine", "Dia", 87.0, 170.0, "rue Diderot", "Paris", "75000", "France"),
//                new Personne(5, "Remy", "Cheval", 63.0, 140.0, "rue du paradis", "Nantes", "44000", "France"),
//                new Personne(6, "Nicolas", "Dutrou", 79.0, 155.0, "rue Appert", "Nantes", "44000", "France"),
//                new Personne(7, "Marie", "Claire", 65.0, 166.0, "rue du paradis", "Rouen", "76000", "France"),
//                new Personne(8, "Nathalie", "Sage", 89.0, 190.0, "rue Appert", "Rouen", "76000", "France"),
//                new Personne(9, "Jean", "Dujardin", 75.0, 140.0, "rue des sorciers", "Havre", "76800", "France"),
//                new Personne(10, "Michel", "Leclerc", 89.0, 190.0, "rue du bonneur", "Havre", "76800", "France"),
//                new Personne(11, "Julien", "Marshall", 60.0, 145.0, "rue de Nantes", "Laval", "53000", "France"),
//                new Personne(12, "Julien", "Claire", 78.0, 170.0, "rue du Paradis", "Paris", "75000", "France"),
//                new Personne(13, "Jacques", "Dupont", 63.0, 179.0, "rue des Passeurs", "Paris", "75000", "France"),
//                new Personne(14, "Charles", "Hallyday", 100.0, 200.0, "rue des Feugrais", "Rouen", "76000", "France"),
//                new Personne(15, "Serge", "Lama", 102.0, 195.0, "rue des Heureux", "Nantes", "44000", "France"),
//                new Personne(16, "Vincent", "Thomas", 81.0, 183.0, "rue de Paris", "Rennes", "35000", "France"),
//                new Personne(17, "Eric", "Dummat", 61.0, 155.0, "rue de Versaille", "Paris", "75000", "France"),
//                new Personne(18, "Nicolas", "Samuel", 64.0, 145.0, "rue de Saint Louis", "Laval", "53000", "France"),
//                new Personne(19, "Rémy", "Guerry", 79.0, 191.0, "rue des Sages", "Lyon", "69000", "France"),
//                new Personne(20, "Nicolas", "Drapeau", 56.0, 166.0, "rue Mitterrand", "Limoges", "87000", "France"),
//                new Personne(21, "Gaelle", "Letourneau", 96.0, 195.0, "rue Jean François", "Rouen", "76000", "France"),
//                new Personne(22, "Jacques", "Dupont", 85.0, 179.0, "rue des Anges", "Paris", "75000", "France")));
    }

    @Override
    public Personne findById(Integer id) {
    	createConnection();
    	Personne personne = null;
        ResultSet result = null;
        PreparedStatement preparedStatement = null;
        try {
            String sqlCommand = "SELECT * FROM Personne WHERE idPersonne = ?";
            preparedStatement = (PreparedStatement) connection.prepareStatement(sqlCommand);
            preparedStatement.setInt(1, id);
            result = preparedStatement.executeQuery();
            while (result.next()) {
                personne = new Personne(result.getInt("idPersonne"), result.getString("prenom"), result.getString("nom"), result.getDouble("poids"), result.getDouble("taille"), result.getString("rue"), result.getString("ville"), result.getString("codePostal"), result.getString("pays"));
            }
        } catch (Exception e) {
            System.out.println(" Erreur lors de l'execution de la methode, Exception : " + e);
        } finally {
            closeSqlResources(preparedStatement, result);
        }
        System.out.println("personne récupérer par id : " + personne);
        return personne;
    }

    @Override
    public Integer generateIdPersonne() {
        return null;
    }

    @Override
    public Personne create(Personne p) {
    	createConnection();
        PreparedStatement preparedStatement = null;
        try {
            String sqlCommand = "INSERT INTO personne (prenom, nom, poids, taille, rue, ville, codePostal, pays) VALUES (?, ?, ?, ?, ?, ?, ?, ?)";
            preparedStatement = (PreparedStatement) connection.prepareStatement(sqlCommand);
            preparedStatement.setString(1, p.getPrenom());
            preparedStatement.setString(2, p.getNom());
            preparedStatement.setDouble(3, p.getPoids());
            preparedStatement.setDouble(4, p.getTaille());
            preparedStatement.setString(5, p.getRue());
            preparedStatement.setString(6, p.getCodePostal());
            preparedStatement.setString(7, p.getVille());
            preparedStatement.setString(8, p.getPays());
            preparedStatement.executeUpdate(); 
        } catch (Exception e) {
            System.out.println(" Erreur lors de l'execution de la methode, Exception : " + e);
        } finally {
            closeSqlResources(preparedStatement, null);
        }
        System.out.println("personne inséré dans la BDD :" + p);
        return p;
    }

    @Override
    public Personne update(Personne p) {
    	createConnection();
    	PreparedStatement preparedStatement = null;
        try {
            String sqlCommand = "UPDATE personne SET prenom = ?, nom = ?, poids = ?, taille = ?, rue = ?, ville = ?, codePostal = ?, pays = ? WHERE idPersonne = ?";
            preparedStatement = (PreparedStatement) connection.prepareStatement(sqlCommand);
            preparedStatement.setString(1, p.getPrenom());
            preparedStatement.setString(2, p.getNom());
            preparedStatement.setDouble(3, p.getPoids());
            preparedStatement.setDouble(4, p.getTaille());
            preparedStatement.setString(5, p.getRue());
            preparedStatement.setString(6, p.getCodePostal());
            preparedStatement.setString(7, p.getVille());
            preparedStatement.setString(8, p.getPays());
            preparedStatement.setInt(9, p.getIdPersonne());
            preparedStatement.executeUpdate(); 
        } catch (Exception e) {
            System.out.println(" Erreur lors de l'execution de la methode, Exception : " + e);
        } finally {
            closeSqlResources(preparedStatement, null);
        }
        System.out.println("personne update dans la BDD :" + p);
        return p;
    }

    @Override
    public Boolean delete(Personne p) {
    	createConnection();
    	Boolean result = false;
    	PreparedStatement preparedStatement = null;
        try {
            String sqlCommand = "DELETE FROM personne WHERE prenom = ? AND nom = ? AND poids = ? AND taille = ? AND rue = ? AND ville = ? AND codePostal = ? AND pays = ? AND idPersonne = ?";
            preparedStatement = (PreparedStatement) connection.prepareStatement(sqlCommand);
            preparedStatement.setString(1, p.getPrenom());
            preparedStatement.setString(2, p.getNom());
            preparedStatement.setDouble(3, p.getPoids());
            preparedStatement.setDouble(4, p.getTaille());
            preparedStatement.setString(5, p.getRue());
            preparedStatement.setString(6, p.getCodePostal());
            preparedStatement.setString(7, p.getVille());
            preparedStatement.setString(8, p.getPays());
            preparedStatement.setInt(9, p.getIdPersonne());
            int resultPreparedStatement = preparedStatement.executeUpdate(); 
            
            if(resultPreparedStatement == 1) {
            	result = true;
            }else {
            	result = false;
            }
            
        } catch (Exception e) {
            System.out.println(" Erreur lors de l'execution de la methode, Exception : " + e);
        } finally {
            closeSqlResources(preparedStatement, null);
        }
        System.out.println("personne delete dans la BDD :" + p);
        return result;
    }

    @Override
    public Personne authenticate(String prenom, String nom) {
    	createConnection();
    	ResultSet result = null;
    	Personne personne = null;
    	PreparedStatement preparedStatement = null;
        try {
            String sqlCommand = "SELECT * FROM personne WHERE prenom = ? AND nom = ? LIMIT 1";
            preparedStatement = (PreparedStatement) connection.prepareStatement(sqlCommand);
            preparedStatement.setString(1, prenom);
            preparedStatement.setString(2, nom); 
        	result = preparedStatement.executeQuery();
        	while (result.next()) {
                personne = new Personne(result.getInt("idPersonne"), result.getString("prenom"), result.getString("nom"), result.getDouble("poids"), result.getDouble("taille"), result.getString("rue"), result.getString("ville"), result.getString("codePostal"), result.getString("pays"));
            }
        	
        } catch (Exception e) {
            System.out.println(" Erreur lors de l'execution de la methode, Exception : " + e);
        } finally {
            closeSqlResources(preparedStatement, null);
        }
        System.out.println("personne authenticate dans la BDD :" + personne);
        return personne;
    }
}
