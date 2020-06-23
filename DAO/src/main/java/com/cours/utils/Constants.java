/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.cours.utils;

/**
 *
 * @author ElHadji
 */
public class Constants {

	public static String PERSONNES_CSV_PATH_FILE = "personnesCsv.csv";
	public static String PERSONNES_XML_PATH_FILE = "personnesXml.xml";
	public static String PERSONNES_JSON_PATH_FILE = "personnesJson.json";
	public static String CSV_SEPARATOR = ";";
	public static String CSV_HEADER = "idPersonne;Prenom;Nom;Poids;Taille;Rue;Ville;Code Postal;Pays";
	// Url de connexion en base de donnée
	public static String DATABASE_URL = "jdbc:mysql://localhost:3306/base_personnes?useSSL=false";

	// Utilisateur de la base de données
	public static String DATABASE_USER = "application";
	// Mot de passe de la base de données
	public static String DATABASE_PASSWORD = "passw0rd";

	// Drivers Jdbc
	public static String JDBC_DRIVER = "com.mysql.jdbc.Driver";

	// Junit
	public static String SQL_JUNIT_PATH_FILE = "script_test_junit_base_personnes.sql";
	// Constante IMC
	public static double LIMITE_INF_MAIGRE = 16.5;
	public static double LIMITE_SUP_MAIGRE = 18.5;

	public static double LIMITE_INF_SURPOIDS = 25;
	public static double LIMITE_SUP_SURPOIDS = 30;
}
