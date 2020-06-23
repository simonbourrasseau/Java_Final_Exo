/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.cours.gestion.personne;

import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.Box;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.border.Border;
import javax.swing.border.CompoundBorder;
import javax.swing.border.EmptyBorder;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 *
 * @author elhad
 */
public class TablePersonnesPanel extends JPanel {

	/**
	 * 
	 */

	private static final long serialVersionUID = 7134034596195947654L;
	private MainFrame mainFrame = null;
	private JTable tablePersonnes = null;


	public TablePersonnesPanel() {
		super();
	}

	public TablePersonnesPanel(MainFrame mainFrame) {
		this.mainFrame = mainFrame;
		createTablePersonnesPanel();
	}

	public final void createTablePersonnesPanel() {

		List<Personne> arrayPersonne = new ArrayList<Personne>(Arrays.asList(
				new Personne(15, "Serge", "Lama", 102.0, 195.0, "rue des Heureux", "Nantes", "44000", "France"),
				new Personne(16, "Vincent", "Thomas", 81.0, 183.0, "rue de Paris", "Rennes", "35000", "France"),
				new Personne(17, "Eric", "Dummat", 61.0, 155.0, "rue de Versaille", "Paris", "75000", "France"),
				new Personne(18, "Nicolas", "Samuel", 64.0, 145.0, "rue de Saint Louis", "Laval", "53000", "France"),
				new Personne(19, "Rémy", "Guerry", 79.0, 191.0, "rue des Sages", "Lyon", "69000", "France"),
				new Personne(20, "Nicolas", "Drapeau", 56.0, 166.0, "rue Mitterrand", "Limoges", "87000", "France"),
				new Personne(21, "Gaelle", "Letourneau", 96.0, 195.0, "rue Jean François", "Rouen", "76000", "France"),
				new Personne(22, "Jacques", "Dupont", 85.0, 179.0, "rue des Anges", "Paris", "75000", "France")));


		Object[][] data = new Object[arrayPersonne.size()][];
		int i=0;

		// ------ Table Personne
		for(Personne p: arrayPersonne){

			data[i] = new Object[]{p.getNom(), p.getPrenom(), p.getCodePostal()};
			i++;


		}
		String  title[] = {"Pseudo", "Age", "Taille"};
		this.tablePersonnes = new JTable(data, title);



		// ------ Button Disconnect
		JButton buttonDisconnect = new JButton("Déconnexion");
		buttonDisconnect.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				System.out.println("*********************** Clic sur buttonDeconnect ***************************");
				getMainFrame().setContentPane(new FormConnexionPanel(mainFrame));
                getMainFrame().setVisible(true);
			}
		});
		Box hBoxButtonDisconnect = Box.createHorizontalBox();
		hBoxButtonDisconnect.add(buttonDisconnect);
		hBoxButtonDisconnect.setBorder(new CompoundBorder(hBoxButtonDisconnect.getBorder(), new EmptyBorder(0, 0, 0, 270)));

		// ------ Button Export XML
		JButton buttonExportXML = new JButton("Export XML");
		buttonExportXML.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				System.out.println("*********************** Clic sur Export XLM ***************************");
			}
		});
		Box hBoxButtonExportXML = Box.createHorizontalBox();
		hBoxButtonExportXML.add(buttonExportXML);
		hBoxButtonExportXML.setBorder(new CompoundBorder(hBoxButtonExportXML.getBorder(), new EmptyBorder(0, 170, 0, 0)));

		// ------ Button Export CSV
		JButton buttonExportCSV = new JButton("Export CSV");
		buttonExportCSV.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				System.out.println("*********************** Clic sur Export CSV ***************************");
			}
		});
		Box hBoxButtonExportCSV = Box.createHorizontalBox();
		hBoxButtonExportCSV.add(buttonExportCSV);
		hBoxButtonExportCSV.setBorder(new CompoundBorder(hBoxButtonExportCSV.getBorder(), new EmptyBorder(0, 0, 0, 0)));

		// ------ Button Export JSON
		JButton buttonExportJSON = new JButton("Export CSV");
		buttonExportJSON.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				System.out.println("*********************** Clic sur Export JSON ***************************");
			}
		});
		Box hBoxButtonExportJSON = Box.createHorizontalBox();
		hBoxButtonExportJSON.add(buttonExportJSON);
		hBoxButtonExportJSON.setBorder(new CompoundBorder(hBoxButtonExportJSON.getBorder(), new EmptyBorder(0, 0, 0, 0)));

		// ------ Button Import XML
		JButton buttonImportXML = new JButton("Import XML");
		buttonImportXML.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				System.out.println("*********************** Clic sur buttonImportXML ***************************");
			}
		});
		Box hBoxbuttonImportXML = Box.createHorizontalBox();
		hBoxbuttonImportXML.add(buttonImportXML);
		hBoxbuttonImportXML.setBorder(new CompoundBorder(hBoxbuttonImportXML.getBorder(), new EmptyBorder(0, 0, 0, 300)));

		// ------ Button Add
		JButton buttonAdd = new JButton("Ajouter");
		buttonAdd.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				System.out.println("*********************** Clic sur Ajouter ***************************");

			}
		});
		Box hBoxButtonAdd = Box.createHorizontalBox();
		hBoxButtonAdd.add(buttonAdd);
		hBoxButtonAdd.setBorder(new CompoundBorder(hBoxButtonAdd.getBorder(), new EmptyBorder(0, 200, 0, 0)));

		// ------ Button Modify
		JButton buttonModify = new JButton("Modifier");
		buttonModify.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				System.out.println("*********************** Clic sur Modifier ***************************");
			}
		});
		Box hBoxButtonModify = Box.createHorizontalBox();
		hBoxButtonModify.add(buttonModify);
		hBoxButtonModify.setBorder(new CompoundBorder(hBoxButtonModify.getBorder(), new EmptyBorder(0, 0, 0, 0)));

		// ------ Button Delete
		JButton buttonDelete = new JButton("Supprimer");
		buttonDelete.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				System.out.println("*********************** Clic sur Delete ***************************");
			}
		});
		Box hBoxButtonDelete = Box.createHorizontalBox();
		hBoxButtonDelete.add(buttonDelete);
		hBoxButtonDelete.setBorder(new CompoundBorder(hBoxButtonDelete.getBorder(), new EmptyBorder(0, 0, 0, 0)));

		Box hBoxPanelUp = Box.createHorizontalBox();
		Box hBoxPanelMiddle = Box.createHorizontalBox();
		Box hBoxPanelDown = Box.createHorizontalBox();

		hBoxPanelUp.add(hBoxButtonDisconnect);
		hBoxPanelUp.add(hBoxButtonExportXML);
		hBoxPanelUp.add(hBoxButtonExportCSV);
		hBoxPanelUp.add(hBoxButtonExportJSON);
		hBoxPanelDown.add(hBoxbuttonImportXML);
		hBoxPanelMiddle.add(tablePersonnes);
		hBoxPanelDown.add(hBoxButtonAdd);
		hBoxPanelDown.add(hBoxButtonModify);
		hBoxPanelDown.add(hBoxButtonDelete);

		this.add(hBoxPanelUp);
		this.add(hBoxPanelMiddle);
		this.add(hBoxPanelDown);

	}

	public MainFrame getMainFrame() {
		return mainFrame;
	}
}
