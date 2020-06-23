package com.cours.dao;

import com.cours.entities.Personne;

import java.util.List;

public interface IPersonneDao {

    public List<Personne> findAll();

    public Personne findById(Integer id);

    public Integer generateIdPersonne();

    public Personne create(Personne p);

    public Personne update(Personne p);

    public Boolean delete(Personne p);

    public Personne authenticate(String prenom, String nom);
}
