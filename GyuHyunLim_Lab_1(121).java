// Full Name: Gyu Hyun Lim
// File Name: GyuHyunLim_Lab_1.java
// UOW ID: 6573678
// Full Time
// T04
// Declaration: This program is done by myself

enum Month {January, February, March, April, May, June, July,
			August, September, October, November, December};
			
class Info
{
	private String name;
	private String nationality;
	private int date;
	private Month month;
	private int year;
	private String [] hobby;
	private String [] wish;
	
	public Info()
	{
		
	}
	
	public Info(String name, String nationality, int date, Month month, 
				int year, String [] hobby, String [] wish)
	{
		this.name = name;
		this.nationality = nationality;
		this.date = date;
		this.month = month;
		this.year = year;
		this.hobby = hobby;
		this.wish = wish;
	}			
	
	public void printInfo()
	{
		System.out.println("My Information");
		System.out.println("Name: " + name);
		System.out.println("National: " + nationality);
		System.out.println("Date of birth: " + date + " " 
							+ month + ", " + year);
		System.out.println("I have 2 hobbies");
		System.out.printf("  1: %s%n", hobby[0]);
		System.out.printf("  2: %s%n", hobby[1]);
		System.out.println("I have 4 wishes");
		System.out.printf("  1: %s%n", wish[0]);
		System.out.printf("  2: %s%n", wish[1]);
		System.out.printf("  3: %s%n", wish[2]);
		System.out.printf("  4: %s%n", wish[3]);
	}
}	
	
class GyuHyunLim_Lab_1
{	
	private static String [] getHobbyArray()
	{
		String [] hobby = {"Baseaball", "Reading"};
		return hobby;
	}
	
	private static String [] getWishArray()
	{
		String [] wish = {"HD", "HD!", "HD!!", "HD!!!"};
		return wish;
	}
	
	public static void main(String [] args)
	{
		
		Info A1 = new Info("Gyu Hyun Lim", "Republic of Korea", 21, Month.February, 
							1992, getHobbyArray(), getWishArray());
		A1.printInfo();
	}
}		
	
	
	