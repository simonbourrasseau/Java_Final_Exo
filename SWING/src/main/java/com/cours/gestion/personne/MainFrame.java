/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.cours.gestion.personne;

import javax.swing.JFrame;

import com.cours.dao.src.main.java.com.cours.dao.IPersonneDao;
import com.cours.dao.src.main.java.com.cours.dao.factory.AbstractDaoFactory;

/**
 *
 * @author elhad
 */
public class MainFrame extends JFrame {

	/**
	 *
	 */
	private static final long serialVersionUID = -558099545401707240L;
	private IPersonneDao personneDao = null;

	public MainFrame() {
		super();
		personneDao = AbstractDaoFactory.getDaoFactory(AbstractDaoFactory.FactoryType.SQL_DAO).getPersonneDao();
		this.setTitle("Application Gestion Personnes");
		this.setSize(1000, 700);
		this.setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		FormConnexionPanel formConnexionPanel = new FormConnexionPanel(this);
		this.getContentPane().add(formConnexionPanel);

		/*TablePersonnesPanel tablePersonnesPanel = new TablePersonnesPanel(this);
		this.getContentPane().add(tablePersonnesPanel);*/

		//FormCreateOrModifyPanel formCreateOrModifyPanel = new FormCreateOrModifyPanel(this);
		//this.getContentPane().add(formCreateOrModifyPanel);
	}

	public IPersonneDao getPersonneDao() {
		return personneDao;
	}
}