package com.cours.entities;

import com.cours.utils.Constants;
import java.io.Serializable;
import java.util.Objects;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author ElHadji
 */
public class Personne implements Serializable, Comparable<Personne> {

    private Integer idPersonne;
    private String prenom;
    private String nom;
    private Double poids;
    private Double taille;
    private String rue;
    private String ville;
    private String codePostal;
    private String pays;

    public Personne() {

    }

    public Personne(String prenom, String nom, Double poids, Double taille, String rue, String codePostal, String ville, String pays) {
        this.prenom = prenom;
        this.nom = nom;
        this.poids = poids;
        this.taille = taille;
        this.rue = rue;
        this.codePostal = codePostal;
        this.ville = ville;
        this.pays = pays;
    }

    public Personne(Integer idPersonne, String prenom, String nom, Double poids, Double taille, String rue, String codePostal, String ville, String pays) {
        this.idPersonne = idPersonne;
        this.prenom = prenom;
        this.nom = nom;
        this.poids = poids;
        this.taille = taille;
        this.rue = rue;
        this.codePostal = codePostal;
        this.ville = ville;
        this.pays = pays;
    }

    public Integer getIdPersonne() {
        return idPersonne;
    }

    public void setIdPersonne(Integer idPersonne) {
        this.idPersonne = idPersonne;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public Double getPoids() {
        return poids;
    }

    public void setPoids(Double poids) {
        this.poids = poids;
    }

    public Double getTaille() {
        return taille;
    }

    public void setTaille(Double taille) {
        this.taille = taille;
    }

    public String getPrenom() {
        return prenom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    public String getRue() {
        return rue;
    }

    public void setRue(String rue) {
        this.rue = rue;
    }

    public String getVille() {
        return ville;
    }

    public void setVille(String ville) {
        this.ville = ville;
    }

    public String getCodePostal() {
        return codePostal;
    }

    public void setCodePostal(String codePostal) {
        this.codePostal = codePostal;
    }

    public String getPays() {
        return pays;
    }

    public void setPays(String pays) {
        this.pays = pays;
    }

    @Override
    public String toString() {
        return String.format("[idPersonne=%s, prenom=%s, nom=%s, poids=%s, taille=%s, rue=%s, ville=%s, codePostal=%s]", idPersonne, prenom, nom, poids, taille, rue, ville, codePostal);
    }

    @Override
    public int hashCode() {
        return this.getPrenom().hashCode() + this.getNom().hashCode();
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || !(obj instanceof Personne)) {
            return false;
        }
        Personne personneParam = (Personne) obj;
        return (personneParam.getPrenom().equals(getPrenom()) && personneParam.getNom().equals(getNom()));
    }

    @Override
    public int compareTo(Personne otherPersonne) {
        return this.getPrenom().compareTo(otherPersonne.getPrenom());
    }

    public double getImc() {
        double imc = 0;
        if (taille != 0) {
            imc = poids / Math.pow(taille / 100, 2);
        }
        return imc;
    }

    public String toFormatText() {
        return this.getIdPersonne() + Constants.CSV_SEPARATOR + " " + this.getPrenom() + Constants.CSV_SEPARATOR + " " + this.getNom() + Constants.CSV_SEPARATOR + " " + this.getPoids() + Constants.CSV_SEPARATOR + " " + this.getTaille() + Constants.CSV_SEPARATOR + " " + this.getRue() + Constants.CSV_SEPARATOR + " " + this.getVille() + Constants.CSV_SEPARATOR + " " + this.getCodePostal();
    }

    public boolean isMaigre() {
        double imc = getImc();
        return imc > Constants.LIMITE_INF_MAIGRE && imc < Constants.LIMITE_SUP_MAIGRE;
    }

    public boolean isSurPoids() {
        double imc = getImc();
        return imc > Constants.LIMITE_INF_SURPOIDS && imc < Constants.LIMITE_SUP_SURPOIDS;
    }

    public boolean isObese() {
        double imc = getImc();
        return imc > Constants.LIMITE_SUP_SURPOIDS;
    }
}
