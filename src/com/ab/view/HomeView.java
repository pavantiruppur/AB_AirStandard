package com.ab.view;

import java.awt.Color;
import java.awt.Dimension;

import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;

import com.ab.components.MachineTime;
import com.ab.components.RoomAirStandard;
import com.ab.components.RoomHumidity;
import com.ab.components.RoomPressure;
import com.ab.components.RoomTemperature;
import com.ab.components.RoomVOC;

@SuppressWarnings("serial")
public class HomeView extends JPanel{

	static HomeView instance; 
	
	public synchronized static HomeView getInstance() {
		if (instance == null) {
			instance = new HomeView();
		}
		return instance;
	}
	
	
	private HomeView() {
		init();
	}
	
	public void init() {

		setBackground(new Color(33,33,33));
		setPreferredSize(new Dimension(1280, 800));
		
		JPanel top = new JPanel();
		top.setPreferredSize(new Dimension(1280, 200));
		top.setBackground(new Color(33,33,33));
		
		JPanel topLeft = RoomTemperature.getInstance();
		top.add(topLeft);
		
		JPanel spacePanleTop = new JPanel();
		spacePanleTop.setPreferredSize(new Dimension(50, 200));
		spacePanleTop.setBackground(new Color(33,33,33));
		top.add(spacePanleTop);
		
		JPanel topRight = RoomPressure.getInstance();
		top.add(topRight);

		JPanel center = new JPanel();
		center.setPreferredSize(new Dimension(1280, 200));
		center.setBackground(new Color(33,33,33));
		
		JPanel centerLeft = RoomHumidity.getInstance();
		center.add(centerLeft);
		
		JPanel spacePanleCenter = new JPanel();
		spacePanleCenter.setPreferredSize(new Dimension(180, 200));
		spacePanleCenter.setBackground(new Color(33,33,33));
		center.add(spacePanleCenter);

		JPanel centerRigth = RoomVOC.getInstance();
		center.add(centerRigth);

		JPanel bottom = new JPanel();
		bottom.setPreferredSize(new Dimension(1280, 200));
		bottom.setBackground(new Color(33,33,33));
		
		JPanel bottomLeft = RoomAirStandard.getInstance();
		bottom.add(bottomLeft);
		
		JPanel spacePanleBottom = new JPanel();
		spacePanleBottom.setPreferredSize(new Dimension(150, 200));
		spacePanleBottom.setBackground(new Color(33,33,33));
		bottom.add(spacePanleBottom);

		JPanel bottomRigth = new MachineTime();
		bottom.add(bottomRigth);
		
		add(top);
		add(center);
		add(bottom);
	}
}
