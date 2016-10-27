package com.test;

import java.util.Scanner;
import java.util.Stack;

public class ToCenter {
	static void ShowStack(Stack<String> s){
		if(!s.empty()){
			for(String x:s){
				System.out.print(x+" ");
			}
		}
	}
	
	static void ShowTwoStack(Stack<String> s1,Stack<String> s2){
		System.out.print("Expt:");ShowStack(s1);System.out.println();
		System.out.print("stack:");ShowStack(s2);System.out.println("\n");
	}
	
	public static Stack LetToCenter(String center){
		Character[] centerChar = new Character[center.length()];
		for(int i=0;i<center.length();i++){
			centerChar[i] = center.charAt(i);
		}
		Stack<String> stack = new Stack<String>();  //运算符栈
		stack.push("#");
		Stack<String> Expt = new Stack<String>(); //后缀表达式栈
		for(int i = 0;i<center.length();i++){
			String c = centerChar[i].toString();
			if(c.equals("+")||c.equals("-")){
				if(stack.isEmpty()||stack.peek().equals("(")){
					stack.push(c);
					ShowTwoStack(Expt,stack);
				}else{
					while(!stack.isEmpty()&&
						(stack.peek().equals("*")||stack.peek().equals("/")||stack.peek().equals("+")||stack.peek().equals("-"))){
						Expt.push(stack.pop());
						ShowTwoStack(Expt,stack);
					}
					stack.push(c);
					ShowTwoStack(Expt,stack);
				}
			}else if(c.equals("*")||c.equals("/")){
				if(stack.isEmpty()||
						(stack.peek().equals("+")||stack.peek().equals("-")||stack.peek().equals("("))){
					stack.push(c);
					ShowTwoStack(Expt,stack);
					}else{
					while(!stack.isEmpty()&&(stack.peek().equals("/")||stack.peek().equals("*"))){
						Expt.push(stack.pop());
						ShowTwoStack(Expt,stack);
					}
					stack.push(c);
					ShowTwoStack(Expt,stack);
				}
			}else if(c.equals("(")){
				stack.push(c);
				ShowTwoStack(Expt,stack);
			}else if(c.equals(")")){
				String temp = "";
				while(!(temp=stack.pop()).equals("(")){
					Expt.push(temp);
					ShowTwoStack(Expt,stack);
				}
			}else if(c.equals("#")){
				while(!stack.empty()&&!stack.peek().equals("#")){
					Expt.push(stack.pop());
					ShowTwoStack(Expt,stack);
				}
			}else{
				if(Character.isDigit(centerChar[i])){
					String IntegerString = "";
					for(int k =i;Character.isDigit(centerChar[k]);k++){
						IntegerString += centerChar[k];
						i = k;
						continue;
					}
					Expt.push(IntegerString);
				}
				ShowTwoStack(Expt,stack);
			}
		}
		stack.pop();
		ShowTwoStack(Expt,stack);
		return Expt;
	}
	public static void main(String[] args) {
		String zhong = new String();
		Scanner sc = new Scanner(System.in);
		zhong = sc.next();
		Stack m =(new ToCenter()).LetToCenter(zhong);
		ShowStack(m);
	}
}
