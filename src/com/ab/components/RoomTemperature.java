package com.ab.components;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;

import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class RoomTemperature extends JPanel {

	JLabel logoLbl;
	JLabel valueLbl;
	String value = "24.2";
	
	private static RoomTemperature roomTemperature = null;
	public static RoomTemperature getInstance() {
		if (roomTemperature == null) {
			roomTemperature = new RoomTemperature();
		}
		return roomTemperature;
	}
	
	private RoomTemperature() {
		Components.setFlowLayoutPadding(FlowLayout.LEFT, this, 10, 3);
		setPreferredSize(new Dimension(600, 190));
		Icon logoIcon = new ImageIcon(getClass().getClassLoader().getResource("resources/images/temperature-icon.png"));
		logoLbl = new JLabel();
		logoLbl.setHorizontalAlignment(JLabel.CENTER);
		logoLbl.setVerticalAlignment(JLabel.CENTER);
		logoLbl.setIcon(logoIcon);
		
		valueLbl = new JLabel();
		valueLbl.setText("<html><font color=#a9a9a9>"+value + "</font>" + "</html>");
		valueLbl.setFont(Components.getDigital(160f));
		
		JPanel typePanel = new JPanel(new FlowLayout(FlowLayout.LEFT));
		typePanel.setPreferredSize(new Dimension(100, 150));
		JLabel typeLbl = new JLabel();
		typeLbl.setText("<html><font color=#a9a9a9>ºC</font></html>");
		typeLbl.setFont(new Font("ArialRegular", Font.PLAIN, 36));
		typePanel.setBackground(new Color(33,33,33));
		typePanel.add(typeLbl);

		setBackground(new Color(33,33,33));
		add(logoLbl);
		add(valueLbl);
		add(typePanel);
		
	}
	
	public void updateValue(String value) {
		try{
			this.value = String.valueOf(Double.parseDouble(value));
		}catch(Exception e) {
			e.printStackTrace();
		}
		valueLbl.setText("<html><font color=#a9a9a9>"+ this.value + "</font>" + "</html>");
		this.validate();
	}
}
