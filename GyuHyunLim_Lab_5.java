// File name : GyuHyunLim_Lab_5.java
// Name : GyuHyun Lim
// Declaration : This is my own work of lab5

import java.util.Scanner;
import java.util.Random;

class MyInteger
{
	private int n;
	
	public MyInteger()
	{
		
	}
	
	public MyInteger(int n)
	{
		GyuHyunLim_Lab_5.getTwoIntegers();
	}
	
	public int getInteger()
	{
		return n;
	}
	
	public void setInteger(int n)
	{
		this.n = n;
	}
}	
	
class GyuHyunLim_Lab_5
{
	Scanner input = new Scanner(System.in);
	static Random rand = new Random();
	private static Scanner input2;
		
	public static void getTwoIntegers()
	{
		Math.abs (rand.nextInt ()%10);
	}//rand.nextInt()로 호출하면 -2147..... 부터 +2147....의 큰 수가 호출된다.
		
	public static char getOperator()
	{
		int n = (int) (Math.random () * 3);
		
		switch (n)
		{
			case 0: return '+';
			case 1: return '-';
			default : return '*';
		}
	}
		
	public static boolean checkAnswer(int x, int y, char oper, int answer)
	{
		int answer1 = answer;
		char oper1 = oper;
		int x1 = x;
		int y1 = y;
				
		if(oper1 == '+') 
		{		
			if ((x1 + y1) == answer1)
			{
				return true;
			}
			else
			{
				return false;
			}
		}
		
		else if(oper1 == '-') 
		{		
			if ((x1 - y1) == answer1)
			{
				return true;
			}
			else
			{
				return false;
			}
		}
		
		else
		{		
			if ((x1 * y1) == answer1)
			{
				return true;
			}
			else
			{
				return false;
			}
		}
	}
	
	public static void main(String[]args)
	{
		input2 = new Scanner(System.in);
		int c1 = 0;
		int c2 = 0;
				
		System.out.println("Welcome to CSIT111 Arithmetic World");
		System.out.println("You will solve 5 difficult arithmetic");
				
		for(int i = 1; i<6; i++)
		{	
			int a1 = Math.abs (rand.nextInt ()%10) ;
			int b1 = Math.abs (rand.nextInt ()%10) ;
			MyInteger my1 = new MyInteger();
			MyInteger my2 = new MyInteger();			
			my1.setInteger(a1);
			my2.setInteger(b1);
			int n1 = my1.getInteger();
			int m1 = my2.getInteger();
			char oper = getOperator();
			int answer;
			System.out.println();		
			System.out.printf("Question %s: %s %c %s = ?\n",i, n1, oper, m1);
			System.out.print("Your Answer is: ");
			answer = input2.nextInt();
					
			if (checkAnswer(n1,m1,oper,answer) == true)
			{
				System.out.println("Correct Answer");
				c1++;
			}
			else
			{
				System.out.println("Wrong Answer");
			}			
		}
		System.out.println();
		
		if (c1 == 5) 
		{
			System.out.printf("Your score %d / %d, well done\n", c1 ,5);
		}
		else 
		{
			System.out.printf("Your score %d / %d, hope you can score full mark next time\n", c1 ,5);
		}
		
		System.out.println();
		System.out.println("Welcome to CSIT111 Arithmetic World");
		System.out.println("You will solve 5 difficult arithmetic");
				
		for(int j = 1; j<6; j++)
		{	
			int a2 = Math.abs (rand.nextInt ()%10) ;
			int b2 = Math.abs (rand.nextInt ()%10) ;
			MyInteger my3 = new MyInteger();
			MyInteger my4 = new MyInteger();			
			my3.setInteger(a2);
			my4.setInteger(b2);
			int n2 = my3.getInteger();
			int m2 = my4.getInteger();
			char oper = getOperator();
			int answer;
			System.out.println();		
			System.out.printf("Question %d: %d %c %d = ?\n",j, n2, oper, m2);
			System.out.print("Your Answer is: ");
			answer = input2.nextInt();
					
			if (checkAnswer(n2,m2,oper,answer) == true)
			{
				System.out.println("Correct Answer");
				c2++;
			}
			else
			{
				System.out.println("Wrong Answer");
			}
		}
		
		System.out.println();
		
		if (c2 == 5) 
		{
			System.out.printf("Your score %d / %d, well done\n", c2 ,5);
		}
		else 
		{
			System.out.printf("Your score %d / %d, hope you can score full mark next time\n", c2 ,5);
		}
		
	}
}