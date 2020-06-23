/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.cours.dao.impl.sql;

import com.cours.dao.IDao;
import java.util.List;

/**
 *
 * @author ElHadji
 * @param <T>
 */
public abstract class AbstractSqlDao<T> implements IDao<T> {

    private Class<T> myClass = null;

    public AbstractSqlDao(Class<T> myClass) {
        this.myClass = myClass;
    }

    @Override
    public List<T> findAll() {
        return null;
    }

    @Override
    public T findById(Integer id) {
        return null;
    }

    @Override
    public List<T> findByCriteria(String criteria, Object valueCriteria) {
        return null;
    }

    @Override
    public T create(T t) {
        return null;
    }

    @Override
    public T update(T t) {
        return null;
    }

    @Override
    public Boolean delete(T t) {
        return false;
    }

    @Override
    public Integer generateId() {
        return null;
    }
}
