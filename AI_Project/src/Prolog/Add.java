package Prolog;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileWriter;
import java.io.IOException;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.LineBorder;

public class Add extends JFrame implements ActionListener{
	/**
	 * 
	 */
	
	private JTextField Symtom = new JTextField();// where you type your key
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

		Symtom.setSize(150, 25); // width, height
		Symtom.setLocation(5, 50); // x, y
		Symtom.setBorder(new LineBorder(java.awt.Color.RED, 1));
		Symtom.setFont(new Font("arial", Font.BOLD, 15));
		add(Symtom);
		SymtomLabel.setHorizontalAlignment(SwingConstants.CENTER); 
		SymtomLabel.setBounds(60, 50, 300, 20);
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
	}

	

	
	public void actionPerformed(ActionEvent e) {
		
		switch (e.getActionCommand()) {
			case "Add Data": 	Write();
				break;
			case "Main": 		this.dispose();
								new Main("Covid-19 Management System");
				break; 
			default:
				break;
		}
	}
	
	private void Write() {
		try {
			FileWriter writer = new FileWriter("src/KnowledgeBase.pl",true);
			writer.write("symtom(" + Symtom.getText().toLowerCase() + ").\n");
			writer.close();
			Symtom.setText("");
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}