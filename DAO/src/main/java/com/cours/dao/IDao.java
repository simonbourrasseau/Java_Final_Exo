/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.cours.dao;

import java.util.List;

/**
 *
 * @author ElHadji
 */
public interface IDao<T> {

    public List<T> findAll();

    public T findById(Integer id);

    public List<T> findByCriteria(String criteria, Object valueCriteria);

    public Integer generateId();

    public T create(T t);

    public T update(T t);

    public Boolean delete(T t);
}
