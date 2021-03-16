// Full Name: Gyu Hyun Lim
// File Name: GyuHyunLim_Assign3.java
// UOW ID: 6573678
// Full Time
// T04
// Declaration: This program is done by myself

import java.util.Collections;
import java.util.ArrayList;

import javax.swing.JFrame;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JOptionPane;

import java.awt.GridLayout;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Color;
import java.awt.Font;

class LuckyBox extends JFrame
{
	private JButton [] jbArray = new JButton[49];
	private int [] intArray = new int[49];
	private Icon ic;
	private ArrayList <Integer> alist = new ArrayList <Integer> ();
	
	private void initialize()
	{
		for(int i = 0; i < jbArray.length; i++)
		{
			ic = new ImageIcon(String.valueOf(i % 2) + ".jpg");
			jbArray [i] = new JButton(ic);
			add(jbArray[i]);
		}
			
		for(int i = 0; i < intArray.length; i++)
		{
			intArray[i] = i + 1;
			alist.add(intArray[i]);
		}
		
		Collections.shuffle(alist);
	}
	
	private void registerEvent()
	{
		for(int i = 0; i < jbArray.length; i++)
		{
			jbArray[i].addActionListener(new DriveLB());
		}
	}
	
	public LuckyBox()
	{
		super("Good Luck To You");
		
		setLayout(new GridLayout(7,7));
				
		jbArray = new JButton[intArray.length];
		
		initialize();
		registerEvent();
	}
	
	private class DriveLB implements ActionListener
	{
		@Override
		public void actionPerformed(ActionEvent e)
		{
			ArrayList <Integer> randomInt = new ArrayList <Integer> ();
			ArrayList <Integer> winner = new ArrayList <Integer> ();
			
			int [] randInt = new int [7];
			
			for(int i = 0; i < 49; i++)
			{
				randomInt.add(i);
			}
			
			Collections.shuffle(randomInt);
			
			for(int i = 0; i < randInt.length; i++)
			{
				randInt[i] = randomInt.get(i);
			}
			
			for(int i = 0; i < jbArray.length; i++)
			{
				if(e.getSource() == jbArray[i])
				{
					for(int j = 0; j < 6; j++)
					{
						jbArray[randInt[j]].setText(String.valueOf(alist.get(j)));
						jbArray[randInt[j]].setBackground(Color.YELLOW);
						jbArray[randInt[j]].setForeground(Color.BLUE);
						jbArray[randInt[j]].setFont(new Font("Arial", Font.BOLD, 20));
					}
					
					jbArray[randInt[6]].setText(String.valueOf(alist.get(6)));
					jbArray[randInt[6]].setBackground(Color.GREEN);
					jbArray[randInt[6]].setForeground(Color.RED);
					jbArray[randInt[6]].setFont(new Font("Arial", Font.BOLD, 20));
					
					for(int j = 7; j < jbArray.length; j++)
					{
						jbArray[randomInt.get(j)].setText(String.valueOf(alist.get(j)));
					}
					
					int first = alist.get(6);
					
					for(int a = 0; a < 6; a++)
					{
						winner.add(alist.get(a));
					}
					
					Collections.sort(winner);
					
					String s = "["	 + String.valueOf(winner.get(0)) + 
								", " + String.valueOf(winner.get(1)) +
								", " + String.valueOf(winner.get(2)) +
								", " + String.valueOf(winner.get(3)) +
								", " + String.valueOf(winner.get(4)) +
								", " + String.valueOf(winner.get(5)) + "]"
								+ "\n" + "Top prize " + String.valueOf(first);
					
					Icon icon = new ImageIcon("10.jpg");
					JOptionPane.showMessageDialog(null, s, "Hope you enjoy the game", 
												JOptionPane.INFORMATION_MESSAGE, icon);
				}
			}
		}
	}
}

class GyuHyunLim_Assign3
{
	public static void main(String [] args)
	{
		LuckyBox lb = new LuckyBox();
		lb.setDefaultCloseOperation (JFrame.EXIT_ON_CLOSE);
		lb.setSize (200, 150);
		lb.setVisible (true);
	}
}