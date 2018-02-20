package com.ab.components;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.Timer;

public class MachineTime extends JPanel {

	JLabel logoLbl;
	JLabel valueLbl;
	String value = "120";

    Timer timer;
    int counter = 0;
    final DateFormat dateFormat = new SimpleDateFormat("HH:mm:ss");
    final DateFormat timeFormat = new SimpleDateFormat("HH:mm:ss");
    
	public MachineTime() {
		valueLbl = new JLabel();
		Calendar now = Calendar.getInstance();
		valueLbl.setText("<html><font color=#14fc56>" + dateFormat.format(now.getTime()) + "</font></html>");
		valueLbl.setFont(Components.getDigital(140f));
		
        timer = new Timer(1000, new ActionListener() {
        	
            @Override
            public void actionPerformed(ActionEvent e) {
            		Calendar now = Calendar.getInstance();
            		valueLbl.setText("<html><font color=#14fc56>" + dateFormat.format(now.getTime()) + "</font></html>");
            		valueLbl.validate();
            }
        });
        timer.start();
		
		setBackground(new Color(33,33,33));
		add(valueLbl);
	}
}
