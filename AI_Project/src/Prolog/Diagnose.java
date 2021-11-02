package Prolog;

import org.jpl7.*;


import java.awt.Color;
import java.awt.Font;
import java.awt.event.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.LineBorder;

public class Diagnose extends JFrame implements ActionListener, KeyListener{
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
 
	private JTextField Age = new JTextField();// where you type your key 
	private JLabel AgeNameLabel = new JLabel("AGE"); 

	private String[] GenderChoices;
	private JComboBox<String> GenderDropdown;
	private JLabel GenderLabel = new JLabel("GENDER"); 

	private String[] ParishChoices;
	private JComboBox<String> ParishDropdown;
	private JLabel ParishLabel = new JLabel("PARISH"); 

	private JTextField Temperature_F = new JTextField();// where you type your key
	private JLabel Temperature_FLabel = new JLabel("F");

	private JTextField Temperature_C = new JTextField();// where you type your key b
	private JLabel Temperature_CLabel = new JLabel("TEMPERATURE IN CELCIOUS");
	
	private String[] SymtomChoices;
	private JComboBox<String> SymptomDropdown;
	private JLabel SymtomsLabel = new JLabel("SYMTOMS");
	
	private JTextField Sytolic = new JTextField();// where you type your key 
	private JLabel SytolicLabel = new JLabel("SYSTOLIC");
	
	private JTextField Diastolic = new JTextField();// where you type your key   
	private JLabel DiastolicLabel = new JLabel("DIASTOSLIC"); 
	
	private JTextField TextField6 = new JTextField();// where you type your key 
	
	private JTextArea displaySelectedSymtoms = new JTextArea();
	private List<String> symtomList = new ArrayList<String>();

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



		EthnicityChoices = new String[]{""};
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


		Age.setSize(50, 25); // width, height
		Age.setLocation(5, 125); // x, y
		Age.setBorder(new LineBorder(java.awt.Color.RED, 1));
		Age.setFont(new Font("arial", Font.BOLD, 15));
		add(Age);
		AgeNameLabel.setBounds(60, 128, 300, 20);
		add(AgeNameLabel);
		AgeNameLabel.setForeground(Color.WHITE);
		AgeNameLabel.setFont(new Font("arial", Font.BOLD, 18));



		GenderChoices = new String[]{""};
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


		ParishChoices = new String[]{""};
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


		Temperature_F.setSize(50, 25); // width, height
		Temperature_F.setLocation(5, 195); // x, y
		Temperature_F.setBorder(new LineBorder(java.awt.Color.GREEN, 1));
		Temperature_F.setFont(new Font("arial", Font.BOLD, 15));
		add(Temperature_F);
		Temperature_F.disable();
		JLabel degreeSign = new JLabel("o");
		degreeSign.setBounds(57, 190, 300, 20);
		add(degreeSign);
		degreeSign.setForeground(Color.WHITE);
		degreeSign.setFont(new Font("arial", Font.BOLD, 12));
		
		Temperature_FLabel.setBounds(65, 195, 300, 20);
		add(Temperature_FLabel);
		Temperature_FLabel.setForeground(Color.WHITE);
		Temperature_FLabel.setFont(new Font("arial", Font.BOLD, 18));


		Temperature_C.setSize(50, 25); // width, height
		Temperature_C.setLocation(155, 195); // x, y
		Temperature_C.setBorder(new LineBorder(java.awt.Color.RED, 1));
		Temperature_C.setFont(new Font("arial", Font.BOLD, 15));
		add(Temperature_C);
		Temperature_CLabel.setBounds(210, 195, 300, 20);
		add(Temperature_CLabel);
		Temperature_CLabel.setForeground(Color.WHITE);
		Temperature_CLabel.setFont(new Font("arial", Font.BOLD, 18));
		Temperature_C.addKeyListener(this);
		
