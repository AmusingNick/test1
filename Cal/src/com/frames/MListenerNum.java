package com.frames;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;

public class MListenerNum implements ActionListener{
	Index c;
	MListenerNum(Index c){
		this.c = c;
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		Object eiml = e.getSource();
		if(eiml instanceof JButton){
			JButton jb = (JButton)eiml;
			c.setAll1(jb.getText());
			c.getJt().setText(c.getAll());
		}
	}
}
