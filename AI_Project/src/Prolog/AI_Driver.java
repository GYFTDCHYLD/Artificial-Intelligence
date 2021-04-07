package Prolog;

import java.awt.EventQueue;

public class AI_Driver {
	
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				new Main("Covid-19 Management System"); 
			}
		});
	}

}
