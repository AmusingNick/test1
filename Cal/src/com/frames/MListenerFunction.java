package com.frames;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Stack;

import javax.swing.JButton;
import javax.swing.JOptionPane;

import com.test.BackCal;
import com.test.CenterCal;
import com.test.ToCenter;

public class MListenerFunction implements ActionListener{
	Index c;
	public MListenerFunction(Index c) {
		this.c = c;
	}
	public static void GetIngeterAnswer (Index c,Stack<Integer> result){
		String allAnswer = new String();
		if(!result.empty()){
			for(Integer x:result){
				allAnswer+=x;
			}
		}
		c.getJt().setText("0");
		c.getJt().setText(allAnswer);
	}
	
	public void actionPerformed(ActionEvent e) {
		Object obj = e.getSource();
		if(obj instanceof JButton){
			JButton jb = (JButton)obj;
			if(jb.getText().equals("中缀表达式转为后缀表达式")){
				Stack<String> back = ToCenter.LetToCenter(c.getJt().getText());
				String allAnswer = new String();
				if(!back.empty()){
					for(String x:back){
						allAnswer+=x;
					}
				}
				c.getJt().setText("0");
				c.getJt().setText(allAnswer);
			}
			if(jb.getText().equals("后缀表达式求值")){
				Stack<Integer> result = BackCal.GetCal(c.getJt().getText());
				GetIngeterAnswer (c,result);
			}
			if(jb.getText().equals("中缀表达式求值")){
				String test = c.getJt().getText();
				char[] chs = test.toCharArray();
				int zuok=0;
				int rightk = 0;
				for(int i=0;i<chs.length;i++){
					Character temp = chs[i];
					if(temp.equals('(')){
						zuok++;
					}
					if(temp.equals(')')){
						rightk++;
					}
				}
				if(zuok!=rightk){
					JOptionPane jop = new JOptionPane();
					jop.showMessageDialog(null, "左右括号不匹配");
				}else{
					if(test.contains("/0")){
						JOptionPane jop = new JOptionPane();
						jop.showMessageDialog(null, "不能进行除0");
					}else{
						/*Stack<Integer> result = CenterCal.GetCal(c.getJt().getText());
						GetIngeterAnswer (c,result);*/
						
						Stack<String> centerRusult = CenterCal.GetCal(c.getJt().getText());
						String allAnswer = new String();
						if(!centerRusult.empty()){
							for(String x:centerRusult){
								allAnswer+=x;
							}
						}
						c.getJt().setText("0");
						c.getJt().setText(allAnswer);
					}
				}
			}
		}
	}
}
