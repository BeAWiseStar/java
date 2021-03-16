// Full Name: Gyu Hyun Lim
// File Name: GyuHyunLim_A2.java
// UOW ID: 6573678
// Full Time
// T04
// Declaration: This program is done by myself

import java.util.ArrayList;
import java.util.Random;

enum ShapeColor{Blue, Yellow, Red, Green, White};

interface Shape
{
	public double area();
}

interface Resizable
{
	public void resize();
}

abstract class TwoD implements Shape
{
	protected ShapeColor sc;
	protected int a;
	protected int b;
	protected int c;
	protected int d;
	
	public TwoD()
	{
		
	}
	
	public TwoD(ShapeColor sc, int a)
	{
		this.sc = sc;
		this.a = a;
	}
	
	public TwoD(ShapeColor sc, int a, int b)
	{
		this.sc = sc;
		this.a = a;
		this.b = b;
	}
	
	public TwoD(ShapeColor sc, int a, int b, int c)
	{
		this.sc = sc;
		this.a = a;
		this.b = b;
		this.c = c;
	}
	
	public TwoD(ShapeColor sc, int a, int b, int c, int d)
	{
		set(sc, a, b, c, d);
	}
	
	public TwoD(TwoD td)
	{
		this(td.sc, td.a, td.b, td.c, td.d);
	}
	
	public int getA()
	{
		return a;
	}
	
	public int getB()
	{
		return b;
	}
	
	public int getC()
	{
		return c;
	}
	
	public int getD()
	{
		return d;
	}
	
	public ShapeColor getColor()
	{
		return sc;
	}
	
	public void set(ShapeColor sc, int a, 
					int b, int c, int d)
	{
		if(b == 0 && c == 0 && d == 0)
		{
			this.sc = sc;
			this.a = a;
		}
		
		else if(c == 0 && d == 0)
		{
			this.sc = sc;
			this.a = a;
			this.b = b;
		}
		
		else if(d == 0)
		{
			this.sc = sc;
			this.a = a;
			this.b = b;
			this.c = c;
		}
		
		else 
		{
			this.sc = sc;
			this.a = a;
			this.b = b;
			this.c = c;
			this.d = d;
		}
	}
	
	@Override
	public String toString()
	{
		if(b == 0 && c == 0 && d == 0)
		{
			return String.format("%s (%s, %d)", 
									"2D", sc, a);
		}
		
		else if(c == 0 && d == 0)
		{
			return String.format("%s (%s, %d, %d)", 
									"2D", sc, a, b);
		}
		
		else if(d == 0)
		{
			return String.format("%s (%s, %d, %d, %d)", 
									"2D", sc, a, b, c);
		}
		
		else 
		{
			return String.format("%s (%s, %d, %d, %d, %d)", 
									"2D", sc, a, b, c, d);
		}
	}
}

class Circle extends TwoD
{
	public Circle()
	{
		
	}
	
	public Circle(ShapeColor sc, int radius)
	{
		set(sc, radius);
	}
	
	public Circle(Circle c)
	{
		this(c.sc, c.a);
	}
	
	private double computeArea()
	{
		return Math.PI * a * a;
	}
	
	@Override
	public double area()
	{
		return computeArea();
	}
	
	public int getRadius()
	{
		return a;
	}
	
	public void set(ShapeColor sc, int radius)
	{
		super.set(sc, radius, 0, 0, 0);
	}
	
	@Override
	public String toString()
	{
		return String.format("%s (%s)", "Circle", super.toString());
	}
}

class Rectangle extends TwoD
{
	public Rectangle()
	{
		
	}
	
	public Rectangle(ShapeColor sc, int length, int width)
	{
		set(sc, length, width);
	}
	
	public Rectangle(Rectangle r)
	{
		this(r.sc, r.a, r.b);
	}
	
	private double computeArea()
	{
		return a * b;
	}

	@Override
	public double area() 
	{
		return computeArea();
	}
	
	public int getLength()
	{
		return a;
	}
	
	public int getWidth()
	{
		return b;
	}
	
	public void set(ShapeColor sc, int length, int width)
	{
		super.set(sc, length, width, 0, 0);
	}
	
	@Override
	public String toString()
	{
		return String.format("%s (%s)", "Rectangle", super.toString());
	}
}

class Triangle extends TwoD
{
	public Triangle()
	{
		
	}
	
	public Triangle(ShapeColor sc, int a, int b, int c)
	{
		set(sc, a, b, c);
	}
	
