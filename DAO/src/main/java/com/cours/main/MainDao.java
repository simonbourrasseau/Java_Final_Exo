package com.cours.main;

import com.cours.dao.IPersonneDao;
import com.cours.dao.factory.AbstractDaoFactory;
import com.cours.dao.impl.sql.SqlPersonneDaoImpl;
import com.cours.entities.Personne;
import java.util.List;

public class MainDao {

    public static void main(String[] args) {
        IPersonneDao personneDao = null;
        List<Personne> personnes = null;
        personneDao = new SqlPersonneDaoImpl();
        //personnes = personneDao.findAll();
        //System.out.println("1------ personnes : " + personnes);
        
        
        //System.out.println("hello");
       // personneDao = AbstractDaoFactory.getDaoFactory(AbstractDaoFactory.FactoryType.SQL_DAO).getPersonneDao();
       // personnes = personneDao.findAll();
       // System.out.println("2------ personnes : " + personnes);
    }
}
