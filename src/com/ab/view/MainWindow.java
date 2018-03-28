package com.ab.view;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;

import javax.swing.BorderFactory;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import com.ab.action.FooterAction;
import com.ab.components.Components;

public class MainWindow {

	static MainWindow instance;
	
	public synchronized static MainWindow getInstance() {
		if (instance == null) {
			instance = new MainWindow();
		}
		return instance;
	}
	
	public JFrame frame;
	public JPanel mainPanel;
	
	public JPanel header;
	public JPanel body;
	public JPanel footer;
	public JLabel gasEmptyAlarmLbl;
	
	public Boolean isGasOn = false;
	public Double co2Value = 6.0;
	public Double o2Value = 5.5;
	
	JLabel o2ValueLbl = null;
	JLabel co2ValueLbl = null;
	
	FlowLayout flowLayout = new FlowLayout(FlowLayout.LEFT, 0 ,0);
	
	private MainWindow() {}
	
	public void loadFrame() {
		frame = Components.getFrame();
		
		mainPanel = new JPanel();
		mainPanel.setLayout(flowLayout);
		
		loadBody();
		
		loadFooter();
		frame.add(mainPanel);
		frame.setVisible(true);
	}
	
	
	private void loadBody() {
		body = new JPanel();
		body.setPreferredSize(new Dimension(1280, 700));
		body.setLayout(flowLayout);
		body.setBackground(new Color(33,33,33));

		body.add(HomeView.getInstance());
		body.add(GraphView.getInstance());
		mainPanel.add(body);
	}
	
	private void loadFooter() {
		
		footer = new JPanel();
		footer.setLayout(flowLayout);
		footer.setPreferredSize(new Dimension(1280, 100));
		footer.setBorder(BorderFactory.createMatteBorder(2, 0, 0, 0, new Color(142,141,141)));
		footer.setBackground(new Color(33,33,33));
		footer.setLayout(flowLayout);
		

		Icon logoIcon = new ImageIcon(getClass().getClassLoader().getResource("resources/images/logo.png"));
		JLabel logoLbl = new JLabel();
		logoLbl.setPreferredSize(new Dimension(880, 100));
		logoLbl.setBorder(new EmptyBorder(10, 10, 10, 10));
		logoLbl.setHorizontalAlignment(JLabel.LEFT);
		logoLbl.setVerticalAlignment(JLabel.CENTER);
		logoLbl.setIcon(logoIcon);
		
		footer.add(logoLbl);

		Icon logoIcon_i = new ImageIcon(getClass().getClassLoader().getResource("resources/images/info-menu.png"));
		JLabel logoLbl_i = new JLabel();
		logoLbl_i.setPreferredSize(new Dimension(100, 100));
		logoLbl_i.setBorder(new EmptyBorder(10, 10, 10, 10));
		logoLbl_i.setHorizontalAlignment(JLabel.LEFT);
		logoLbl_i.setVerticalAlignment(JLabel.CENTER);
		logoLbl_i.setIcon(logoIcon_i);
		
		footer.add(logoLbl_i);
		

		Icon logoIcon_settings = new ImageIcon(getClass().getClassLoader().getResource("resources/images/settings-menu.png"));
		JLabel logoLbl_settings = new JLabel();
		logoLbl_settings.setPreferredSize(new Dimension(100, 100));
		logoLbl_settings.setHorizontalAlignment(JLabel.LEFT);
		logoLbl_settings.setVerticalAlignment(JLabel.CENTER);
		logoLbl_settings.setIcon(logoIcon_settings);
		
		footer.add(logoLbl_settings);
		

		Icon logoIcon_graph = new ImageIcon(getClass().getClassLoader().getResource("resources/images/graph-menu.png"));
		JLabel logoLbl_graph = new JLabel();
		logoLbl_graph.setPreferredSize(new Dimension(100, 100));
		logoLbl_graph.setHorizontalAlignment(JLabel.LEFT);
		logoLbl_graph.setVerticalAlignment(JLabel.CENTER);
		logoLbl_graph.setIcon(logoIcon_graph);
		logoLbl_graph.addMouseListener(new FooterAction());
		footer.add(logoLbl_graph);
		

		Icon logoIcon_home = new ImageIcon(getClass().getClassLoader().getResource("resources/images/home-menu.png"));
		JLabel logoLbl_home = new JLabel();
		logoLbl_home.setName("Home");
		logoLbl_home.setPreferredSize(new Dimension(100, 50));
		logoLbl_home.setHorizontalAlignment(JLabel.LEFT);
		logoLbl_home.setVerticalAlignment(JLabel.CENTER);
		logoLbl_home.setIcon(logoIcon_home);
		//logoLbl_home.addMouseListener(new FooterAction());
		footer.add(logoLbl_home);

		mainPanel.add(footer);
	}
	
	public void refreshCo2() {
		co2ValueLbl.setText(String.format("%4.1f" , co2Value)); 
	}
	
	public void refreshO2() {
		o2ValueLbl.setText(String.format("%4.1f" , o2Value)); 
	}
}
