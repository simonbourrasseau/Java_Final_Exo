/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.cours.gestion.personne;

import javax.swing.*;
import javax.swing.border.Border;
import javax.swing.border.CompoundBorder;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

//import com.cours.dao.IPersonneDao;

/**
 *
 * @author elhad
 */
public class FormCreateOrModifyPanel extends JPanel {

	/**
	 *
	 */
	private static final long serialVersionUID = 365957717501937299L;
	private MainFrame mainFrame = null;
	private JLabel labelPrenom = null;
	private JTextField textFieldPrenom = null;
	private JLabel labelNom = null;
	private JTextField textFieldNom = null;
	private JLabel labelPoids = null;
	private JTextField textFieldPoids = null;
	private JLabel labelRue = null;
	private JTextField textFieldRue = null;
	private JLabel labelVille = null;
	private JComboBox comboVille = null;
	private JLabel labelCodePostal = null;
	private JTextField textFieldCodePostal = null;
	private JLabel labelError = new JLabel();

	public FormCreateOrModifyPanel() {
	}

	public FormCreateOrModifyPanel(MainFrame mainFrame) {
		this.mainFrame = mainFrame;
		createFormConnexion();
	}

	public final void createFormConnexion() {
		this.setPreferredSize(new Dimension(500, 200));
		Border border = this.getBorder();
		Border margin = new EmptyBorder(5, 5, 5, 5);
		this.setBorder(new CompoundBorder(border, margin));

		// ------ Label Prenom
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

		// ------ Label Nom
		Box hBoxNom = Box.createHorizontalBox();
		labelNom = new JLabel("Nom : ");
		labelNom.setPreferredSize(new Dimension(75, 50));
		textFieldNom = new JTextField();
		textFieldNom.setPreferredSize(new Dimension(120, 35));
		hBoxNom.add(labelNom);
		hBoxNom.add(textFieldNom);
		hBoxNom.setPreferredSize(new Dimension(250, 40));
		hBoxNom.setBorder(new CompoundBorder(hBoxNom.getBorder(), new EmptyBorder(5, 0, 5, 0)));

		// ------ Label Poids
		Box hBoxPoids = Box.createHorizontalBox();
		labelPoids = new JLabel("Poids : ");
		labelPoids.setPreferredSize(new Dimension(75, 50));
		textFieldPoids = new JTextField();
		textFieldPoids.setPreferredSize(new Dimension(120, 35));
		hBoxPoids.add(labelPoids);
		hBoxPoids.add(textFieldPoids);
		hBoxPoids.setPreferredSize(new Dimension(250, 40));
		hBoxPoids.setBorder(new CompoundBorder(hBoxPoids.getBorder(), new EmptyBorder(5, 0, 5, 0)));

		// ------ Label Rue
		Box hBoxRue = Box.createHorizontalBox();
		labelRue = new JLabel("Rue : ");
		labelRue.setPreferredSize(new Dimension(75, 50));
		textFieldRue = new JTextField();
		textFieldRue.setPreferredSize(new Dimension(120, 35));
		hBoxRue.add(labelRue);
		hBoxRue.add(textFieldRue);
		hBoxRue.setPreferredSize(new Dimension(250, 40));
		hBoxRue.setBorder(new CompoundBorder(hBoxRue.getBorder(), new EmptyBorder(5, 0, 5, 0)));

		// ------ Combo Ville
		Box hBoxVille = Box.createHorizontalBox();
		labelVille = new JLabel("Ville : ");
		labelVille.setPreferredSize(new Dimension(75, 50));
		comboVille = new JComboBox();
		comboVille.setPreferredSize(new Dimension(120, 35));
		hBoxVille.add(labelVille);
		hBoxVille.add(comboVille);
		hBoxVille.setPreferredSize(new Dimension(250, 40));
		hBoxVille.setBorder(new CompoundBorder(hBoxVille.getBorder(), new EmptyBorder(5, 0, 5, 0)));

		// ------ Label Code Postal
		Box hBoxCodePostal = Box.createHorizontalBox();
		labelCodePostal = new JLabel("Code Postal : ");
		labelCodePostal.setPreferredSize(new Dimension(75, 50));
		textFieldCodePostal = new JTextField();
		textFieldCodePostal.setPreferredSize(new Dimension(120, 35));
		hBoxCodePostal.add(labelCodePostal);
		hBoxCodePostal.add(textFieldCodePostal);
		hBoxCodePostal.setPreferredSize(new Dimension(250, 40));
		hBoxCodePostal.setBorder(new CompoundBorder(hBoxCodePostal.getBorder(), new EmptyBorder(5, 0, 5, 0)));

		// ------ Button Valider
		JButton buttonValider = new JButton("Valider");
		buttonValider.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				System.out.println("*********************** Clic sur buttonValider ***************************");
				//IPersonneDao personneDao = getMainFrame().getPersonneDao();
				//System.out.println("Personnes : " + personneDao.findAll());
				labelError.setText("Erreur : Votre Prenom ou votre Nom est incorrecte");
			}
		});

		Box hBoxButton = Box.createHorizontalBox();
		hBoxButton.add(buttonValider);
		hBoxButton.setBorder(new CompoundBorder(hBoxButton.getBorder(), new EmptyBorder(5, 75, 5, 0)));


		// ------ Button Annuler
		JButton buttonCancel = new JButton("Annuler");
		buttonCancel.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				System.out.println("*********************** Clic sur buttonAnnuler ***************************");
				//IPersonneDao personneDao = getMainFrame().getPersonneDao();
				//System.out.println("Personnes : " + personneDao.findAll());
				//labelError.setText("Erreur : Votre Prenom ou votre Nom est incorrecte");
			}
		});

		Box hBoxCancel = Box.createHorizontalBox();
		hBoxCancel.add(buttonCancel);
		hBoxCancel.setBorder(new CompoundBorder(hBoxButton.getBorder(), new EmptyBorder(5, 75, 5, 0)));

		Box vBoxPanel = Box.createVerticalBox();

		Box hBoxError = Box.createHorizontalBox();
		hBoxError.setPreferredSize(new Dimension(250, 40));
		hBoxError.setBorder(new CompoundBorder(hBoxError.getBorder(), new EmptyBorder(5, 0, 5, 0)));
		hBoxError.add(labelError);

		vBoxPanel.add(hBoxError);
		vBoxPanel.add(hBoxPrenom);
		vBoxPanel.add(hBoxNom);
		vBoxPanel.add(hBoxPoids);
		vBoxPanel.add(hBoxRue);
		vBoxPanel.add(hBoxVille);
		vBoxPanel.add(hBoxCodePostal);
		vBoxPanel.add(hBoxButton);
		vBoxPanel.add(hBoxCancel);
		this.add(vBoxPanel);
	}

	public MainFrame getMainFrame() {
		return mainFrame;
	}
}