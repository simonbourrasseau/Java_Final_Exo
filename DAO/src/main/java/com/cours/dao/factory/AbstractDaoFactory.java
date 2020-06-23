package com.cours.dao.factory;

import com.cours.dao.IPersonneDao;

public abstract class AbstractDaoFactory {

	public abstract IPersonneDao getPersonneDao();

	public enum FactoryType {

		CSV_DAO, XML_DAO, JSON_DAO, SQL_DAO
	}

	public static AbstractDaoFactory getDaoFactory(FactoryType type) {
		AbstractDaoFactory abstractDao = null;
		switch (type) {
		case SQL_DAO:
			abstractDao = new SqlDaoFactory();
		}
		return abstractDao;
	}
}
