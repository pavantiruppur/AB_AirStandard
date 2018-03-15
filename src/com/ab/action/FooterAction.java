package com.ab.action;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import com.ab.view.GraphView;
import com.ab.view.HomeView;

public class FooterAction implements MouseListener{

	@Override
	public void mouseClicked(MouseEvent e) {
		HomeView.getInstance().setVisible(false);
		GraphView.getInstance().setVisible(true);
	}

	@Override
	public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

}
