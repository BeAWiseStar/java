// Full Name : Gyu Hyun Lim
// File Name : GyuHyunLim_Lab_2.java
// Full Time
// T04
// Declaration : This program is done by myself

import java.util.Random;

class Point
{
	private int x;
	private int y;
	
	public Point()
	{
		
	}
	
	public Point(int x, int y)
	{
		set(x,y);
	}
	
	public Point(Point p)
	{
		this(p.x, p.y);
	}
	
	private double distance(Point p)
	{
		return Math.sqrt(((p.x - x) * (p.x - x)) + ((p.y - y) * (p.y - y)));
	}
	
	public double getDistance(Point p)
	{
		return distance(p);
	}
	
	public int getX()
	{
		return x;
	}
	
	public int getY()
	{
		return y;
	}
	
	public void set(int x, int y)
	{
		this.x = x;
		this.y = y;
	}
	
	public String toString()
	{
		return String.format ("Given Point (%s, %s)", x, y);
	}
}

class Line
{
	private Point p1;
	private Point p2;
	
	public Line()
	{
		
	}
	
	public Line(Point p1, Point p2)
	{
		set(p1, p2);
	}
	
	public Line(Line aline)
	{
		this(aline.p1, aline.p2);
	}
	
	public double getDistance()
	{
		return  Math.sqrt(((p1.getX() - p2.getX()) * (p1.getX() - p2.getX()))+ 
						 ((p1.getY() - p2.getY()) * (p1.getY() - p2.getY())));
	}
	
	public Point getP1()
	{
		return p1;
	}
	
	public Point getP2()
	{
		return p2;
	}
	
	public void set(Point p1, Point p2)
	{
		this.p1 = p1;
		this.p2 = p2;
	}
	
	public String toString()
	{
		return String.format ("Line (Point (%s, %s), " +
				"Point (%s, %s), distance = %.4f)",
				p1.getX(), p1.getY(), p2.getX(), p2.getY(),
				getDistance ());
	}
}

class GyuHyunLim_Lab_2
{
	private static Random rand = new Random();
	
	private static int getInt()
	{
		return rand.nextInt (100 + 1 + 100) - 100;
	}
	
	private static void getTwoPoints(Point p1, Point p2)
	{
		p1.set (getInt (), getInt ());
		p2.set (getInt (), getInt ());
	}
	
	public static void main(String [] args)
	{
		for(int i = 1; i<6; i++)
		{
			Point a1 = new Point();
			Point a2 = new Point();
			getTwoPoints(a1, a2);
			Line b = new Line();
			b.set(a1, a2);
			
			System.out.printf("Set %s%n", i);
			System.out.println(a1.toString ());
			System.out.println(a2.toString ());
			System.out.println(b.toString ());
			System.out.println("---------------------");
		}
	}
}


















 