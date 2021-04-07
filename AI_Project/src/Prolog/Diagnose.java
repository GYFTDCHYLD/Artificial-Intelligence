package Prolog;

import org.jpl7.*;


import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.LineBorder;

public class Diagnose extends JFrame implements ActionListener{
	/**
	 * 
	 */ 
	private JLabel displayMessage = new JLabel();// where you type your message
	
	private JTextField FirstName = new JTextField();// where you type your key
	private JLabel FirstNameLabel = new JLabel("FIRSTNAME"); 
	
	private JTextField LastName = new JTextField();// where you type your key 
	private JLabel LastNameLabel = new JLabel("LASTNAME"); 
	
	private String[] EthnicityChoices; 
	private JComboBox<String> EthnicityDropdown; 
	private JLabel EthnicityLabel = new JLabel("ETHNICITY"); 
	
	private JTextField AgeTextField = new JTextField();// where you type your key 
	private JLabel AgeNameLabel = new JLabel("AGE"); 
	
	private String[] GenderChoices;
	private JComboBox<String> GenderDropdown;
	private JLabel GenderLabel = new JLabel("GENDER"); 
	
	private String[] ParishChoices;
	private JComboBox<String> ParishDropdown;
	private JLabel ParishLabel = new JLabel("PARISH"); 
	
	private JTextField TextField3 = new JTextField();// where you type your key 
	
	private JTextField TemperatureTextField = new JTextField();// where you type your key 
	private JLabel TemperatureLabel = new JLabel("TEMPERATURE IN CELCIOUS");
	
	private String[] SymtomChoices;
	private JComboBox<String> SymtomsDropdown;
	private JLabel SymtomsLabel = new JLabel("SYMTOMS");
	
	private JTextField TextField4 = new JTextField();// where you type your key 
	private JTextField TextField5 = new JTextField();// where you type your key 
	
	
	
