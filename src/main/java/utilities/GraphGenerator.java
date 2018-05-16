package utilities;

import java.io.File;
import java.io.IOException;

import javax.swing.JFrame;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.ChartUtilities;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.PiePlot3D;
import org.jfree.data.general.DefaultPieDataset;
import org.jfree.data.general.PieDataset;
import org.jfree.util.Rotation;

import databuddy.databuddy.RunSanityTests;

public class GraphGenerator extends JFrame {
	
	private static final long serialVersionUID = 1L;
	public GraphGenerator(String title, String chartTitle)throws IOException {
		super(title);
		PieDataset dataset = createDataset();
		JFreeChart chart = createChart(dataset, chartTitle);
		ChartPanel chartPanel = new ChartPanel(chart);
		chartPanel.setPreferredSize(new java.awt.Dimension(500, 270));
		setContentPane(chartPanel);
	 }

	private PieDataset createDataset(){
		DefaultPieDataset result =  new DefaultPieDataset();
		result.setValue("Pass ("+RunSanityTests.PassCount+"%)", RunSanityTests.PassCount);
		result.setValue("Fail ("+RunSanityTests.FailCount+"%)", RunSanityTests.FailCount);
		return result;
	}
	
	private JFreeChart createChart(PieDataset dataset, String title)throws IOException{
		
		JFreeChart chart= ChartFactory.createPieChart3D(title, dataset, true, true, false);
		File outputfile= new File(AppiumSetup.propObj.getProperty("graph"));
		PiePlot3D plot = (PiePlot3D) chart.getPlot();
		//plot.setSectionPaint("Pass ("+JavaMail.passper+"%)", new Color(153,204,102));
		//plot.setSectionPaint("Fail ("+JavaMail.failper+"%)", new Color(227, 26, 28));
		plot.setStartAngle(290);
		plot.setDirection(Rotation.CLOCKWISE);
		plot.setForegroundAlpha(0.5f);
		ChartUtilities.saveChartAsJPEG(outputfile, chart, 500, 270);
		return chart;
	}

}