		SymtomChoices = new String[]{""};
		SymptomDropdown = new JComboBox<String>(SymtomChoices); 
		SymptomDropdown.addActionListener(this);
		SymptomDropdown.setFont(new Font("arial", Font.BOLD, 15));
		SymptomDropdown.setVisible(true);
		SymptomDropdown.setBounds(5,230, 200, 25);
		add(SymptomDropdown);
		SymptomDropdown.setBorder(new LineBorder(java.awt.Color.RED, 1));
		SymtomsLabel.setBounds(210,230, 300, 20);
		add(SymtomsLabel);
		SymtomsLabel.setForeground(Color.WHITE);
		SymtomsLabel.setFont(new Font("arial", Font.BOLD, 18));
		
		Sytolic.setSize(50, 25); // width, height
		Sytolic.setLocation(155, 265); // x, 
		Sytolic.setBorder(new LineBorder(java.awt.Color.RED, 1));
		Sytolic.setFont(new Font("arial", Font.BOLD, 15));
		add(Sytolic);
		SytolicLabel.setBounds(210, 265, 300, 20);
		add(SytolicLabel);
		SytolicLabel.setForeground(Color.WHITE);
		SytolicLabel.setFont(new Font("arial", Font.BOLD, 18));

		Diastolic.setSize(50, 25); // width, height  
		Diastolic.setLocation(155, 300); // x, y
		Diastolic.setBorder(new LineBorder(java.awt.Color.RED, 1));
		Diastolic.setFont(new Font("arial", Font.BOLD, 15));
		add(Diastolic);
		DiastolicLabel.setBounds(210, 300, 300, 20);
		add(DiastolicLabel);
		DiastolicLabel.setForeground(Color.WHITE);
		DiastolicLabel.setFont(new Font("arial", Font.BOLD, 18));
/*
		TextField6.setSize(200, 25); // width, height
		TextField6.setLocation(5, 335); // x, y
		TextField6.setBorder(new LineBorder(java.awt.Color.RED, 1));
		TextField6.setFont(new Font("arial", Font.BOLD, 15));
		add(TextField6);
*/

        displaySelectedSymtoms.setSize(200, 180); // width, height
        displaySelectedSymtoms.setLocation(5, 370); // x, y
        displaySelectedSymtoms.setBorder(new LineBorder(java.awt.Color.RED, 1));
        displaySelectedSymtoms.setFont(new Font("arial", Font.BOLD, 15));
		add(displaySelectedSymtoms);
		displaySelectedSymtoms.disable();





		Reset.addActionListener(this);
		Reset.setBounds(390, 520, 100, 29);
		add(Reset);


		Main.addActionListener(this);  
		Main.setBounds(520, 520, 100, 29);
		add(Main);


		Submit.addActionListener(this);
		Submit.setBounds(650, 520, 100, 29);
		add(Submit); 

		Background.setHorizontalAlignment(SwingConstants.CENTER); 
		Background.setIcon(new ImageIcon("Images/blue-covid-banner.jpg"));
		Background.setBounds(0, 0,1000, 700);
		add(Background);


