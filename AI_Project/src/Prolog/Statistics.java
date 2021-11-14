package Prolog;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Map;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.axis.AxisLocation;
import org.jfree.chart.axis.NumberAxis;
import org.jfree.chart.labels.PieSectionLabelGenerator;
import org.jfree.chart.labels.StandardCategoryItemLabelGenerator;
import org.jfree.chart.labels.StandardPieSectionLabelGenerator;
import org.jfree.chart.plot.CategoryPlot;
import org.jfree.chart.plot.PiePlot;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.chart.renderer.category.CategoryItemRenderer;
import org.jfree.data.category.DefaultCategoryDataset;
import org.jfree.data.general.DefaultPieDataset;
import org.jpl7.Atom;
import org.jpl7.Query;
import org.jpl7.Term;

public class Statistics extends JFrame implements ActionListener{

	private JButton Main = new JButton("Main");
	private JLabel CaseCoount = new JLabel("casecount");
	private JLabel Background = new JLabel();

	private DefaultPieDataset pieDataset = new DefaultPieDataset( );  
	private JFreeChart pieChart = ChartFactory.createPieChart(      
			"Varient Data",   // chart title 
			pieDataset,          // data    
			true,             // include legend   
			true, 
			true);
	private ChartPanel pieChartPanel = new ChartPanel(pieChart);
	
	private DefaultCategoryDataset barDataset = new DefaultCategoryDataset();
	private JFreeChart barChart = ChartFactory.createBarChart(      
			"Symptoms Data",   // chart title 
			"",
			"",
			barDataset,          // data  
			PlotOrientation.VERTICAL,
			true,             // include legend   
			true, 
			false);
	private ChartPanel barChartPanel = new ChartPanel(barChart);

	public Statistics(String name){
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setResizable(false);
		setSize(800, 600); // width, height
		setVisible(true);
		setLocationRelativeTo(null);
 
		final PieSectionLabelGenerator pieChartLabel = new StandardPieSectionLabelGenerator("{0} varient: {2}");
		PiePlot plot =  (PiePlot) pieChart.getPlot();
		plot.setBackgroundPaint(Color.lightGray);
		plot.setLabelGenerator(pieChartLabel);
		pieChartPanel.setBounds(10,10,380,400);
		add(pieChartPanel);
		
		
		
		barChartPanel.setBounds(395,10,380,400);
		CategoryPlot CategoryPlot = barChart.getCategoryPlot();
		CategoryPlot.setBackgroundPaint(Color.lightGray);
		CategoryPlot.setDomainGridlinePaint(Color.white);
		//CategoryPlot.setRangeGridlinePaint(Color.white);
		CategoryPlot.setRangeAxisLocation(AxisLocation.BOTTOM_OR_LEFT);
		
		NumberAxis rangeAxis = (NumberAxis) CategoryPlot.getRangeAxis();
		//rangeAxis.setUpperMargin(100);
		//rangeAxis.centerRange(50);
		//rangeAxis.setLowerBound(0);
		rangeAxis.setVisible(false);
		
		CategoryItemRenderer renderer = CategoryPlot.getRenderer();
		renderer.setItemLabelsVisible(true);
		
		renderer.setItemLabelGenerator(new StandardCategoryItemLabelGenerator());
		
		
		
		add(barChartPanel);

		CaseCoount.setHorizontalAlignment(SwingConstants.CENTER); 
		CaseCoount.setBounds(0, 450, 760, 29);
		CaseCoount.setForeground(Color.WHITE);
		CaseCoount.setFont(new Font("arial", Font.BOLD, 25));
		add(CaseCoount);
		
		Main.addActionListener(this);  
		Main.setBounds(330, 520, 100, 29);
		add(Main);

		Background.setHorizontalAlignment(SwingConstants.CENTER); 
		Background.setIcon(new ImageIcon("Images/blue-covid-banner.jpg"));
		Background.setBounds(0, 0,1000, 700);
		add(Background);
		
		Query q1 = new Query(
				"consult", new Term[] {new Atom("src/KnowledgeBase.pl")} 
				);
		System.out.println( "consult" + (q1.hasSolution() ? " succeeded" : " failed"));	
		try {
			PieChart();
			BarChart();
			CaseCoount.setText("Number Of Cases: " + (Varient("mu") + Varient("delta") + Varient("regular")));// get the amount of patient with covid-19
		}catch(Exception e) {
			JOptionPane.showMessageDialog(null," No data available for patient(s)", "Diagnose patient", JOptionPane.INFORMATION_MESSAGE, null );		
		}
	}

	public void actionPerformed(ActionEvent e) {
		System.out.println(e.getActionCommand());

		switch (e.getActionCommand()) {
			case "Main": 	this.dispose();
			new MainMenu("Covid-19 Management System");
			break; 
			default:
				break;
		}
	}
	
	private void PieChart() {// piechart data
		pieDataset.setValue( "Mu" ,  Varient("mu")  );  
		pieDataset.setValue( "Delta" , Varient("delta") );   
		pieDataset.setValue( "Regular" , Varient("regular") );   
	}
	
	
	private int Varient(String var) {// retrieve the patient/data for requested strand of the virus
		Query result = new Query("cases(Patient," + var + ")"); 
		int total =  0;
		Map<String, Term>[] solution =  result.allSolutions();

		for( Map<String, Term> term: solution) {
			total+=1;
		}
		return total;
	}
	
	private void BarChart() {// barchart data
		barDataset.setValue(Status("severe"), "Severe", "Condition");
		barDataset.setValue(Status("mild"), "Mild", "Condition");  
	}
	private int Status(String stat) {// retrieve the patient/data for requested stats of the symptom
		Query result = new Query("severity(Patient," + stat + ")"); 
		int total =  0;
		Map<String, Term>[] solution =  result.allSolutions();

		for( Map<String, Term> term: solution) {
			total+=1;
		}
		return total;
	}
	
}
