package com.ab.components;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;

import javax.swing.BorderFactory;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.Timer;

public class MachineTime extends JPanel {

	JLabel logoLbl;
	JLabel valueLbl;
	JLabel dayLbl;
	JLabel hhmmLbl;
	JLabel amPmLbl;
	JLabel secLbl;
	JLabel dateLbl;
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
		
		setPreferredSize(new Dimension(400, 200));
		
		JPanel timeLayout = new JPanel();
		Components.setFlowLayoutPadding(FlowLayout.RIGHT, timeLayout, 0, 0);
		timeLayout.setBackground(new Color(33,33,33));
		timeLayout.setPreferredSize(new Dimension(300, 190));
		
		JPanel dayPanel = new JPanel();
		dayPanel.setBackground(new Color(33,33,33));
//		dayPanel.setBorder(BorderFactory.createLineBorder(Color.WHITE));
		dayPanel.setPreferredSize(new Dimension(300, 45));
		dayLbl = new JLabel();
		dayLbl.setText("<html><font color=#14fc56>" + new SimpleDateFormat("EEEE").format(now.getTime()) + "</font></html>");
		dayLbl.setFont(new Font("Arial", Font.PLAIN, 30));
		dayPanel.add(dayLbl);
		timeLayout.add(dayPanel);
		
		JPanel timePanel = new JPanel();
		Components.setFlowLayoutPadding(FlowLayout.LEFT, timePanel, 0, 0);
		timePanel.setBackground(new Color(33,33,33));
//		timePanel.setBorder(BorderFactory.createLineBorder(Color.WHITE));
		timePanel.setPreferredSize(new Dimension(260, 90));
		
		JPanel hhmm = new JPanel();
		hhmm.setBackground(new Color(33,33,33));
		hhmm.setPreferredSize(new Dimension(200, 90));
		
		hhmmLbl = new JLabel();
		hhmmLbl.setText("<html><font color=#14fc56>" + new SimpleDateFormat("hh:mm").format(now.getTime()) + "</font></html>");
		hhmmLbl.setFont(new Font("Arial", Font.PLAIN, 70));
		hhmm.add(hhmmLbl);
		timePanel.add(hhmm);
		
		JPanel amPmPanel = new JPanel();
		amPmPanel.setBackground(new Color(33,33,33));
		amPmPanel.setPreferredSize(new Dimension(50, 65));
//		amPmPanel.setBorder(BorderFactory.createLineBorder(Color.WHITE));
		amPmLbl = new JLabel();
		amPmLbl.setText("<html><font color=#14fc56>" + new SimpleDateFormat("aa").format(now.getTime()) + "</font></html>");
		amPmLbl.setFont(new Font("Arial", Font.PLAIN, 20));
		amPmPanel.add(amPmLbl);
		secLbl = new JLabel();
		secLbl.setText("<html><font color=#14fc56>" + new SimpleDateFormat("ss").format(now.getTime()) + "</font></html>");
		secLbl.setFont(new Font("Arial", Font.PLAIN, 27));
		amPmPanel.add(secLbl);
		timePanel.add(amPmPanel);
		timeLayout.add(timePanel);
		
		JPanel datePanel = new JPanel();
		datePanel.setBackground(new Color(33,33,33));
//		datePanel.setBorder(BorderFactory.createLineBorder(Color.WHITE));
		datePanel.setPreferredSize(new Dimension(300, 45));
		dateLbl = new JLabel();
		dateLbl.setText("<html><font color=#14fc56>" + new SimpleDateFormat("dd MMM yyyy").format(now.getTime()) + "</font></html>");
		dateLbl.setFont(new Font("Arial", Font.PLAIN, 25));
		datePanel.add(dateLbl);
		timeLayout.add(datePanel);

		add(timeLayout);
		
        timer = new Timer(1000, new ActionListener() {
        	
            @Override
            public void actionPerformed(ActionEvent e) {
            		Calendar now = Calendar.getInstance();
            		dayLbl.setText("<html><font color=#14fc56>" + new SimpleDateFormat("EEEE").format(now.getTime()) + "</font></html>");
            		hhmmLbl.setText("<html><font color=#14fc56>" + new SimpleDateFormat("hh:mm").format(now.getTime()) + "</font></html>");
            		amPmLbl.setText("<html><font color=#14fc56>" + new SimpleDateFormat("aa").format(now.getTime()) + "</font></html>");
            		secLbl.setText("<html><font color=#14fc56>" + new SimpleDateFormat("ss").format(now.getTime()) + "</font></html>");
            		dateLbl.setText("<html><font color=#14fc56>" + new SimpleDateFormat("dd MMM yyyy").format(now.getTime()) + "</font></html>");
            		validate();
            }
        });
        timer.start();
		
		setBackground(new Color(33,33,33));
//		add(valueLbl);
	}
}
