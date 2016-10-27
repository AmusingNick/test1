package com.test;

import java.util.Scanner;
import java.util.Stack;

public class BackCal {
	static void ShowStack(Stack<Integer> s){
		if(!s.empty()){
			for(Integer x:s){
				System.out.print(x+" ");
			}
		}
	}
	
	public static Stack GetCal(String back){
		Character[] backChar = new Character[back.length()];
		for(int i=0;i<back.length();i++){
			backChar[i] = back.charAt(i);
		}
		Stack<Integer> OPTR = new Stack<Integer>();
		for(int i=0;i<backChar.length;i++){
			if(Character.isDigit(backChar[i])){
				OPTR.push(Integer.parseInt(backChar[i].toString()));
			}
			else{
				System.out.println("OPTR:");BackCal.ShowStack(OPTR);
				System.out.println();
				Integer a=-1,b=-1;
				Character theta;
				if(!OPTR.empty()){a = OPTR.pop();}
				if(!OPTR.empty()){b = OPTR.pop();}
				if(a!=-1&&b!=-1){
					theta = backChar[i];
					OPTR.push(GetValue(a,b,theta));
					System.out.println("OPTR:");BackCal.ShowStack(OPTR);
					System.out.println();
				}
			}
		}
		return OPTR;
	}
	public static int GetValue(int lvalue,int rvalue,char theta)
	{
		Integer result = 1;
		if(theta=='+') { return result =lvalue+rvalue; }
		if(theta=='-'&&lvalue>rvalue) { return result = lvalue-rvalue; }
		if(theta=='-'&&lvalue<rvalue) { return result = rvalue-lvalue;}
		if(theta=='*') { return result = lvalue*rvalue; }
		if(theta=='/'&&lvalue>rvalue) {return result = lvalue/rvalue;}
		if(theta=='/'&&lvalue<rvalue) {return result = rvalue/lvalue;}
		return result;
	}
	public static void main(String[] args) {
		String back = new String();
		Scanner sc = new Scanner(System.in);
		back = sc.next();
		(new BackCal()).GetCal(back);
	}
}
