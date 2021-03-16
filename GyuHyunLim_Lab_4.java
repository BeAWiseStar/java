enum Type {Equilateral, Isosceles, Scalene, NotTriangle}

class PossibleTriangle
{
	private int a, b, c;
	private Type pt;
	
	public PossibleTriangle(int a, int b, int c)
	{
		this.a = a;
		this.b = b;
		this.c = c;
	}
	
	private boolean isTriangle()
	{
		if (((a+b)<=c) || ((a+c)<=b) || ((b+c)<=a))
		{
			return false;
		}
		else 
		{
			return true;
		}
	}
	
	private Type getType()
	{
		return pt;
	}
	
	public void displayInfo()
	{
		System.out.printf("a = %s, b = %s, c= %s%n" , a, b, c);
		
		if (isTriangle() == false)
		{
			pt = Type.NotTriangle;
		}
		else if ((a==b)&&(b==c)&&(a==c))
		{
			pt = Type.Equilateral;
		}
		else if ((a != b) && (b != c) && (a != c))
		{
			pt = Type.Scalene;
		}
		else 
		{
			pt = Type.Isosceles;
		}

		switch (pt)
		{
			case NotTriangle: if (isTriangle() == false)
								System.out.println("Not a triangle");
								break;
			case Equilateral : if ((a==b)&&(b==c)&&(a==c))
								System.out.println("Equilateral triangle");
			case Isosceles : if ((a==b)||(b==c)||(a==c))
								System.out.println("Isosceles triangle");
			case Scalene : if (isTriangle() == true)
								System.out.println("A triangle");
		}
		
		String Line = "------------------------------";
		System.out.println(Line);
	}
}

class GyuHyunLim_Lab_4
{
	public static void main(String[]args)
	{
		PossibleTriangle L1 = new PossibleTriangle(4, 5, 6);
		L1.displayInfo();
		
		PossibleTriangle L2 = new PossibleTriangle(1, 2, 3);
		L2.displayInfo();
		
		PossibleTriangle L3 = new PossibleTriangle(4, 5, 5);
		L3.displayInfo();
		
		PossibleTriangle L4 = new PossibleTriangle(6, 6, 6);
		L4.displayInfo();
	}
}	