		Query q1 = new Query(
				"consult", new Term[] {new Atom("src/KnowledgeBase.pl")} 
				);
		System.out.println( "consult" + (q1.hasSolution() ? " succeeded" : " failed"));	
		Symptoms();//get symptoms form knowledgebase for dropdown
		Parish();
		Ethnicity();
		Gender();
		SystolicDiastolicVisibility(false);
	}


	private void DiagnsePatient(){ 
		if(!AllEntryChecked())
			return;
		for(String symtom: symtomList) {
			SymptomDropdown.addItem(symtom);
		}
		displaySelectedSymtoms.setText("");
		symtomList.clear();
		try {
			
			BloodPressureCheck();
			SystolicDiastolicVisibility(false);
			//JOptionPane.showMessageDialog(null, symtom + " is a symtoms associated with " + q.oneSolution().get("X"), FirstName.getText() + " " + LastName.getText() , JOptionPane.INFORMATION_MESSAGE );

		}catch(NullPointerException e) {

		}
		ClearFields();
		AllEntryChecked();
	}

	

	private void Symptoms() { 
		Query result = new Query("symptom(S)"); 

		Map<String, Term>[] solution =  result.allSolutions();

		for( Map<String, Term> term: solution) {
			SymptomDropdown.addItem(
					term.values()
					.toString()
					.replace("[", "")
					.replace("]", "")
					.replace("_", " ")
			);
		}
		
		AssociatedVarient("fainting");
	}
	
	private void Parish(){
		Query result = new Query("parish(P)"); 

		Map<String, Term>[] solution =  result.allSolutions();

		for( Map<String, Term> term: solution) {
			ParishDropdown.addItem(
					term.values()
					.toString()
					.replace("[", "")
					.replace("]", "")
					.replace("_", " ")
					.replace("'", "")
			);
		}
	}
	
	private void Ethnicity(){
		Query result = new Query("ethnicity(E)"); 

		Map<String, Term>[] solution =  result.allSolutions();

		for( Map<String, Term> term: solution) {
			EthnicityDropdown.addItem(
					term.values()
					.toString()
					.replace("[", "")
					.replace("]", "")
					.replace("_", " ")
					.replace("'", "")
			);
		}
	}
	
	private void Gender(){
		Query result = new Query("gender(E)"); 

		Map<String, Term>[] solution =  result.allSolutions();

		for( Map<String, Term> term: solution) {
			GenderDropdown.addItem(
					term.values()
					.toString()
					.replace("[", "")
					.replace("]", "")
					.replace("_", " ")
					.replace("'", "")
			);
		}
	}
	
	private void AssociatedVarient(String symtom) {
		Query result = new Query("associated(" + symtom +",What_Varient)"); 
		Map<String, Term>[] solution =  result.allSolutions();

		for( Map<String, Term> term: solution) {
					term.values()
					.toString()
					.replace("[", "")
					.replace("]", "")
					.replace("_", " ")
					.toUpperCase();
					
					System.out.println(symtom +" is associated with: " + term.values()
					.toString()
					.replace("[", "")
					.replace("]", "")
					.replace("_", " ")
					.toUpperCase() + " varient");
		}
	}


	public void actionPerformed(ActionEvent e) {
		System.out.println(e.getActionCommand());
		
		switch (e.getActionCommand()) {
			case "Reset": 	this.dispose();
							new Diagnose("Covid-19 Management System");
				break;
			case "Main": 	this.dispose();
							new MainMenu("Covid-19 Management System");
				break;
			case "Submit":	DiagnsePatient();
				break; 
			case "comboBoxChanged":	UpdateSymtomsDisplay();
				break; 
			default:
				break;
		}

	}


	private void UpdateSymtomsDisplay() {
		
		if(
				SymptomDropdown.getSelectedItem().toString().equalsIgnoreCase("dizziness") || 
				SymptomDropdown.getSelectedItem().toString().equalsIgnoreCase("fainting") || 
				SymptomDropdown.getSelectedItem().toString().equalsIgnoreCase("blurred vision") 
				
		) {
			SystolicDiastolicVisibility(true);
		}
		if(SymptomDropdown.getSelectedIndex() != 0) {
			symtomList.add(SymptomDropdown.getSelectedItem().toString()); 
			displaySelectedSymtoms.append(SymptomDropdown.getSelectedItem()+"\n");
			SymptomDropdown.removeItem(SymptomDropdown.getSelectedItem());
			SymptomDropdown.setSelectedIndex(0);
		}
	}
	
	private void BloodPressureCheck() {
		Query highPressureCheck = new Query("high_pressure("+ Sytolic.getText() + "," + Diastolic.getText() +")");
		boolean highPressure = highPressureCheck.hasSolution(); 
		
		
		Query lowPressureCheck = new Query("low_pressure("+ Sytolic.getText() + "," +  Diastolic.getText() +")");
		boolean lowPressure = lowPressureCheck.hasSolution(); 
		
		if(highPressure) {
			JOptionPane.showMessageDialog(null,  " " , "High Blood Pressure Alert!", JOptionPane.INFORMATION_MESSAGE, null );
		}else if(lowPressure) {
			JOptionPane.showMessageDialog(null,  " " , "Low Blood Pressure Alert!", JOptionPane.INFORMATION_MESSAGE, null );
		}
	}


	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}


	@Override
	public void keyPressed(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}


	@Override
	public void keyReleased(KeyEvent e) {
		try {
		Query convertTemperature = new Query("convert_temperature("+ Temperature_C.getText() + ",Fahrenheit" +")");
			Temperature_F.setText(
					convertTemperature
					.oneSolution()
					.values()
					.toString()
					.replace("[", "")
					.replace("]", "")
			);
			
			
		Query checkTemperature = new Query("high_fever("+ Temperature_F.getText() +")");
		boolean highTemp = checkTemperature.hasSolution();
		if(highTemp) {
			JOptionPane.showMessageDialog(null, Temperature_F.getText() + " Degree Fahrenheit" , "High Fever Alert!", JOptionPane.INFORMATION_MESSAGE, null );
		}
		}catch(Exception error) {
			Temperature_F.setText("");
		}
	}
	
	private void SystolicDiastolicVisibility(boolean visibility) {
		Sytolic.setText("");
		Diastolic.setText("");
		Sytolic.setVisible(visibility);
		SytolicLabel.setVisible(visibility);
		Diastolic.setVisible(visibility);
		DiastolicLabel.setVisible(visibility);
	}
	
	private void ClearFields() {
		FirstName.setText("");
		LastName.setText("");
		EthnicityDropdown.setSelectedIndex(0);
		Age.setText("");
		GenderDropdown.setSelectedIndex(0);
		ParishDropdown.setSelectedIndex(0);
		Temperature_C.setText("");
		Temperature_F.setText("");
		SymptomDropdown.setSelectedIndex(0);
		Sytolic.setText("");
		Diastolic.setText("");
	}
	private Boolean AllEntryChecked() { //check input field
		boolean all = true;
		if(FirstName.getText().equals("")){
			FirstName.setBorder(new LineBorder(java.awt.Color.RED, 1));
			all = false;
		}else {
			FirstName.setBorder(new LineBorder(java.awt.Color.GREEN, 1));
		}
		if(LastName.getText().equals("")){
			LastName.setBorder(new LineBorder(java.awt.Color.RED, 1));
			all = false;
		}else {
			LastName.setBorder(new LineBorder(java.awt.Color.GREEN, 1));
		}
		if(EthnicityDropdown.getSelectedIndex() == 0){
			EthnicityDropdown.setBorder(new LineBorder(java.awt.Color.RED, 1));
			all = false;
		}else {
			EthnicityDropdown.setBorder(new LineBorder(java.awt.Color.GREEN, 1));
		}
		if(Age.getText().equals("")){
			Age.setBorder(new LineBorder(java.awt.Color.RED, 1));
			all = false;
		}else {
			Age.setBorder(new LineBorder(java.awt.Color.GREEN, 1));
		}
		if(GenderDropdown.getSelectedIndex() == 0){
			GenderDropdown.setBorder(new LineBorder(java.awt.Color.RED, 1));
			all = false;
		}else {
			GenderDropdown.setBorder(new LineBorder(java.awt.Color.GREEN, 1));
		}
		if(ParishDropdown.getSelectedIndex() == 0){
			ParishDropdown.setBorder(new LineBorder(java.awt.Color.RED, 1));
			all = false;
		}else {
			ParishDropdown.setBorder(new LineBorder(java.awt.Color.GREEN, 1));
		}
		if(Temperature_C.getText().equals("")){
			Temperature_C.setBorder(new LineBorder(java.awt.Color.RED, 1));
			all = false;
		}else {
			Temperature_C.setBorder(new LineBorder(java.awt.Color.GREEN, 1));
		}
		if(symtomList.size() == 0){
			SymptomDropdown.setBorder(new LineBorder(java.awt.Color.RED, 1));
			all = false;
		}else {
			SymptomDropdown.setBorder(new LineBorder(java.awt.Color.GREEN, 1));
		}
		if(Sytolic.isVisible()){
			if(Sytolic.getText().equals("")){
				Sytolic.setBorder(new LineBorder(java.awt.Color.RED, 1));
				all = false;
			}else {
				Sytolic.setBorder(new LineBorder(java.awt.Color.GREEN, 1));
			}
			if(Diastolic.getText().equals("")){
				Diastolic.setBorder(new LineBorder(java.awt.Color.RED, 1));
				all = false;
			}else {
				Diastolic.setBorder(new LineBorder(java.awt.Color.GREEN, 1));
			}
		}
		return all;
	}
	
}