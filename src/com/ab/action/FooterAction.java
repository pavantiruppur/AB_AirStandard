package com.ab.action;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import com.ab.view.GraphView;
import com.ab.view.HomeView;
import com.ab.view.MainWindow;

public class FooterAction implements MouseListener{

	private String action;

	public FooterAction(String action) {
		super();
		this.action = action;
	}

	@Override
	public void mouseClicked(MouseEvent e) {

	}

	@Override
	public void mousePressed(MouseEvent e) {
		if(action.equals(MainWindow.GRAPH)) {
			HomeView.getInstance().setVisible(false);
			GraphView.getInstance().setVisible(true);
		} else if(action.equals(MainWindow.HOME)) {
			GraphView.getInstance().setVisible(false);
			HomeView.getInstance().setVisible(true);
		}
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
