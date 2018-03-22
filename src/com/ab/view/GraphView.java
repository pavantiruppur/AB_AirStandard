package com.ab.view;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.geom.Line2D;

import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
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
		
		Icon graphIcon = new ImageIcon(getClass().getClassLoader().getResource("resources/images/graph-bg.jpg"));
		JLabel graphLabel = new JLabel();
		graphLabel.setPreferredSize(new Dimension(1280, 700));
		graphLabel.setHorizontalAlignment(JLabel.CENTER);
		graphLabel.setVerticalAlignment(JLabel.CENTER);
		graphLabel.setIcon(graphIcon);
		
		//add(graphLabel);

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
		
		g2.draw(new Line2D.Double(-80, 40, 95, 40)); // Temperature start axis
		g2.draw(new Line2D.Double(-80, 18.75, 95, 18.75)); // Temperature end & Humidity start axis
		g2.draw(new Line2D.Double(-80, -2.5, 95, -2.5)); // Humidity end & VOC start axis
		g2.draw(new Line2D.Double(-80, -23.75, 95, -23.75)); // VOC end & Particle start axis 
		g2.draw(new Line2D.Double(-80, -45, 95, -45)); // Particle start axis & graph end
		g2.draw(new Line2D.Double(-80, 40, -80, -45)); // Y axis

	}

}
