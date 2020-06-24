package com.dao.test;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
import com.cours.dao.src.main.java.com.cours.dao.IPersonneDao;
import com.cours.dao.src.main.java.com.cours.dao.factory.AbstractDaoFactory;
import com.cours.entities.Personne;
import com.cours.utils.Constants;
import com.ibatis.common.jdbc.ScriptRunner;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.List;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;

public class JUnitDao {

    private static final Log log = LogFactory.getLog(JUnitDao.class);
    private static IPersonneDao personneDao = null;
    private static List<Personne> personnes = null;
    // Compter le nombre de personnes dans votre base de données.
    private static final int NB_PERSONNES_LIST = 14;
    private static final int NB_PERSONNES_FIND_BY_PRENOM = 2;
    private static final int NB_PERSONNES_FIND_BY_NOM = 2;
    private static final int NB_PERSONNES_FIND_BY_CODE_POSTAL = 6;
    private static final String FIND_PERSONNES_BY_PRENOM = "Julien";
    private static final String FIND_PERSONNES_BY_NOM = "Claire";
    private static final int NB_PERSONNES_FIND_BY_VILLE = 6;
    private static final String FIND_PERSONNES_BY_VILLE = "Paris";
    private static final String FIND_PERSONNES_BY_CODE_POSTAL = "75000";

    @BeforeClass
    public static void init() throws Exception {
        // configuration de l'application
        log.debug("Entree de la methode");
        initDataBase();
        personneDao = AbstractDaoFactory.getDaoFactory(AbstractDaoFactory.FactoryType.SQL_DAO).getPersonneDao();
        personnes = personneDao.findAll();
        log.debug("Sortie de la methode");
    }

    public static void initDataBase() {
        // Initialiser les données de la base de données
        log.debug("Entree de la methode");
        String scriptSqlPath = Constants.SQL_JUNIT_PATH_FILE;
        Reader reader = null;
        Connection connection = null;
        try {
            // Creer une connexion a la base de données.
            Class.forName(Constants.JDBC_DRIVER);
            connection = DriverManager.getConnection(Constants.DATABASE_URL, Constants.DATABASE_USER, Constants.DATABASE_PASSWORD);
            // Initialiser l'objet ScripRunner
            ScriptRunner scriptRunner = new ScriptRunner(connection, false, false);
            // Ouvrir le fichier
            reader = new BufferedReader(
                    new FileReader(scriptSqlPath));
            // Executer le script Sql
            scriptRunner.runScript(reader);
        } catch (Exception e) {
            log.error("Erreur lors de l'execution du script : " + scriptSqlPath + " , Exception : " + e);
        } finally {
            try {
                if (reader != null) {
                    reader.close();
                }

            } catch (IOException io) {
                log.error("Erreur lors de la fermiture d'un fichier dans la methode, Exception : " + io.getMessage());
            }
            try {
                if (connection != null) {
                    connection.close();
                }
            } catch (SQLException sqlEx) {
                log.error("Erreur lors de la fermiture de la connexion dans la methode, Exception : " + sqlEx.getMessage());
            }
        }
        log.debug("Sortie de la methode");
    }

    public void verifyDataPersonnes(List<Personne> personnes) {
        log.debug("Entree de la methode");
        if (personnes != null) {
            log.debug("personnes.size(): " + personnes.size());
            for (Personne person : personnes) {
                verifyDataPersonne(person);
            }
        } else if (personnes == null || personnes.isEmpty()) {
            Assert.fail("Aucune personne n'a ete trouves dans votre liste");
        }
        log.debug("Sortie de la methode");
    }

    public void verifyDataPersonne(Personne person) {
        log.debug("Entree de la methode");
        if (person != null) {
            log.debug("idPersonne : " + person.getIdPersonne());
            Assert.assertNotNull(person.getIdPersonne());
            Assert.assertNotNull(person.getPrenom());
            Assert.assertNotNull(person.getNom());
            Assert.assertNotNull(person.getTaille());
            Assert.assertNotNull(person.getPoids());
            Assert.assertNotNull(person.getRue());
            Assert.assertNotNull(person.getCodePostal());
            Assert.assertNotNull(person.getVille());
            Assert.assertNotNull(person.getPays());
        } else if (person == null) {
            Assert.fail("Personne null");
        }
        log.debug("Sortie de la methode");
    }

    @Test
    public void testFindAllPersonnes() {
        log.debug("Entree de la methode");
        if (personnes != null) {
            log.debug("NB_PERSONNES_LIST: " + NB_PERSONNES_LIST + " , personnes.size(): " + personnes.size());
            Assert.assertEquals(NB_PERSONNES_LIST, personnes.size());
        }
        log.debug("Sortie de la methode");
    }

    @Test
    public void testCreateUpdateDeletePersonne() {
        log.debug("Entree de la methode");
        Personne personCRUD = new Personne("Edouard", "Green", 100.0, 170.0, "rue du paradis", "76000", "Rouen", "France");
        personCRUD = personneDao.create(personCRUD);
        log.debug("personCRUD: " + personCRUD);
        Assert.assertNotNull(personCRUD);
        Assert.assertNotNull(personCRUD.getIdPersonne());
        Assert.assertNotNull(personCRUD.getPrenom());
        Assert.assertNotNull(personCRUD.getNom());
        Assert.assertNotNull(personCRUD.getRue());
        Assert.assertNotNull(personCRUD.getVille());
        Assert.assertNotNull(personCRUD.getCodePostal());
        Assert.assertNotNull(personCRUD.getCodePostal());
        log.debug("Created personCRUD : " + personCRUD);
        personCRUD = personneDao.findById(personCRUD.getIdPersonne());
        Assert.assertNotNull(personCRUD);
        personCRUD.setPrenom("Edouard Bis");
        personCRUD.setNom("Green Bis");
        personCRUD = personneDao.update(personCRUD);
        Assert.assertNotNull(personCRUD);
        personCRUD = personneDao.findById(personCRUD.getIdPersonne());
        log.debug("Updated personCRUD : " + personCRUD);
        Assert.assertEquals("Edouard Bis", personCRUD.getPrenom());
        Assert.assertEquals("Green Bis", personCRUD.getNom());
        Assert.assertTrue(personneDao.delete(personCRUD));
        personCRUD = personneDao.findById(personCRUD.getIdPersonne());
        Assert.assertNull(personCRUD);
        List<Personne> personnesFinal = personneDao.findAll();
        if (personnesFinal != null) {
            Assert.assertEquals(NB_PERSONNES_LIST, personnesFinal.size());
            log.debug("personnesFinal.size() : " + personnesFinal.size() + " , NB_PERSONNES_LIST : " + NB_PERSONNES_LIST);
        } else if (personnesFinal == null || personnesFinal.isEmpty()) {
            Assert.fail("Aucune personne n'a ete trouve au final");
        }
        log.debug("Sortie de la methode");
    }

    @AfterClass
    public static void terminate() throws Exception {
        log.debug("Entree de la methode");
        personneDao = null;
        personnes = null;
        log.debug("Sortie de la methode");
    }
}
