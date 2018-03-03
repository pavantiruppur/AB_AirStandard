package com.ab.components;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;

import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class RoomAirStandard extends JPanel {

	JLabel logoLbl;
	JLabel valueLbl;
	String value = "120";
	
	private static RoomAirStandard roomAirStandard = null;
	public static RoomAirStandard getInstance() {
		if (roomAirStandard == null) {
			roomAirStandard = new RoomAirStandard();
		}
		return roomAirStandard;
	}
	
	private RoomAirStandard() {
		Components.setFlowLayoutPadding(FlowLayout.LEFT, this, 10, 3);
		setPreferredSize(new Dimension(600, 190));
//		setBorder(BorderFactory.createLineBorder(Color.WHITE));
		Icon logoIcon = new ImageIcon(getClass().getClassLoader().getResource("resources/images/particle-icon.png"));
		logoLbl = new JLabel();
		logoLbl.setHorizontalAlignment(JLabel.CENTER);
		logoLbl.setVerticalAlignment(JLabel.CENTER);
		logoLbl.setIcon(logoIcon);
		add(logoLbl);
		
		JPanel valuePanel = new JPanel();
		Components.setFlowLayoutPadding(FlowLayout.LEFT, valuePanel, 10, 3);
//		valuePanel.setBorder(BorderFactory.createLineBorder(Color.WHITE));
		valuePanel.setBackground(new Color(33,33,33));
		valuePanel.setPreferredSize(new Dimension(370, 190));

		valueLbl = new JLabel();
		valueLbl.setText("<html><font color=#a9a9a9>"+value + "</font>" + "</html>");
		valueLbl.setFont(Components.getDigital(160f));
		valuePanel.add(valueLbl);
		add(valuePanel);
		
		setBackground(new Color(33,33,33));
		JPanel typePanel = new JPanel(new FlowLayout(FlowLayout.LEFT));
//		typePanel.setBorder(BorderFactory.createLineBorder(Color.WHITE));
		typePanel.setPreferredSize(new Dimension(270, 40));
		JLabel typeLbl = new JLabel();
		typeLbl.setText("<html><font color=#a9a9a9>2.5 - 10 microns</font></html>");
		typeLbl.setFont(new Font("ArialRegular", Font.PLAIN, 20));
		typePanel.setBackground(new Color(33,33,33));
		typePanel.add(typeLbl);
		valuePanel.add(typePanel);
	}
	
	public void updateValue(String value) {
		try{
			this.value = String.valueOf(Integer.parseInt(value));
		}catch(Exception e) {
			e.printStackTrace();
		}
		valueLbl.setText("<html><font color=#a9a9a9>"+ this.value + "</font>" + "</html>");
		this.validate();
	}
}