	private JButton Reset = new JButton("Reset");
	private JButton Main = new JButton("Main");
	private JButton Submit = new JButton("Submit"); 
	


	
	private JLabel Background = new JLabel();

	
	public Diagnose(String name){
		
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setVisible(true);
		setResizable(false);
		setLayout(null);
		setSize(800, 600); // width, height
		setTitle(name.toUpperCase());
		setLocationRelativeTo(null);
		

		
		displayMessage.setSize(300, 40); // width, height 
		displayMessage.setLocation(300, 390); // x, y
		displayMessage.setForeground(Color.RED);
		add(displayMessage);
		

		
		
		FirstName.setSize(200, 25); // width, height
		FirstName.setLocation(5, 10); // x, y
		FirstName.setBorder(new LineBorder(java.awt.Color.RED, 1));
		FirstName.setFont(new Font("arial", Font.BOLD, 15));
		add(FirstName);
		FirstNameLabel.setHorizontalAlignment(SwingConstants.CENTER); 
		FirstNameLabel.setBounds(110, 13, 300, 20);
		add(FirstNameLabel);
		FirstNameLabel.setForeground(Color.WHITE);
		FirstNameLabel.setFont(new Font("arial", Font.BOLD, 18));
		
		
		LastName.setSize(200, 25); // width, height
		LastName.setLocation(5, 50); // x, y
		LastName.setBorder(new LineBorder(java.awt.Color.RED, 1));
		LastName.setFont(new Font("arial", Font.BOLD, 15));
		add(LastName);
		LastNameLabel.setHorizontalAlignment(SwingConstants.CENTER); 
		LastNameLabel.setBounds(110, 53, 300, 20);
		add(LastNameLabel);
		LastNameLabel.setForeground(Color.WHITE);
		LastNameLabel.setFont(new Font("arial", Font.BOLD, 18));
		
		

		EthnicityChoices = new String[]{"","White", "Black", "Hispanic", "Aisian", "Caucasian"};
		EthnicityDropdown = new JComboBox<String>(EthnicityChoices);
		EthnicityDropdown.addActionListener(this);
		EthnicityDropdown.setFont(new Font("arial", Font.BOLD, 15));
		EthnicityDropdown.setVisible(true);
		EthnicityDropdown.setBounds(5, 88, 200, 25);
		add(EthnicityDropdown);
		EthnicityLabel.setHorizontalAlignment(SwingConstants.CENTER); 
		EthnicityLabel.setBounds(108, 90, 300, 20);
		add(EthnicityLabel);
		EthnicityLabel.setForeground(Color.WHITE);
		EthnicityLabel.setFont(new Font("arial", Font.BOLD, 18));
		EthnicityDropdown.setBorder(new LineBorder(java.awt.Color.RED, 1));
		
		
		AgeTextField.setSize(50, 25); // width, height
		AgeTextField.setLocation(5, 125); // x, y
		AgeTextField.setBorder(new LineBorder(java.awt.Color.RED, 1));
		AgeTextField.setFont(new Font("arial", Font.BOLD, 15));
		add(AgeTextField);
		AgeNameLabel.setBounds(60, 128, 300, 20);
		add(AgeNameLabel);
		AgeNameLabel.setForeground(Color.WHITE);
		AgeNameLabel.setFont(new Font("arial", Font.BOLD, 18));
		
		
		
		GenderChoices = new String[]{"","Male", "Female"};
		GenderDropdown = new JComboBox<String>(GenderChoices); 
		GenderDropdown.addActionListener(this);
		GenderDropdown.setFont(new Font("arial", Font.BOLD, 15));
		GenderDropdown.setVisible(true);
		GenderDropdown.setBounds(125, 125, 80, 25);
		add(GenderDropdown);
		GenderDropdown.setBorder(new LineBorder(java.awt.Color.RED, 1));
		GenderLabel.setBounds(210, 128, 300, 20);
		add(GenderLabel);
		GenderLabel.setForeground(Color.WHITE);
		GenderLabel.setFont(new Font("arial", Font.BOLD, 18));
		
		
		ParishChoices = new String[]{"","Kingston & St Andrew", "St Cathrine", "St Mary", "St Ann"};
		ParishDropdown = new JComboBox<String>(ParishChoices); 
		ParishDropdown.addActionListener(this);
		ParishDropdown.setFont(new Font("arial", Font.BOLD, 15));
		ParishDropdown.setVisible(true);
		ParishDropdown.setBounds(5, 160, 200, 25);
		add(ParishDropdown);
		ParishDropdown.setBorder(new LineBorder(java.awt.Color.RED, 1));
		ParishLabel.setBounds(210, 162, 300, 20);
		add(ParishLabel);
		ParishLabel.setForeground(Color.WHITE);
		ParishLabel.setFont(new Font("arial", Font.BOLD, 18));
		
		
		TextField3.setSize(50, 25); // width, height
		TextField3.setLocation(5, 195); // x, y
		TextField3.setBorder(new LineBorder(java.awt.Color.RED, 1));
		TextField3.setFont(new Font("arial", Font.BOLD, 15));
		add(TextField3);
		

		TemperatureTextField.setSize(50, 25); // width, height
		TemperatureTextField.setLocation(155, 195); // x, y
		TemperatureTextField.setBorder(new LineBorder(java.awt.Color.RED, 1));
		TemperatureTextField.setFont(new Font("arial", Font.BOLD, 15));
		add(TemperatureTextField);
		TemperatureLabel.setBounds(210, 195, 300, 20);
		add(TemperatureLabel);
		TemperatureLabel.setForeground(Color.WHITE);
		TemperatureLabel.setFont(new Font("arial", Font.BOLD, 18));
		
		
		SymtomChoices = new String[]{"","Dizziness", "Fainting", "Fever", "Blurred Vision"};
		SymtomsDropdown = new JComboBox<String>(SymtomChoices); 
		SymtomsDropdown.addActionListener(this);
		SymtomsDropdown.setFont(new Font("arial", Font.BOLD, 15));
		SymtomsDropdown.setVisible(true);
		SymtomsDropdown.setBounds(5, 230, 200, 25);
		add(SymtomsDropdown);
		SymtomsDropdown.setBorder(new LineBorder(java.awt.Color.RED, 1));
		SymtomsLabel.setBounds(210, 230, 300, 20);
		add(SymtomsLabel);
		SymtomsLabel.setForeground(Color.WHITE);
		SymtomsLabel.setFont(new Font("arial", Font.BOLD, 18));
		
		
		TextField4.setSize(200, 25); // width, height
		TextField4.setLocation(5, 265); // x, y
		TextField4.setBorder(new LineBorder(java.awt.Color.RED, 1));
		TextField4.setFont(new Font("arial", Font.BOLD, 15));
		add(TextField4);
		
		TextField5.setSize(200, 25); // width, height
		TextField5.setLocation(5, 300); // x, y
		TextField5.setBorder(new LineBorder(java.awt.Color.RED, 1));
		TextField5.setFont(new Font("arial", Font.BOLD, 15));
		add(TextField5);
		


		

		

		
		Reset.addActionListener(this);
		Reset.setBounds(390, 520, 100, 29);
		getContentPane().add(Reset);
		
		
		Main.addActionListener(this);  
		Main.setBounds(520, 520, 100, 29);
		getContentPane().add(Main);
		
		
		Submit.addActionListener(this);
		Submit.setBounds(650, 520, 100, 29);
		getContentPane().add(Submit); 
		
		Background.setHorizontalAlignment(SwingConstants.CENTER); 
		Background.setIcon(new ImageIcon("Images/blue-covid-banner.jpg"));
		Background.setBounds(0, 0,1000, 700);
		add(Background);
		
		
		Query q1 = new Query(
				"consult", new Term[] {new Atom("src/KnowledgeBase.pl")} 
		);
		System.out.println( "consult" + (q1.hasSolution() ? " succeeded" : " failed"));	
	}

	
	private void Query(String symtom){
		String string;
		
		try {
			string = "is_a_symtom("+ symtom.toLowerCase().replaceAll(" ", "") +")";
			Query query = new Query(string);
			
			string = "sign(X," + symtom.toLowerCase().replaceAll(" ", "") + ")";
			Query q = new Query(string);
			JOptionPane.showMessageDialog(null, symtom + " is a symtoms associated with " + q.oneSolution().get("X"), FirstName.getText() + " " + LastName.getText() , JOptionPane.INFORMATION_MESSAGE );
	
		}catch(NullPointerException e) {
			
		}
	}

	
	public void actionPerformed(ActionEvent e) {
		System.out.println(e.getActionCommand());
		switch (e.getActionCommand()) {
			case "Reset": 	this.dispose();
							new Diagnose("Covid-19 Management System");
				break;
			case "Main": 	this.dispose();
							new Main("Covid-19 Management System");
				break;
			case "Submit": Query(SymtomsDropdown.getSelectedItem().toString());
				break; 
			default:
				break;
		}
		
	}
}