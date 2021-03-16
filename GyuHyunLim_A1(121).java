// Full Name: Gyu Hyun Lim
// File Name: GyuHyunLim_A1.java
// UOW ID: 6573678
// Full Time
// T04
// Declaration: This program is done by myself

import java.util.Arrays;
import java.util.Collections;
import java.util.ArrayList;
import java.util.Random;

class MyInt
{
	private int n;
	
	public MyInt(int n)
	{
		setInt(n);
	}
	
	public void setInt(int n)
	{
		this.n = n;
	}
	
	public int getInt()
	{
		return n;
	}
}

enum SuitEnum
{
	Spade('S'), 
	Heart('H'),
	Diamond('D'),
	Club('C');
	
	private char suit;
	
	SuitEnum(char suit)
	{
		setSuit(suit);
	}
	
	public char getSuit()
	{
		return suit;
	}
	
	private void setSuit(char suit)
	{
		this.suit = suit;
	}
}

enum RankEnum
{
	Two('2'), Three('3'), Four('4'), Five('5'),
	Six('6'), Seven('7'), Eight('8'), Nine('9'),
	Ten('T'), Jack('J'), Queen('Q'), King('K'),
	Ace('A');
	
	private char rank;
	private int rankInt;
	
	RankEnum(char rank)
	{
		setRank(rank);
	}
	
	public char getRank()
	{
		return rank;
	}

	private void setRank(char rank)
	{
		this.rank = rank;
	}
}

class PlayingCard
{
	private SuitEnum suit;
	private RankEnum rank;
	
	public PlayingCard(SuitEnum suit, RankEnum rank)
	{
		setCard(suit, rank);
	}
	
	public PlayingCard(PlayingCard pc)
	{
		this(pc.suit, pc.rank);
	}
	
	public SuitEnum getSuit()
	{
		return suit;
	}
	
	public RankEnum getRank()
	{
		return rank;
	}
	
	public void setCard(SuitEnum suit, RankEnum rank)
	{
		this.suit = suit;
		this.rank = rank;
	}
	
	public String toString()
	{
		return String.format("%c%c ", suit.getSuit(), rank.getRank());
	}
}

class GyuHyunLim_A1
{
	private static final int MAXC = 13;
	private static final int MAXD = 52;
	private static Random rand = new Random();
	private static int i = rand.nextInt(13);
	private static int j = rand.nextInt(13);
	
	private static void deckOfCards(ArrayList <PlayingCard> cardList)
	{
		for(PlayingCard pc : cardList)
		{
			cardList.add(pc);
		}
	}
	
	private static void printDeck(ArrayList <PlayingCard> cardList)
	{
		System.out.println("Printing from ArrayList");
		System.out.println();
		int k = 1;
		
		for(PlayingCard pc : cardList)
		{
			System.out.print(pc);
			int n = k++;
			if(n % MAXC == 0)
				System.out.println();
		}
		
		System.out.println();		
		System.out.println("---------------------------------------");
	}
	
	private static void listToArray(ArrayList <PlayingCard> cardList, 
			PlayingCard [] cardArray)
	{		
		int k = 0;
		
		for(int i = 0; i < MAXD/MAXC; i++)
		{
			for(int j = 0; j < MAXC; j++) 
			{
				int n = k++;
				cardArray [n] = new PlayingCard(SuitEnum.values()[i],
		 							RankEnum.values()[j]);
				cardList.add(new PlayingCard(cardArray[n]));
			}
		}
	}
	
	private static void printDeck(PlayingCard [] cardArray)
	{
		System.out.println("Printing from array");
		System.out.println();
		int k = 0;
		
		for(int i = 0; i < MAXD/MAXC; i++)
		{
			for(int j = 0; j < MAXC; j++) 
			{
				int n = k++;
				System.out.print(cardArray[n]);
			}
			System.out.println();
		}
		
		System.out.println();
		System.out.println("---------------------------------------");
	}
	
	private static void transfer(PlayingCard [] cardArray, String [] strArray) 
	{
		int k = 0;
		
		for(int i = 0; i < MAXD/MAXC; i++)
		{
			for(int j = 0; j < MAXC; j++) 
			{
				int n = k++;
				strArray[n] = String.valueOf(cardArray[n]);
			}
		}
	}

	private static void shuffle(PlayingCard [] cardArray)
	{
		System.out.println("Shuffle the cards - Array version");
		System.out.println("Printing from array");
		System.out.println();
		
		for(int i = 0; i < cardArray.length; i++)
		{
			int i1 = rand.nextInt(52);
			PlayingCard pc = cardArray[i1];
			cardArray[i1] = cardArray[i];
			cardArray[i] = pc;
		}
		
		int k = 0;
		
		for(int i = 0; i < MAXD/MAXC; i++)
		{
			for(int j = 0; j < MAXC; j++) 
			{
				int n = k++;
				System.out.print(cardArray[n]);
			}
			System.out.println();
		}
		
		System.out.println();
		System.out.println("---------------------------------------");
	}
	
