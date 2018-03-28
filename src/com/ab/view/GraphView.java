package com.ab.view;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.geom.Line2D;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.Arrays;
import java.util.Collections;

import javax.swing.ImageIcon;
import javax.swing.JPanel;

import com.ab.GraphReaderWriter;

public class GraphView extends JPanel {

	private static final long serialVersionUID = 1L;
	private static final double xPAD = -79;
	private static final double yPAD = 20.65;
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
		plotXYAxes((Graphics2D) g);
		drawGraph((Graphics2D) g);
	}
	
	private void plotXYAxes(Graphics2D g2) {
		g2.setPaint(Color.WHITE);
		g2.drawString(LocalTime.now().format(DateTimeFormatter.ofPattern("hh:mm")), 500, 260);
		for(int i = LocalTime.now().getHour()-1, x = 426; x >= -470; i--, x -= 88) {
			int time = Math.abs(i) % 12;
			g2.drawString(String.valueOf(time == 0 ? 12 : time), x, 260);
		}
		g2.setStroke(new BasicStroke(1.0f));
		g2.drawString(String.valueOf(Collections.max(Arrays.asList(GraphReaderWriter.readValues("temperature")))), -530, 130);
		g2.drawString(String.valueOf(Collections.max(Arrays.asList(GraphReaderWriter.readValues("humidity")))), -530, 5);
		g2.drawString(String.valueOf(Collections.max(Arrays.asList(GraphReaderWriter.readValues("voc")))), -530, -125);
		g2.drawString(String.valueOf(Collections.max(Arrays.asList(GraphReaderWriter.readValues("particle")))), -530, -253);
	}
	
	private void drawGraph(Graphics2D g2) {
		g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
		g2.scale(6.0, 6.0);
		g2.setStroke(new BasicStroke(0.3f));
		plotValues(g2, xPAD, 40, GraphReaderWriter.readValues("temperature"), Color.RED);
		plotValues(g2, xPAD, 18.75, GraphReaderWriter.readValues("humidity"), Color.BLUE);
		plotValues(g2, xPAD, -2.5, GraphReaderWriter.readValues("voc"), Color.GREEN);
		plotValues(g2, xPAD, -23.75, GraphReaderWriter.readValues("particle"), Color.PINK);
	}
	
	private void plotValues(Graphics2D g2, double start, double range, Double[] values, Color color) {
		g2.setPaint(color);
		double div = yPAD / Collections.max(Arrays.asList(values));
		for(int i = 0; i < values.length - 1; i++) {
			g2.draw(new Line2D.Double(start, range - (values[i] * div), start + (168.0 / (values.length - 1)), range - (values[i + 1] * div)));
			start += 168.0 / (values.length - 1);
		}
	}

}
