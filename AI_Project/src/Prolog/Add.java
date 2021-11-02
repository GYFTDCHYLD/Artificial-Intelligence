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
		
		Varient = new String[]{""};
		VarientDropdown = new JComboBox<String>(Varient); 
		VarientDropdown.addActionListener(this);
		VarientDropdown.setFont(new Font("arial", Font.BOLD, 15));
		VarientDropdown.setVisible(true);
		VarientDropdown.setBounds(5, 10, 200, 25);
		add(VarientDropdown);
		VarientDropdown.setBorder(new LineBorder(java.awt.Color.RED, 1));
		VarientLabel.setBounds(210, 10, 300, 20);
		add(VarientLabel);
		VarientLabel.setForeground(Color.WHITE);
		VarientLabel.setFont(new Font("arial", Font.BOLD, 18));

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
		
		
		Background.setHorizontalAlignment(SwingConstants.CENTER); 
		Background.setIcon(new ImageIcon("Images/blue-covid-banner.jpg"));
		Background.setBounds(0, 0,600, 600);
		add(Background);
		
		Query q1 = new Query(
				"consult", new Term[] {new Atom("src/KnowledgeBase.pl")} 
				);
		System.out.println( "consult" + (q1.hasSolution() ? " succeeded" : " failed"));	
		Varient();//update dropdown from knowledgebase
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
		try {
			FileWriter writer = new FileWriter("src/KnowledgeBase.pl",true);
			if(VarientDropdown.getSelectedItem().toString().equals("regular")) {
				writer.write("symptom(" + Symptom.getText().toLowerCase().replaceAll(" ", "_")  + ").\nassociated(" + Symptom.getText().toLowerCase().replaceAll(" ", "_")  + ",regular"+ ").\n");
			}else if(VarientDropdown.getSelectedItem().toString().equals("delta")) {
				writer.write("symptom(" + Symptom.getText().toLowerCase().replaceAll(" ", "_")  + ").\nassociated(" + Symptom.getText().toLowerCase().replaceAll(" ", "_")  + ",delta"+ ").\n");
			}else if(VarientDropdown.getSelectedItem().toString().equals("mu")) {
				writer.write("symptom(" + Symptom.getText().toLowerCase().replaceAll(" ", "_")  + ").\nassociated(" + Symptom.getText().toLowerCase().replaceAll(" ", "_")  + ",mu"+ ").\n");
			}
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
}