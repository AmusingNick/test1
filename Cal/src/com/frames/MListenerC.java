package com.frames;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JOptionPane;

public class MListenerC implements ActionListener {
	Index c;

	MListenerC(Index c) {
		this.c = c;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		Object obj = e.getSource();
		JButton jb = new JButton();
		if(obj instanceof JButton){
			jb = (JButton)obj;
		}
		if(jb.getText().equals("c")){
			try {
				int length = c.getAll().length();
				c.getJt().setText("");
				c.getJt().setText(c.getAll().substring(0, (length) - 1));
				c.setAll2(c.getAll().substring(0, (length) - 1));
			} catch (Exception e2) {
				// TODO: handle exception
				//令其是空的时候，不会报错
				int length = 1 ; 
				c.getJt().setText("1");
				c.getJt().setText(c.getAll().substring(0, (length) - 1));
				c.setAll2(c.getAll().substring(0, (length) - 1));
			}
		}
		if(jb.getText().equals("cAll")){
			c.setAll2("");
			c.getJt().setText("0");
		}
	}
}
