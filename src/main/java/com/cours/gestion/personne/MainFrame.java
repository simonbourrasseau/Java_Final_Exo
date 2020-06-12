/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.cours.gestion.personne;

import javax.swing.JFrame;

/**
 *
 * @author elhad
 */
public class MainFrame extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = -558099545401707240L;

	public MainFrame() {
		super();
		this.setTitle("Appli Gestion Personnes");
		this.setSize(1000,700);
		this.setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		FormConnexionPanel formConnexionPanel = new FormConnexionPanel(this);
		this.getContentPane().add(formConnexionPanel);
	}
}
