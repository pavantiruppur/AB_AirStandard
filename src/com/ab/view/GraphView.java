package com.ab.view;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.geom.Line2D;

import javax.swing.ImageIcon;
import javax.swing.JPanel;

@SuppressWarnings("serial")
public class GraphView extends JPanel {

	private static GraphView instance;

	private GraphView() {
		init();
	}

	public static GraphView getInstance() {
		if (instance == null) {
			instance = new GraphView();
		}
		return instance;
	}

	private void init() {
		setPreferredSize(new Dimension(1280, 700));
	}

	protected void paintComponent(Graphics g) {
		super.paintComponent(g);

		Graphics2D g2 = (Graphics2D) g;
		ImageIcon imageIcon = new ImageIcon(getClass().getClassLoader().getResource("resources/images/graph-bg.jpg"));
		g2.drawImage(imageIcon.getImage(), 0, 0, null);
		g2.translate(getWidth() / 2, getHeight() / 2);

		g2.scale(6.0, 6.0);
		g2.setStroke(new BasicStroke(0.05f));
		g2.setPaint(Color.WHITE);

		double temp[] = {26,25,18,21,16,12,30,8};
		//g2.draw(new Line2D.Double(-80, 40, 95, 40)); // Temperature start axis
		drawGraph(g2, -80, 40, (21.25/30.0), temp);
		
		//g2.draw(new Line2D.Double(-80, 18.75, 95, 18.75)); // Temperature end & Humidity start axis
		drawGraph(g2, -80, 18.75, (21.25/60.0), temp);
		
		//g2.draw(new Line2D.Double(-80, -2.5, 95, -2.5)); // Humidity end & VOC start axis
		//drawGraph(g2, -80, -2.5, (21.25/20), temp);
		
		//g2.draw(new Line2D.Double(-80, -23.75, 95, -23.75)); // VOC end & Particle start axis
		drawGraph(g2, -80, -23.75, (21.25/5000.0), temp);
		
		//g2.draw(new Line2D.Double(-80, -45, 95, -45)); // Particle start axis & graph end
		//g2.draw(new Line2D.Double(-80, 40, -80, -45)); // Y axis

	}
	
	private void drawGraph(Graphics2D g2, double start, double range, double div, double[] values) {
		for(int i = 0; i<values.length-1; i++) {
			g2.draw(new Line2D.Double(start, range - (values[i] * div), start + (175/values.length), range - (values[i+1]) * div));
			start += 175/values.length;
		}
		/*double start = -80;
		double div = 21.25/30.0;
		for(int i = 0; i<temp.length-1; i++) {
			g2.draw(new Line2D.Double(start, 40 - (temp[i]*div), start + (175/temp.length), 40 - (temp[i+1])*div));
			//g2.draw(new Line2D.Double(start, 21.25 + (temp[i]%21.25), start + (175/temp.length), 21.25 + (temp[i+1])%21.25));
			start += 175/temp.length;
		}*/
	}

}
