package com.cours.dao.src.main.java.com.cours.dao.factory;

import com.cours.dao.src.main.java.com.cours.dao.IPersonneDao;
import com.cours.dao.impl.sql.SqlPersonneDaoImpl;

public class SqlDaoFactory extends AbstractDaoFactory {

    private IPersonneDao personneDao = null;

    public SqlDaoFactory() {
        this.personneDao = new SqlPersonneDaoImpl();
    }

    @Override
    public IPersonneDao getPersonneDao() {
        return personneDao;
    }
}
