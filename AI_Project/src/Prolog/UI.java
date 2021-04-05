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
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.LineBorder;

public class UI extends JFrame implements ActionListener{
	/**
	 * 
	 */ 
	private JLabel displayMessage = new JLabel();// where you type your message
	private JTextField FirstName = new JTextField();// where you type your key
	private JTextField LastName = new JTextField();// where you type your key 
	private JLabel FirstNameLabel = new JLabel("FIRSTNAME"); 
	private JLabel LastNameLabel = new JLabel("LASTNAME");  
	private JLabel EthnicityLabel = new JLabel("ETHNICITY"); 
	private JButton Button1 = new JButton("Button1");
	private JButton Button2 = new JButton("Button2");
	private JButton Button3 = new JButton("Button3");
	private JButton Button4 = new JButton("Button4"); 
	private String[] choices;
	private JComboBox<String> EthnicityDropdown;  
	private JLabel Background = new JLabel();
	

	
	public UI(String name){
		
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setVisible(true);
		setResizable(false);
		setLayout(null);
		setSize(800, 600); // width, height
		setTitle(name.toUpperCase());
		

		
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
		

		choices = new String[]{"","White", "Black", "Hispanic"};
		EthnicityDropdown = new JComboBox<String>(choices);
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
		
		Button1.addActionListener(this);
		Button1.setBounds(20, 520, 100, 29);
		getContentPane().add(Button1);
		
		
		Button2.addActionListener(this);
		Button2.setBounds(150, 520, 100, 29);
		getContentPane().add(Button2);
		
		
		Button3.addActionListener(this); 
		Button3.setBounds(280, 520, 100, 29);
		getContentPane().add(Button3);
		
		
		Button4.addActionListener(this);
		Button4.setBounds(410, 520, 100, 29);
		getContentPane().add(Button4);
		
		Background.setHorizontalAlignment(SwingConstants.CENTER); 
		Background.setIcon(new ImageIcon("Images/blue-covid-banner.jpg"));
		Background.setBounds(0, 0,1000, 700);
		add(Background);
	}

	

	
	public void actionPerformed(ActionEvent e) {
		System.out.println(e.getActionCommand());
		if(e.getActionCommand().equals("Encrypt")){
			if(EthnicityDropdown.getSelectedItem().equals("option1")) {
				
			}
		}
		
	}
}