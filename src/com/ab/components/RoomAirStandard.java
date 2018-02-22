package com.ab.components;

import java.awt.Color;
import java.awt.Dimension;

import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;

import com.ab.ModelAndView;

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
		Icon logoIcon = new ImageIcon(getClass().getClassLoader().getResource("resources/images/particle-icon.png"));
		logoLbl = new JLabel();
		logoLbl.setHorizontalAlignment(JLabel.CENTER);
		logoLbl.setVerticalAlignment(JLabel.CENTER);
		logoLbl.setIcon(logoIcon);
		
		valueLbl = new JLabel();
		valueLbl.setText("<html><font color=#a9a9a9>"+value + "</font>" + "</html>");
		valueLbl.setFont(Components.getDigital(160f));
		
		setBackground(new Color(33,33,33));
		add(logoLbl);
		add(valueLbl);
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