	public Triangle(Triangle t)
	{
		this(t.sc, t.a, t.b, t.c);
	}
	
	private double computeArea()
	{
		double s = (a + b + c) / 2.0;
		return Math.sqrt(s * (s - a) * (s - b) * (s - c));
	}
	
	@Override
	public double area()
	{
		return computeArea();
	}
	
	public int getA()
	{
		return a;
	}
	
	public int getB()
	{
		return b;
	}
	
	public int getC()
	{
		return c;
	}
	
	public void set(ShapeColor sc, int a, int b, int c)
	{
		super.set(sc, a, b, c, 0);
	}
	
	@Override
	public String toString()
	{
		return String.format("%s (%s)", "Triangle", super.toString());
	}
}

class Trapezoid extends TwoD
{
	private int height;
	
	public Trapezoid()
	{
		
	}
	
	public Trapezoid(ShapeColor sc, int a, int b, int c, int d, int h)
	{
		set(sc, a, b, c, d);
		height = h;
	}
	
	public int getA()
	{
		return a;
	}
	
	public int getB()
	{
		return b;
	}
	
	public int getC()
	{
		return c;
	}
	
	public int getD()
	{
		return d;
	}
	
	public int getHeight()
	{
		return height;
	}
	
	private double computeArea()
	{
		double area = ((a + c) / 2.0) * height;
		return area;
	}
	
	@Override
	public double area()
	{
		return computeArea();
	}
	
	@Override
	public void set(ShapeColor sc, int a, int b, int c, int d)
	{
		super.set(sc, a, b, c, d);
	}
	
	@Override
	public String toString()
	{
		return String.format("%s (%s%d)", "Trapezoid", 
									super.toString(), height);
	}
}

abstract class ThreeD implements Shape, Resizable
{
	protected ShapeColor sc;
	protected double a;
	
	public ThreeD()
	{
		
	}
	
	public ThreeD(ShapeColor sc, double a)
	{
		set(sc, a);
	}
	
	public ThreeD(ThreeD td)
	{
		this(td.sc, td.a);
	}
	
	public double getA()
	{
		return a;
	}
	
	public void set(ShapeColor sc, double a)
	{
		this.sc = sc;
		this.a = a;
	}
	
	@Override
	public void resize()
	{
		set(sc, a * 0.9);
	}
	
	protected double volume()
	{
		return a * a * a;
	}
	
	@Override
	public String toString()
	{
		return String.format("%s (%s, %.3f)", "3D", sc, a);
	}
}

class Sphere extends ThreeD
{
	public Sphere()
	{
		
	}
	
	public Sphere(ShapeColor sc, double a)
	{
		set(sc, a);
	}
	
	public Sphere(Sphere s)
	{
		this(s.sc, s.a);
	}
	
	private double computeArea()
	{
		return 4.0 * Math.PI * a * a;
	}
	
	@Override
	public double area()
	{
		return computeArea();
	}
	
	private double computeVolume()
	{
		return (4.0 / 3.0) * Math.PI * super.volume();
	}
	
	@Override
	protected double volume()
	{
		return computeVolume();
	}
	
	public double getA()
	{
		return a;
	}
	
	@Override
	public void set(ShapeColor sc, double a)
	{
		super.set(sc, a);
	}
	
	@Override 
	public String toString()
	{
		return String.format("%s (%s)", "Sphere", super.toString());
	}
}

class Cube extends ThreeD
{
	public Cube()
	{
		
	}
	
	public Cube(ShapeColor sc, double a)
	{
		set(sc, a);
	}
	
	public Cube(Cube c)
	{
		this(c.sc, c.a);
	}
	
	private double computeArea()
	{
		return 6.0 * a * a;
	}
	
	@Override
	public double area()
	{
		return computeArea();
	}
	
	private double computeVolume()
	{
		return super.volume();
	}
	
	@Override
	protected double volume()
	{
		return computeVolume();
	}
	
	public double getA()
	{
		return a;
	}
	
	@Override
	public void set(ShapeColor sc, double a)
	{
		super.set(sc, a);
	}
	
	@Override 
	public String toString()
	{
		return String.format("%s (%s)", "Cube", super.toString());
	}
}

class Tetrahedron extends ThreeD
{
	public Tetrahedron()
	{
		
	}
	
	public Tetrahedron(ShapeColor sc, double a)
	{
		set(sc, a);
	}
	
	public Tetrahedron(Tetrahedron t)
	{
		this(t.sc, t.a);
	}
	
	private double computeArea()
	{
		return Math.sqrt(3) * a * a;
	}
	
