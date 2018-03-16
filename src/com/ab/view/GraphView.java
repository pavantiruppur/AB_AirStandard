package com.ab.view;

import java.awt.Dimension;

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
		
		add(graphLabel);

	}

	/*protected void paintComponent(Graphics g) {
		super.paintComponent(g);
		setBackground(new Color(33, 33, 33));
		Graphics2D g2 = (Graphics2D) g;
		g2.translate(getWidth() / 2, getHeight() / 2);
		g2.scale(6.0, 6.0);
		g2.setStroke(new BasicStroke(0.05f));
		g2.setPaint(Color.WHITE);
		g2.draw(new Line2D.Double(-70, 35, 80, 35)); // X axis
		g2.draw(new Line2D.Double(-70, 35, -70, -35)); // Y axis

	}*/

}
