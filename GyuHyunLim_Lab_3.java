// File name : GyuHyunLim_Lab_3.java
// Name : GyuHyun Lim
// Declaration : This is my own work of lab3

import java.util.Scanner;

class PetrolPurchase
{
	private String station;
	private double totalLiter;
	private String petrolType;
	private double pricePerLiter;
	private int discount;
	
	
	public PetrolPurchase(String s, double q, String t, double p, int d)
	{
		this.station = s;
		this.totalLiter = q;
		this.petrolType = t;
		this.pricePerLiter = p;
		this.discount = d;
	}
	//copy constructor
	public PetrolPurchase(PetrolPurchase pp)
	{
		this.station = pp.station;
		this.totalLiter = pp.totalLiter;
		this.petrolType = pp.petrolType;
		this.pricePerLiter = pp.pricePerLiter;
		this.discount = pp.discount;		
	}
	
	public String getStation()
	{
		return station;
	}
		
	public double getQuantity()
	{
		return totalLiter;
	}
	
	public String getPType()
	{
		return petrolType;
	}	
	
	public double getPrice()
	{
		return pricePerLiter;
	}	
	
	public int getDiscount()
	{
		return discount;
	}	
	
	public void setStation(String station)
	{
		this.station = station;
	}
	
	public void setQuantity(double totalLiter)
	{
		this.totalLiter = totalLiter;
	}
	
	public void setType(String petrolType)
	{
		this.petrolType = petrolType;
	}	
	
	public void setPrice(double pricePerLiter)
	{
		this.pricePerLiter = pricePerLiter;
	}	

	public void setDiscount(int discount)
	{
		this.discount = discount;
	}	
	
	public void setInfo(String s, double q, String t, double p, int d)
	{
		this.station = s;
		this.totalLiter = q;
		this.petrolType = t;
		this.pricePerLiter = p;
		this.discount = d;		
	}	
	
	public double computePayment()
	{
		return (this.pricePerLiter)*(this.totalLiter);
	}
	private double computeDiscount()
	{
		return this.computePayment()*discount*0.01;
	}
	
	public double getPayment()
	{
		return this.computePayment() 
				- (this.computePayment() * discount*0.01);
	}

	public void printInfo ()
	{
		System.out.printf ("Station: %s%n", station);
		System.out.printf ("Total Liter: %.2f%n", totalLiter);
		System.out.printf ("Petrol type: %s%n", petrolType);
		System.out.printf ("Price per liter: %.2f%n", pricePerLiter);
		System.out.printf ("Actual cost: %.2f%n", computePayment());      
		System.out.printf ("Discount: %.2f%n", computeDiscount());
		System.out.printf ("Amount to pay: %.2f%n", getPayment());       
	}
}

class GyuHyunLim_Lab_3
{
	public static void main(String [] args)
	{
		String station;
		double totalLiter;
		String petrolType;
		double pricePerLiter;
		int discount;

		Scanner input = new Scanner (System.in);
		
		System.out.printf("Enter the station: ");
		station = input.nextLine ();
		
		System.out.printf("Enter quantity in liter: ");
		totalLiter = input.nextDouble ();
		
		input.nextLine();
		
		System.out.printf("Enter type of petrol: ");
		petrolType = input.nextLine();

		System.out.printf("Enter price of petrol: ");
		pricePerLiter = input.nextDouble();
		
		System.out.printf("Enter discount: ");
		discount = input.nextInt ();
		
		System.out.printf ("\nSummary of your purchase\n");	
		PetrolPurchase p1 = new PetrolPurchase (station, totalLiter, petrolType, 
												pricePerLiter, discount);
		
		p1.printInfo();
		
		System.out.print("------------------------");
		System.out.print("\nDuplicate the same object\n");
		
		PetrolPurchase p2 = new PetrolPurchase (p1);
		
		p2.printInfo();
	}
}	