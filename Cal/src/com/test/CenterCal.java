package com.test;

import java.util.Stack;

public class CenterCal {
	static void ShowOPND(Stack<String> s){
		System.out.print("OPND:");
		if(!s.empty()){
			for(String x:s){
				System.out.print(x+" ");
			}
		}
	}
	
	static void ShowOPTR(Stack<Character> s){
		System.out.print("OPTR:");
		if(!s.empty()){
			for(Character x:s){
				System.out.print(x+" ");
			}
		}
		System.out.println();
	}
	public static Stack GetCal(String center){
		char[] chs = center.toCharArray();
		Stack OPTR = new Stack();
		OPTR.push('#');
		Stack OPND = new Stack();
		Character ch = chs[0];
		int i =0;
		while(ch!='#'||!OPTR.peek().equals('#')){
			/*if(Character.isDigit(ch)){
				OPND.push(Character.getNumericValue(ch));
				ShowOPND(OPND);
				ShowOPTR(OPTR);
				ch = chs[++i];
			}*/
			if(Character.isDigit(ch)){
				String IntegerString = "";
				for(int k =i;Character.isDigit(ch);k++){
					IntegerString += ch;
					i = k;
					ch = chs[++i];
					System.out.println("asdasda");
				}
				OPND.push(IntegerString);
			}
			else{
				switch(Precede((char)OPTR.peek(),ch))
				{
				case '<':
					OPTR.push(ch);
					//ShowOPND(OPND);
					ShowOPTR(OPTR);
					ch = chs[++i];
					break;
				case '>':
					char theta = (char)OPTR.pop();
					Integer a =-1;
					Integer b =-1;
					if(!OPND.empty()){a = Integer.parseInt((String)OPND.pop());}
					if(!OPND.empty()){b = Integer.parseInt((String)OPND.pop());}
					if(a!=-1&&b!=-1){
						Integer temp = BackCal.GetValue(a, b, theta);
						OPND.push(String.valueOf(temp));
						ShowOPND(OPND);
						ShowOPTR(OPTR);
					}
					break;
				case '=':
					OPTR.pop();
					ShowOPND(OPND);
					ShowOPTR(OPTR);
					ch = chs[++i];
					break;
				}
			}
		}
		return OPND;
	}
	static char[][] Get = 
		{{'>','>','<','<','<','>','>'},
		{'>','>','<','<','<','>','>'},
		{'>','>','>','>','<','>','>'},
		{'>','>','>','>','<','>','>'},
		{'<','<','<','<','<','=',' '},
		{'>','>','>','>',' ','>','>'},
		{'<','<','<','<','<',' ','='}};
	
	//定义算符优先级关系的函数
	static char Precede(char O1,char O2)
	{
		int operatorId1 = GetOperatorID(O1);
		int operatorId2 = GetOperatorID(O2);
		if(operatorId1==7||operatorId2==7){
			return '?';
		}else{
			return Get[operatorId1][operatorId2];
		}
	}
	static int GetOperatorID(char operator){
		if(operator=='+') return 0;
		else if(operator=='-') return 1;
		else if(operator=='*') return 2;
		else if(operator=='/') return 3;
		else if(operator=='(') return 4;
		else if(operator==')') return 5;
		else if(operator=='#') return 6;
		else return 7;
	}
	
	public static void main(String[] args) {
		/*String test = "(()";
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
		System.out.println(zuok);
		System.out.println(rightk);
		if(zuok!=rightk){
			System.out.println("左右括号不相等");
		}else{
			System.out.println("左右括号相等");
		}*/		
		Stack<String> test = CenterCal.GetCal("86-2#");
		CenterCal.ShowOPND(test);
	}
}
