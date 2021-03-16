// Gyu Hyun Lim
// Full Time
// Tutorial Group 1
// Declaration : This work is my own and I won`t pass or share my work to peers
import java.util.Scanner;

class Product
{	
// in case number of item be changed, 4th 5th exists.
	public static int quantity1, quantity2, quantity3;
	public static double price1, price2, price3;
	public static String item1, item2, item3;
}

class GyuHyunLim_A1
{
    
    private static String LINE = "--------------------------------------------------";

    public static void main(String []args)
	{
		Scanner input = new Scanner (System.in);
		String item1, item2, item3;
		
	//Task1 start program, enter items
		System.out.println("Welcome to ABC online service");
		System.out.println("-----------------------------");
		System.out.println("Enter three items to be sold");
		
		System.out.print ("1. "); 		
		Product.item1 = input.nextLine ();
		
		System.out.print ("2. ");
		Product.item2 = input.nextLine ();
		
		System.out.print ("3. ");
		Product.item3 = input.nextLine ();
		System.out.println();
		
	//Task2 user input data, summary of items
		System.out.printf("Enter the quantities and price of %s: " ,Product.item1);
		Product.quantity1 = input.nextInt ();
		Product.price1 = input.nextDouble ();
		
		System.out.printf("Enter the quantities and price of %s: " ,Product.item2);
		Product.quantity2 = input.nextInt ();
		Product.price2 = input.nextDouble ();
		
		System.out.printf("Enter the quantities and price of %s: " ,Product.item3);
		Product.quantity3 = input.nextInt ();
		Product.price3 = input.nextDouble ();
		System.out.println();
		
		System.out.println("Summary of items");
		System.out.println("----------------");
		System.out.println();
		
		System.out.printf("%-25s%-15s%10s%n", "Item", "Quantity", "Price");
		System.out.println(LINE);
		
		System.out.printf("%-25s%-15d%10.2f%n", 
							Product.item1, Product.quantity1, Product.price1);
		System.out.printf("%-25s%-15d%10.2f%n", 
							Product.item2, Product.quantity2, Product.price2);
		System.out.printf("%-25s%-15d%10.2f%n",
							Product.item3, Product.quantity3, Product.price3);
		
		System.out.println(LINE);
		
	//Task3 Swap data
		String temp1 = Product.item1;
		Product.item1 = Product.item2;
		Product.item2= temp1;
		
		int temp2 = Product.quantity1;
		Product.quantity1 = Product.quantity2;
		Product.quantity2= temp2;
		
		double temp3 = Product.price1;
		Product.price1 = Product.price2;
		Product.price2= temp3;
		System.out.println();
				
		System.out.println("Summary of items after the swaps");
		System.out.println("--------------------------------");
		System.out.println();
		
		System.out.printf("%-25s%-15s%10s%n", "Item", "Quantity", "Price");
		System.out.println(LINE);
		
		System.out.printf("%-25s%-15d%10.2f%n", 
							Product.item1, Product.quantity1, Product.price1);
		System.out.printf("%-25s%-15d%10.2f%n", 
							Product.item2, Product.quantity2, Product.price2);
		System.out.printf("%-25s%-15d%10.2f%n",
							Product.item3, Product.quantity3, Product.price3);
		
		System.out.println(LINE);
		
	//Task4 user order, summary of order
		System.out.println("Please place your order");
		System.out.println("-----------------------");
		
		int order1, order2, order3;
		
		System.out.printf ("No of %s: ", Product.item1); 		
		order1 = input.nextInt ();
		System.out.printf ("No of %s: ", Product.item2); 		
		order2 = input.nextInt ();
		System.out.printf ("No of %s: ", Product.item3); 		
		order3 = input.nextInt ();
		System.out.println();
		
		System.out.println("Summary of you order");
		System.out.println("--------------------");
		System.out.println();
		
		System.out.printf("%-25s%-15s%10s%n", "Item", "Quantity", "Cost");
		System.out.println(LINE);
		
		double cost1 = Product.price1*order1;
		double cost2 = Product.price2*order2;
		double cost3 = Product.price3*order3;
		double subtotal = cost1 + cost2 + cost3;
		double gst = subtotal * 0.07;
		double totalcost = subtotal + gst;
		String b = "GST_(7%)";
		b = "GST (7%)";
		
		System.out.printf("%-25s%-15d%10.2f%n", 
				Product.item1, order1, cost1);
		System.out.printf("%-25s%-15d%10.2f%n", 
				Product.item2, order2, cost2);
		System.out.printf("%-25s%-15d%10.2f%n", 
				Product.item3, order3, cost3);
		System.out.println(LINE);

		
		System.out.printf("Subtotal: %40.2f%n", subtotal);
		System.out.printf("%-10s%40.2f%n", b, gst);
		System.out.printf("Total cost: %38.2f%n", totalcost);
		System.out.println(LINE);
		System.out.println();
		
	//Part5 Balance report
		System.out.println("Balance report");
		System.out.println("--------------");
		System.out.println();
		
		System.out.printf("%-25s%-15s%-10s%-10s%n", 
							"Item", "Quantity", "Sold", "Balance");
		
		System.out.println(LINE);
		
		int balance1 = Product.quantity1 - order1;
		int balance2 = Product.quantity2 - order2;
		int balance3 = Product.quantity3 - order3;
				
		System.out.printf("%-25s%-15d%-10d%-10d%n", 
				Product.item1, Product.quantity1,  order1, balance1);
		System.out.printf("%-25s%-15d%-10d%-10d%n", 
				Product.item2, Product.quantity2,  order2, balance2);
		System.out.printf("%-25s%-15d%-10d%-10d%n", 
				Product.item3, Product.quantity3,  order3, balance3);
		System.out.println(LINE);
		
	}

}