	@Override
	public double area()
	{
		return computeArea();
	}
	
	private double computeVolume()
	{
		return (Math.sqrt(2) / 12.0) * super.volume();
	}
	
	@Override
	protected double volume()
	{
		return computeVolume();
	}
	
	public double getA()
	{
		return a;
	}
	
	@Override
	public void set(ShapeColor sc, double a)
	{
		super.set(sc, a);
	}
	
	@Override 
	public String toString()
	{
		return String.format("%s (%s)", "Tetrahedron", super.toString());
	}
}

class GyuHyunLim_A2
{
	private static Random rand = new Random();
	
	private static int getInt()
	{
		return rand.nextInt(9) + 1;
	}
	
	private static double getDouble()
	{
		return Math.abs(Math.random() * 9) + 1;
	}
	
	private static ShapeColor getColor()
	{
		return ShapeColor.values()[rand.nextInt(5)];
	}
	
	private static boolean isTriangle(int a, int b, int c)
	{
		if(a + b <= c || b + c <= a || a + c <= b)
			return false;
		else
			return true;
	}
	
	private static TwoD getTwoD()
	{
		int k = rand.nextInt(4);
		int a = getInt();
		int b = getInt();
		int c = getInt();
		int d = getInt();
		double e = Math.abs(a - c);
		double s = ((e + b + d) / 2);
		double tempArea = (Math.sqrt(s * (s - e) * (s - b) * (s - d)));
		int h = (int)((2 * s) / e);
		
		if(k == 0)
		{
			TwoD td = new Circle(getColor(), a);
			return td;
		}
		
		else if(k == 1)
		{
			TwoD td = new Rectangle(getColor(), a, b);
			return td;
		}
		
		else if(k == 2) 
		{
			TwoD td = new Triangle(getColor(), a, b, c);
			
			if(isTriangle(a, b, c) == true)
				return td;
			else
			{
				do
				{
					td = new Triangle(getColor(), getInt(), getInt(), getInt());
				}while(isTriangle(getInt(), getInt(), getInt()) == true);
				return td;
			}
		}
		
		else
		{
			TwoD td = new Trapezoid(getColor(), a, b, c, d, h);
			return td;
		}
	}
	
	private static ThreeD getThreeD()
	{
		int k = rand.nextInt(3);

		if(k == 0)
		{
			ThreeD td = new Sphere(getColor(), getDouble());
			return td;
		}
		
		else if(k == 1)
		{
			ThreeD td = new Tetrahedron(getColor(), getDouble());
			return td;
		}
		
		else 
		{
			ThreeD td = new Cube(getColor(), getDouble());
			return td;
		}
	}

	private static void displayList(ArrayList<Shape>alist)
	{
		int i = 1;
		
		for(Shape s : alist)
		{
			System.out.print("Shape " + (i) + ": ");
			
			if(s instanceof TwoD)
			{
				System.out.println(s.toString());
				System.out.printf("Area = %.3f%n", s.area());
				
				if(s instanceof Circle)
					System.out.println("I am a circle shape");
				else if(s instanceof Rectangle)
					System.out.println("I am a rectangle shape");
				else if(s instanceof Triangle)
					System.out.println("I am a triangle shape");
				else 
					System.out.println("I am a trapezoid");
				
				System.out.println("---------------------------------------");
			}
			
			else 
			{
				System.out.println(s.toString());
				System.out.printf("Surface area = %.3f%n", s.area());
				System.out.printf("Volume = %.3f%n", ((ThreeD)s).volume());
				((ThreeD)s).resize();
				System.out.println("Size reduced by 10%: " + s.toString());
				System.out.printf("Updated surface area = %.3f%n", s.area());
				System.out.printf("Updated volume = %.3f%n", ((ThreeD)s).volume());
				
				if(s instanceof Sphere)
					System.out.println("I am a sphere shape");
				else if(s instanceof Cube)
					System.out.println("I am a cube shape");
				else 
					System.out.println("I am a tetrahedron shape");
				
				System.out.println("---------------------------------------");
			}
			i++;
		}
	}
	
	public static void main(String [] args)
	{
		ArrayList <Shape> alist = new ArrayList <Shape> ();
	
		for (int i = 0; i < 8; i++)
		{
			int k = rand.nextInt(3);
			
			if(k == 0)
			{
				break;
			}
			
			else if(k == 1)
			{
				alist.add(getThreeD());
			}	
			
			else
			{
				alist.add(getTwoD());
			}			
		}
		
		displayList(alist);
	}
}