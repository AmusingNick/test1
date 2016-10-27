package com.frames;

import java.awt.Rectangle;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JTextField;

public class Index extends JFrame{
	static public String All = new String("");
	JTextField jt = new JTextField("0");
	JButton jbsp = new JButton("#");
	JButton jbLeft = new JButton("(");
	JButton jbRight = new JButton(")");
	JButton jb0 = new JButton("0");
	JButton jb1 = new JButton("1");
	JButton jb2 = new JButton("2");
	JButton jb3 = new JButton("3");
	JButton jb4 = new JButton("4");
	JButton jb5 = new JButton("5");
	JButton jb6 = new JButton("6");
	JButton jb7 = new JButton("7");
	JButton jb8 = new JButton("8");
	JButton jb9 = new JButton("9");
	JButton jb10 = new JButton("中缀表达式转为后缀表达式");
	JButton jb11 = new JButton("后缀表达式求值");
	JButton jb12 = new JButton("中缀表达式求值");
	JButton equals = new JButton("=");
	JButton adds = new JButton("+");
	JButton subs = new JButton("-");
	JButton divs = new JButton("/");
	JButton muls = new JButton("*");
	JButton c = new JButton("c");
	JButton cAll = new JButton("cAll");

	ActionListener alNum = new MListenerNum(this);
	ActionListener alc = new MListenerC(this);
	ActionListener alSign = new MListenerSign(this);
	ActionListener alFunction = new MListenerFunction(this);
	Index(){
		this.setTitle("简型计算器");
		this.setSize(400,550);
		this.setLocationRelativeTo(null);
		this.setDefaultCloseOperation(3);
		this.setVisible(true);
		this.setResizable(false);
		this.setLayout(null);
		
		jt.setSize(300,30);
		jt.setLocation(50,20);
		add(jt);
		jt.setEditable(false);
		jt.setHorizontalAlignment(JTextField.RIGHT);
		
		jb1.setSize(50,30);
		jb1.setLocation(50,70);
		add(jb1);
		jb1.addActionListener(alNum);
		
		jb2.setSize(50,30);
		jb2.setLocation(120,70);
		add(jb2);
		jb2.addActionListener(alNum);
		
		jb3.setSize(50,30);
		jb3.setLocation(190,70);
		add(jb3);
		jb3.addActionListener(alNum);
		
		jb4.setSize(50,30);
		jb4.setLocation(50,120);
		add(jb4);
		jb4.addActionListener(alNum);
		
		jb5.setSize(50,30);
		jb5.setLocation(120,120);
		add(jb5);
		jb5.addActionListener(alNum);
		
		jb6.setSize(50,30);
		jb6.setLocation(190,120);
		add(jb6);
		jb6.addActionListener(alNum);
		
		jb7.setSize(50,30);
		jb7.setLocation(50,170);
		add(jb7);
		jb7.addActionListener(alNum);
		
		jb8.setSize(50,30);
		jb8.setLocation(120,170);
		add(jb8);
		jb8.addActionListener(alNum);
		
		jb9.setSize(50,30);
		jb9.setLocation(190,170);
		add(jb9);
		jb9.addActionListener(alNum);
		
		jbsp.setSize(50,30);
		jbsp.setLocation(300,270);
		add(jbsp);
		jbsp.addActionListener(alNum);
		
		jbLeft.setSize(50,30);
		jbLeft.setLocation(50,320);
		add(jbLeft);
		jbLeft.addActionListener(alNum);
		
		jbRight.setSize(50,30);
		jbRight.setLocation(100,320);
		add(jbRight);
		jbRight.addActionListener(alNum);
		
		jb10.setSize(300,30);
		jb10.setLocation(50,370);
		add(jb10);
		jb10.addActionListener(alFunction);
		
		jb11.setSize(300,30);
		jb11.setLocation(50,420);
		add(jb11);
		jb11.addActionListener(alFunction);
		
		jb12.setSize(300,30);
		jb12.setLocation(50,470);
		add(jb12);
		jb12.addActionListener(alFunction);
		
		jb0.setSize(50,30);
		jb0.setLocation(50,220);
		add(jb0);
		jb0.addActionListener(alNum);
		
		equals.setSize(120,30);
		equals.setLocation(120,220);
		add(equals);
		equals.addActionListener(alSign);
		
		adds.setSize(90,30);
		adds.setLocation(260,70);
		add(adds);
		adds.addActionListener(alSign);
		
		subs.setSize(90,30);
		subs.setLocation(260,120);
		add(subs);
		subs.addActionListener(alSign);
		muls.setSize(90,30);
		muls.setLocation(260,170);
		add(muls);
		muls.addActionListener(alSign);
		divs.setSize(90,30);
		divs.setLocation(260,220);
		add(divs);
		divs.addActionListener(alSign);
		
		c.setSize(120,30);
		c.setLocation(50,270);
		add(c);
		c.addActionListener(alc);
		
		cAll.setSize(120,30);
		cAll.setLocation(175,270);
		add(cAll);
		cAll.addActionListener(alc);
	}
	
	public JTextField getJt() {
		return jt;
	}

	public void setJt(JTextField jt) {
		this.jt = jt;
	}
	
	public static String getAll() {
		return All;
	}

	public static void setAll1(String all) {
		All += all;
	}
	public static void setAll2(String all) {
		All = all;
	}

	public static void main(String[] args) {
		new Index();
	}
}
