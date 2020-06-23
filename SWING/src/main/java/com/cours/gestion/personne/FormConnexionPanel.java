/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.cours.gestion.personne;

import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.Box;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.Border;
import javax.swing.border.CompoundBorder;
import javax.swing.border.EmptyBorder;

import com.cours.dao.IPersonneDao;
import com.cours.dao.impl.sql.SqlPersonneDaoImpl;
import com.cours.entities.Personne;


/**
 *
 * @author elhad
 */
public class FormConnexionPanel extends JPanel {

	/**
	 *
	 */
	private static final long serialVersionUID = 365957717501937299L;
	private MainFrame mainFrame = null;
	private JLabel labelPrenom = null;
	private JTextField textFieldPrenom = null;
	private JLabel labelNom = null;
	private JTextField textFieldNom = null;
	private JLabel labelError = new JLabel();

	public FormConnexionPanel() {
	}

	public FormConnexionPanel(MainFrame mainFrame) {
		this.mainFrame = mainFrame;
		createFormConnexion();
	}

	public final void createFormConnexion() {
		this.setPreferredSize(new Dimension(500, 200));
		Border border = this.getBorder();
		Border margin = new EmptyBorder(5, 5, 5, 5);
		this.setBorder(new CompoundBorder(border, margin));

		Box hBoxPrenom = Box.createHorizontalBox();
		labelPrenom = new JLabel("Prenom : ");
		labelPrenom.setPreferredSize(new Dimension(75, 55));
		textFieldPrenom = new JTextField();
		textFieldPrenom.setPreferredSize(new Dimension(120, 35));
		hBoxPrenom.add(labelPrenom);
		hBoxPrenom.add(textFieldPrenom);
		// Les border top, left, bottom, right
		hBoxPrenom.setBorder(new CompoundBorder(hBoxPrenom.getBorder(), new EmptyBorder(5, 0, 5, 0)));
		hBoxPrenom.setPreferredSize(new Dimension(250, 40));
		Box hBoxNom = Box.createHorizontalBox();
		labelNom = new JLabel("Nom : ");
		labelNom.setPreferredSize(new Dimension(75, 50));
		textFieldNom = new JTextField();
		textFieldNom.setPreferredSize(new Dimension(120, 35));
		hBoxNom.add(labelNom);
		hBoxNom.add(textFieldNom);
		hBoxNom.setPreferredSize(new Dimension(250, 40));
		hBoxNom.setBorder(new CompoundBorder(hBoxNom.getBorder(), new EmptyBorder(5, 0, 5, 0)));

		JButton buttonValider = new JButton("Valider");
		buttonValider.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				System.out.println("*********************** Clic sur buttonValider ***************************");
				IPersonneDao personneDao = getMainFrame().getPersonneDao();
				System.out.println("Personnes : " + personneDao.findAll());
				labelError.setText("Erreur : Votre Prenom ou votre Nom est incorrecte");
				
                Personne personneAuthenticate = personneDao.authenticate(textFieldPrenom.getText(), textFieldNom.getText());
                if(personneAuthenticate != null) {
	                getMainFrame().setContentPane(new TablePersonnesPanel(mainFrame));
	                getMainFrame().setVisible(true);
                }
			}
		});

		Box hBoxButton = Box.createHorizontalBox();
		hBoxButton.add(buttonValider);
		hBoxButton.setBorder(new CompoundBorder(hBoxButton.getBorder(), new EmptyBorder(5, 75, 5, 0)));
		Box vBoxPanel = Box.createVerticalBox();

		Box hBoxError = Box.createHorizontalBox();
		hBoxError.setPreferredSize(new Dimension(250, 40));
		hBoxError.setBorder(new CompoundBorder(hBoxError.getBorder(), new EmptyBorder(5, 0, 5, 0)));
		hBoxError.add(labelError);

		vBoxPanel.add(hBoxError);
		vBoxPanel.add(hBoxPrenom);
		vBoxPanel.add(hBoxNom);
		vBoxPanel.add(hBoxButton);
		this.add(vBoxPanel);
	}

	public MainFrame getMainFrame() {
		return mainFrame;
	}
}