	private static void swap(String [] strArray, int i, int j)
	{
		for(int k = 0; k < strArray.length; k++)
		{
			if (k < 13)
			{
				String a = strArray[i];
				strArray[i] = strArray[j];
				strArray[j] = strArray[k];
				strArray[k] = a;
			}
			
			else if (k < 26)
			{
				String a = strArray[25 - i];
				strArray[25 - i] = strArray[25 - j];
				strArray[25 - j] = strArray[k];
				strArray[k] = a;
			}
			
			else if (k < 39)
			{
				String a = strArray[38 - i];
				strArray[38 - i] = strArray[38 - j];
				strArray[38 - j] = strArray[k];
				strArray[k] = a;
			}	
			
			else 
			{
				String a = strArray[51 - i];
				strArray[51 - i] = strArray[51 - j];
				strArray[51 - j] = strArray[k];
				strArray[k] = a;
			}	
		}
	}
	
	private static void displayStringArray(String [] strArray)
	{
		System.out.println("Swap the cards - Array version");
		System.out.println("Printing from array");
		System.out.println();
		
		int k = 0;
		
		for(int i = 0; i < MAXD/MAXC; i++)
		{
			for(int j = 0; j < MAXC; j++)
			{
				int n = k++;
				System.out.print(strArray[n]);
			}
			System.out.println();
		}
		
		System.out.println();
		System.out.println("---------------------------------------");
	}
	
	private static void transfer2D(String [][] twoD, String [] strArray)
	{
		int k = 0;
		
		for(int i = 0; i < MAXD/MAXC; i++)
		{
			for(int j = 0; j < MAXC; j++)
			{
				int n = k++;
				twoD [i][j] = strArray[n];
			}
		}
	}
	
	private static void sort2D(String [][] twoD)
	{
		String [] a1 = new String [13];
		String [] a2 = new String [13];
		String [] a3 = new String [13];
		String [] a4 = new String [13];
		
		for(int j = 0; j < MAXC; j++)
		{
			a1[j] = twoD[0][j];
		}
		
		for(int j = 0; j < MAXC; j++)
		{
			a2[j] = twoD[1][j];
		}
		
		for(int j = 0; j < MAXC; j++)
		{
			a3[j] = twoD[2][j];
		}
		
		for(int j = 0; j < MAXC; j++)
		{
			a4[j] = twoD[3][j];
		}
		
		Arrays.sort(a1, Collections.reverseOrder());
		Arrays.sort(a2, Collections.reverseOrder());
		Arrays.sort(a3, Collections.reverseOrder());
		Arrays.sort(a4, Collections.reverseOrder());

		for(int j = 0; j < MAXC; j++)
		{
			twoD[0][j] = a1[j];
		}
		
		for(int j = 0; j < MAXC; j++)
		{
			twoD[1][j] = a2[j];
		}
		
		for(int j = 0; j < MAXC; j++)
		{
			twoD[2][j] = a3[j];
		}
		
		for(int j = 0; j < MAXC; j++)
		{
			twoD[3][j] = a4[j];
		}
	}
	
	private static void print2D(String [][] strArray)
	{
		System.out.println("Re-arrange the cards");
		System.out.println();
		
		MyInt s = new MyInt(0);
		MyInt h = new MyInt(0);
		MyInt d = new MyInt(0);
		MyInt c = new MyInt(0);
		String [] anHand = new String [4];
		
		for(int i = 0; i < MAXD/MAXC; i++)
		{
			int k1 = 0;
			int k2 = 0;
			int k3 = 0;
			int k4 = 0;
			
			for(int j = 0; j < MAXC; j++) 
			{
				System.out.print(strArray[i][j]);
				if(strArray[i][j].charAt(0) == 'S')
					++k1;
				else if(strArray[i][j].charAt(0) == 'H')
					++k2;
				else if(strArray[i][j].charAt(0) == 'D')
					++k3;
				else
					++k4;
			}
			System.out.println();
			
			s = new MyInt(k1);
			h = new MyInt(k2);
			d = new MyInt(k3);
			c = new MyInt(k4);
			
			getHandInfo(anHand, s, h, d, c);
		}
		
		System.out.println();
		System.out.println("---------------------------------------");
	}
	
	private static void getHandInfo(String [] anHand, MyInt s, 
									MyInt h, MyInt d, MyInt c)
	{
		System.out.println(s.getInt() + " - " + h.getInt() + " - " 
							+ d.getInt() + " - " + c.getInt());
		for(int i = 0; i < MAXD/MAXC; i++)
		{
			anHand[i] = s.getInt() + " - " + h.getInt() + " - " 
					+ d.getInt() + " - " + c.getInt();
		}
	}
	
	public static void main(String [] args)
	{		
		ArrayList <PlayingCard> cardList = new ArrayList<PlayingCard>();
		PlayingCard [] cardArray = new PlayingCard [MAXD];
		String [] strArray = new String [MAXD];
		String [][] twoD = new String [MAXD/MAXC][MAXC];
			
		deckOfCards(cardList);
		listToArray(cardList, cardArray);
		printDeck(cardList);
		printDeck(cardArray);
		shuffle(cardArray);
		transfer(cardArray, strArray);
		swap(strArray, i, j);
		displayStringArray(strArray);
		transfer2D(twoD, strArray);
		sort2D(twoD);
		print2D(twoD);
	}
}

