// File name : GyuHyunLim_A3.java
// Full Time
// Tutorial Group 1
// Name : GyuHyun Lim
// Declaration : This is my own work of Assignment3

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

class MissWorld
{
	public static int SIZE = 8;
	private String country;
	private double [] score;
	
	public MissWorld (String country)
	{
		this.country = country;
		score = new double[SIZE];
		getScore();	
	}
	
	public String getCountry()
	{
		return country;
	}
	
	private void getScore()
	{
		for (int i = 0; i < score.length; i++)
		{
		score [i] = Math.random()*10.0;
		}
	}
	
	public void printInfo()
	{
		System.out.printf("%-15s", country);
		for (double k : score)
		{
			System.out.printf ("%5.1f", k);
		}
		System.out.printf("%7.2f%n", average());
	}
	
	private int highest()
	{
		int Max = 0;
		for (int i = 0; i < score.length; i++)
			if(score[Max] < score[i])
			{
				Max = i;
			}
		return Max;
	}
	
	private int lowest()
	{
		int Min = 0;
		for (int i = 0; i < score.length; i++)
			if(score[Min] > score[i])
			{
				Min = i;
			}
		return Min;
	}
	
	public double average()
	{
		double sum = 0;
		int max = highest();
		int min = lowest();
		for (double k : score)
			sum = sum + k;
		sum = sum - (score[min] + score[max]);
		double average = sum / 6; 
		return average;
	}
}

class GyuHyunLim_A3
{
	private static String [] Countries = {"Singapore", "Malaysia", "Thailand",
											"Brazil", "North Korea", "Japan",
											"USA", "France"};
											
	public static void constructAlist(ArrayList<MissWorld>alist)
	{
		for (int i = 0; i < Countries.length; i++)
		{
			alist.add(new MissWorld(Countries[i]));
		}
	}
	
	public static String getChampion(ArrayList<MissWorld>alist)
	{
		int champion = 0;
		for(int i = 0; i < Countries.length; i++)
		{
			if(alist.get(i).average() > alist.get(champion).average())
			{
				champion = i;
			}
		}return alist.get(champion).getCountry();
	}
	
	public static String firstRunnerUp(ArrayList<MissWorld>alist)
	{
		int champion = 0;
		int firstR = 1;
		for(int i = 0; i < Countries.length; i++)
		{
			if(alist.get(i).average() > alist.get(champion).average())
			{
				firstR = champion;
				champion = i;
			}
			else if(alist.get(i).average() > alist.get(firstR).average()
					&& alist.get(i).average() != alist.get(champion).average())
			{
				firstR = i;
			}
		}return alist.get(firstR).getCountry();
	}
	
	public static void listToArray(ArrayList<MissWorld>alist, Double [] resultArray)
	{	
		for (int i = 0; i < Countries.length; i++)
		{
			resultArray[i] = alist.get(i).average();
		}
		Arrays.sort(resultArray, Collections.reverseOrder());
	}		
			
	public static void printFinalRanking(ArrayList<MissWorld>alist, Double[] doubleArray)
	{
		System.out.printf("%-18s%-5s%-5s%-5s%-5s%-5s%-5s%-5s%-5s%-5s%n",
				"Countries","J1","J2","J3","J4","J5","J6","J7","J8","Average");
		
		for (MissWorld s : alist)
		{	
			s.printInfo();
		}		
		System.out.println();
		System.out.println("The result is");
		System.out.printf("Winner: Miss %s%n", getChampion(alist));
		System.out.printf("1st runner up: Miss %s%n", firstRunnerUp(alist));
		System.out.println();	
		System.out.println("Final ranking");
		System.out.println("Rank Country");
		System.out.println();
		
		for (int i = 0; i < Countries.length; i++)
		{
			System.out.printf("%d\t %s%n",i+1,findCountry(alist, doubleArray[i]));
		}
	}	
	
	public static String findCountry(ArrayList<MissWorld>alist, double d)
	{
		int a = 0 ;
		for (int i = 0; i < Countries.length; i++)
		{
			if (alist.get(i).average() == d)
			{
				a = i;
			}
		}
		return alist.get(a).getCountry();
	}
	
	public static void main(String[]args)
	{
		ArrayList<MissWorld>alist = new ArrayList<MissWorld>();
		constructAlist(alist);
		Double [] a = new Double [8];
		listToArray(alist,a);
		printFinalRanking(alist,a);
	}
}


