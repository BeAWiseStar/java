// File name : GyuHyunLim_Lab_2.java
// Name : GyuHyun Lim
// Declaration : This is my own work of lab2

import java.util.Scanner;

class GyuHyunLim_Lab_2
{
	private static int number;
	private static int divisor;
	
	public static void main(String[] args)
	{
		Scanner input = new Scanner(System.in);
		
		System.out.print("Enter a number: ");
		number = input.nextInt();
		
		System.out.print("Enter a divisor: ");
		divisor = input.nextInt();
		System.out.println();
		 
		int quotient = (number/divisor);
		int remainder = (number%divisor);
		
		int number2 = quotient;
		int quotient2 = (number2/divisor);
		int remainder2 = (number2%divisor);
		
		int number3 = quotient2;
		int quotient3 = (number3/divisor);
		int remainder3 = (number3%divisor);
		
		int number4 = quotient3;
		int quotient4 = (number4/divisor);
		int remainder4 = (number4%divisor);
		
		int number5 = quotient4;
		int quotient5 = (number5/divisor);
		int remainder5 = (number5%divisor);
		
		System.out.printf("%-10s%-15s%-15s%-10s%n", "NO", "Divisor", "Quotient", "Remainder");
		System.out.println();
		
		System.out.printf("%-10d%-15d%-15d%-10d%n", number, divisor, quotient, remainder);
		
		System.out.printf("%-10d%-15d%-15d%-10d%n", number2, divisor, quotient2, remainder2);

		System.out.printf("%-10d%-15d%-15d%-10d%n", number3, divisor, quotient3, remainder3);
	
		System.out.printf("%-10d%-15d%-15d%-10d%n", number4, divisor, quotient4, remainder4);

		System.out.printf("%-10d%-15d%-15d%-10d%n", number5, divisor, quotient5, remainder5);
	}
}
		
		
		
		
		
	