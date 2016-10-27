package com.frames;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;

public class MListenerSign implements ActionListener {
	Index c;

	MListenerSign(Index c) {
		this.c = c;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		Object sign = e.getSource();
		JButton signs = new JButton();
		if (sign instanceof JButton) {
			signs = (JButton) sign;
		}
		if ((signs.getText().equals("+")) || (signs.getText().equals("-"))
				|| (signs.getText().equals("*"))
				|| (signs.getText().equals("/"))) {
			String news = c.getJt().getText();
			if ((news.endsWith("+")) || (news.endsWith("-"))
					|| (news.endsWith("*")) || (news.endsWith("/"))) {
				int length = c.getAll().length();
				c.getJt().setText(c.getAll().substring(0, (length) - 1));
				c.setAll2(c.getAll().substring(0, (length) - 1));
				c.getJt().setText(c.getAll().concat(signs.getText()));
				c.setAll2(c.getAll().concat(signs.getText()));
			} else {
				news += signs.getText();
				c.getJt().setText(news);
				c.setAll2(news);
			}
		}

		else if (signs.getText().equals("=")) {
			//forTest.java
		}
	}
}
