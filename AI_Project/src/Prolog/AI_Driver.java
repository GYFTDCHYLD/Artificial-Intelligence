package Prolog;

import java.awt.EventQueue;

import org.jpl7.*;


public class AI_Driver {
	
	public static void main(String[] args) {
		//EventQueue.invokeLater(new Runnable() {
			//public void run() {
		
				Query q1 = new Query(
					"consult", new Term[] {new Atom("C:\\Users\\Android\\Documents\\GitHub\\Artificial-Intelligence\\AI_Project\\src\\Prolog\\tutorial.pl")}
				);
				System.out.println( "consult" + (q1.hasSolution() ? "succeeded" : "failed"));
				
				Query q2 = new Query( "child_of",  new Term[] {new Atom("joe"),new Atom("ralf")} );
				System.out.println( "child_of(joe,ralf) is " +  (q2.hasSolution() ? "provable" : "not provable" ));
				//System.out.println( "consult " + (q1.hasSolution() ? "succeeded" : "failed"));
				q2.close();
				//new Main("Covid-19 Management System"); 
			//}
		//});
	}

}
