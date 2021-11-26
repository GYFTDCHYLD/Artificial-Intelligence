package Prolog;


import java.io.*;
import com.sun.speech.freetts.*;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.SwingConstants;

public class MainMenu extends JFrame implements ActionListener{
	/**
	 * 
	 */
	
	private JButton Add = new JButton("Add Data");
	private JButton Diagnose = new JButton("Diagnose");
	private JButton Statistics = new JButton("Statistics");	
	
	private JLabel Background = new JLabel();
	
	public MainMenu(String name){
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setVisible(true);
		setResizable(false);
		setLayout(null);
		setSize(400, 200); // width, height
		setTitle(name.toUpperCase());
		setLocationRelativeTo(null);

		
		
		Add.addActionListener(this);
		Add.setBounds(20, 60, 100, 29);
		getContentPane().add(Add);
		
		
		Diagnose.addActionListener(this);
		Diagnose.setBounds(150, 60, 100, 29);
		getContentPane().add(Diagnose);
		
		
		Statistics.addActionListener(this); 
		Statistics.setBounds(280, 60, 100, 29);
		getContentPane().add(Statistics);
		
		
		Background.setHorizontalAlignment(SwingConstants.CENTER); 
		Background.setIcon(new ImageIcon("Images/blue-covid-banner.jpg"));
		Background.setBounds(0, 0,400, 400);
		add(Background);
	}

	

	
	public void actionPerformed(ActionEvent e) {
		AI_Driver.TextToSpeech("kevin16", e.getActionCommand());
		switch (e.getActionCommand()) {
			case "Add Data": 	this.dispose();
								new Add("Covid-19 Expert System");
				break;
			case "Diagnose": 	this.dispose();
								new Diagnose("Covid-19 Expert System");
				break;
			case "Statistics": 	this.dispose();
								new Statistics("Covid-19 Expert System");
				break; 
			default:
				break;
		}
	
	}
}