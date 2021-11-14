package Prolog;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Map;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.LineBorder;

import org.jpl7.Atom;
import org.jpl7.Query;
import org.jpl7.Term;

public class Add extends JFrame implements ActionListener{
	/**
	 * 
	 */
	private String[] Varient; 
	private JComboBox<String> VarientDropdown;
	private JLabel VarientLabel = new JLabel("VARIENT");
	
	private String[] Severity; 
	private JComboBox<String> SeverityDropdown;
	private JLabel SeverityLabel = new JLabel("SEVERITY");
	
	private JTextField Symptom = new JTextField();// where you type your key
	private JLabel SymtomLabel = new JLabel("SYMTOM");  
	private JButton Add = new JButton("Add Data");
	private JButton Main = new JButton("Main");
	
	
	private JLabel Background = new JLabel();

	
	public Add(String name){
		
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setVisible(true);
		setResizable(false);
		setLayout(null);
		setSize(400, 200); // width, height
		setTitle(name.toUpperCase());
		setLocationRelativeTo(null);
		
		Varient = new String[]{};
		VarientDropdown = new JComboBox<String>(Varient); 
		VarientDropdown.addActionListener(this);
		VarientDropdown.setFont(new Font("arial", Font.BOLD, 15));
		VarientDropdown.setVisible(true);
		VarientDropdown.setBounds(5, 10, 80, 25);
		add(VarientDropdown);
		VarientDropdown.setBorder(new LineBorder(java.awt.Color.RED, 1));
		VarientLabel.setBounds(90, 10, 300, 20);
		add(VarientLabel);
		VarientLabel.setForeground(Color.WHITE);
		VarientLabel.setFont(new Font("arial", Font.BOLD, 18));
		
		Severity = new String[]{};
		SeverityDropdown = new JComboBox<String>(Varient); 
		SeverityDropdown.addActionListener(this);
		SeverityDropdown.setFont(new Font("arial", Font.BOLD, 15));
		SeverityDropdown.setVisible(true);
		SeverityDropdown.setBounds(180, 10, 75, 25);
		add(SeverityDropdown);
		SeverityDropdown.setBorder(new LineBorder(java.awt.Color.RED, 1));
		SeverityLabel.setBounds(270, 10, 300, 20);
		add(SeverityLabel);
		SeverityLabel.setForeground(Color.WHITE);
		SeverityLabel.setFont(new Font("arial", Font.BOLD, 18));

		Symptom.setSize(250, 25); // width, height
		Symptom.setLocation(5, 50); // x, y
		Symptom.setBorder(new LineBorder(java.awt.Color.RED, 1));
		Symptom.setFont(new Font("arial", Font.BOLD, 15));
		add(Symptom);
		SymtomLabel.setHorizontalAlignment(SwingConstants.CENTER); 
		SymtomLabel.setBounds(160, 50, 300, 20);
		add(SymtomLabel);
		SymtomLabel.setForeground(Color.WHITE);
		SymtomLabel.setFont(new Font("arial", Font.BOLD, 18));
		
		
		Add.addActionListener(this);
		Add.setBounds(150, 100, 100, 29);
		getContentPane().add(Add);
		
		
		Main.addActionListener(this);  
		Main.setBounds(270, 100, 100, 29);
		getContentPane().add(Main);
		
		
		Background.setHorizontalAlignment(SwingConstants.LEADING); 
		Background.setIcon(new ImageIcon("Images/blue-covid-banner.jpg"));
		Background.setBounds(0, 0,400, 400);
		add(Background);
		
		Query q1 = new Query(
				"consult", new Term[] {new Atom("src/KnowledgeBase.pl")} 
				);
		System.out.println( "consult" + (q1.hasSolution() ? " succeeded" : " failed"));	
		Varient();//update dropdown from knowledgebase
		Severity();
	}

	

	
	public void actionPerformed(ActionEvent e) {
		
		switch (e.getActionCommand()) {
			case "Add Data": 	Write();
				break;
			case "Main": 		this.dispose();
								new MainMenu("Covid-19 Management System");
				break; 
			default:
				break;
		}
	}
	
	private void Write() {
		if(Symptom.getText().equals("")) {
			JOptionPane.showMessageDialog(null, Symptom.getText().toUpperCase() + " field cannot be blank/empty" , "COVID-19", JOptionPane.INFORMATION_MESSAGE, null );
			return;
		}
		try {
			FileWriter writer = new FileWriter("src/KnowledgeBase.pl",true);
				writer.write("symptom(" + Symptom.getText().toLowerCase().replaceAll(" ", "_")  + ").\n"
						+ "associated(" + Symptom.getText().toLowerCase().replaceAll(" ", "_") + "," + VarientDropdown.getSelectedItem().toString() + ").\n"
						+ "condition(" + SeverityDropdown.getSelectedItem().toString() + "," + Symptom.getText().toLowerCase().replaceAll(" ", "_") + ").\n"
						);
				writer.close();
			JOptionPane.showMessageDialog(null, Symptom.getText().toUpperCase() + " has been added to the list of symptoms" , "COVID-19", JOptionPane.INFORMATION_MESSAGE, null );
			Symptom.setText("");
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	private void Varient() { 
		Query result = new Query("varient(V)"); 

		Map<String, Term>[] solution =  result.allSolutions();

		for( Map<String, Term> term: solution) {
			VarientDropdown.addItem(
					term.values()
					.toString()
					.replace("[", "")
					.replace("]", "")
					.replace("_", " ")
			);
		}
	}
	
	private void Severity() { 
		Query result = new Query("severity(S)"); 

		Map<String, Term>[] solution =  result.allSolutions();

		for( Map<String, Term> term: solution) {
			SeverityDropdown.addItem(
					term.values()
					.toString()
					.replace("[", "")
					.replace("]", "")
					.replace("_", " ")
			);
		}
	}
}