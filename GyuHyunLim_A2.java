// Gyu Hyun Lim
// Full Time
// Tutorial Group 1
// Assginment 2
// Declaration : This work is my own and I won`t pass or share my work to peers

import java.io.File;
import java.io.IOException;
import java.util.Scanner;

enum Gender {Male, Female}

class Date
{
	private int day;
	private String month;
	private int year;
	
	public Date(int day, String month, int year)
	{
		this.day = day;
		this.month = month;
		this.year = year;
	}
	
	public int getDay()
	{
		return day;
	}
	
	public String getMonth()
	{
		return month;
	}
	
	public int getYear()
	{
		return year;
	}
	
	public String getDateString()
	{
		return this.day+" "+this.month+","+" "+this.year;
	}
}

class HealthProfile
{	
	private String firstName, lastName;
	private Date dob;
	private double height;
	private Gender g;
	private double weight;
		
	public HealthProfile(String firstName, String lastName,
						 Date dob, double height, Gender g, 
						 double weight)
	{
		setInfo(firstName, lastName, dob, height, g, weight);
	}
	
	public HealthProfile(HealthProfile a)
	{
		this(a.firstName, a.lastName, a.dob, a.height, a.g, a.weight);
	}
		
	public String getFirstName()
	{
		return firstName;
	}
	
	public String getLastName()
	{
		return lastName;
	}
	
	public Date getDOB()
	{
		return dob;
	}
	
	public double getHeight()
	{
		return height;
	}

	public double getWeight()
	{
		return weight;
	}
	
	public void setInfo(String firstName, String lastName, 
						Date dob, double height, Gender g,
						double weight)
	{
		this.firstName = firstName;
		this.lastName = lastName;
		this.dob = dob;
		this.height = height;
		this.g = g;
		this.weight = weight;
	}
	
	public double computeBMI()
	{
		return this.weight/((this.height)*(this.height));
	}
	
	public double getBMI()
	{
		return this.computeBMI();
	}
	
	public void printProfile()
	{	
		System.out.printf("Name: %s %s%n", firstName, lastName);
		System.out.printf("Date of birth: %s%n", dob.getDateString());
		System.out.printf("Height: %.2f%n", height);
		System.out.printf("Gender: %s%n", g);
		System.out.printf("Weight: %.1f%n", weight);
		System.out.printf("Your BMI: %.2f%n", getBMI());
		System.out.println();
	}
}

class GyuHyunLim_A2 {

	public static void main(String[] args) throws IOException
	{
		Scanner input = new Scanner (new File ("PatientInfo.txt"));
		
		String firstName1, lastName1, firstName2, lastName2;
		int day1, day2;
		int year1, year2;
		String month1, month2;
		double height1, height2;
		Gender g1, g2;
		double weight1, weight2;
		Date dob1, dob2;
		int id = 1;
		
		firstName1 = input.nextLine();
		lastName1 = input.nextLine();
		day1 = input.nextInt();
		month1 = input.next();
		year1 = input.nextInt();
		input.nextLine();
		height1 = input.nextDouble();
		g1 = Gender.valueOf((input.next()));
		weight1 = input.nextDouble();
		dob1 = new Date(day1, month1, year1);
		
		HealthProfile s1 = new HealthProfile(firstName1, lastName1, 
											 dob1, height1, g1, weight1);
		System.out.println("Patient " + id);
		s1.printProfile();
		
		++id;
		input.nextLine();
		firstName2 = input.nextLine();
		lastName2 = input.nextLine();
		day2 = input.nextInt();
		month2 = input.next();
		year2 = input.nextInt();
		input.nextLine();
		height2 = input.nextDouble();
		g2 = Gender.valueOf((input.next()));
		weight2 = input.nextDouble();
		dob2 = new Date(day2, month2, year2);
		
		HealthProfile s2 = new HealthProfile(firstName2, lastName2, 
											 dob2, height2, g2, weight2);
		System.out.println("Patient " + id);
		
		s2.printProfile();
		
		System.out.println("Patient " + ++id);
		HealthProfile s3 = new HealthProfile(s2);
		s3.printProfile();
	}
}