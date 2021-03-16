// Full Name: Gyu Hyun Lim
// File Name: GyuHyunLim_Lab_3.java
// UOW ID: 6573678
// Full Time
// T04
// Declaration: This program is done by myself

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.SwingConstants;
import javax.swing.JTextField;
import javax.swing.JOptionPane;
import java.awt.FlowLayout;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

class MyIntro extends JFrame
{
	
	private final Icon ic;
	private final JTextField txf1 = new JTextField("", 30);
	private final JTextField txf2 = new JTextField("", 30);
	private final JTextField txf3 = new JTextField("", 30);
	private final JTextField txf4;
	private final JTextField txf5;
	private final JLabel Name;
	private final JLabel DOB;
	private final JLabel Email;
	private final JLabel label1;
	private final JLabel label2;

	public MyIntro()
	{
		super ("Introduce to myself");
		setLayout (new FlowLayout ());
		
		Name = new JLabel("Name");
		txf1.setText("GyuHyun Lim");
		txf1.setEditable(false);
		add(Name);
		add(txf1);

		DOB = new JLabel("Date of Birth");
		txf2.setText("21 Feb 1992");
		txf2.setEditable(false);
		add(DOB);
		add(txf2);
		
		Email = new JLabel("Email");
		txf3.setText("ghl415@uow.edu.au");
		txf3.setEditable(false);
		add(Email);
		add(txf3);
		
		ic = new ImageIcon ("aa.gif");
		label1 = new JLabel ("", ic, SwingConstants.LEFT);
		label1.setToolTipText("I am GyuHyun Lim");
		add (label1);
		
		label2 = new JLabel("My comments to the subject "
								+ "will update further");
		add(label2);
		
		txf4 = new JTextField("121 is hard, hope Dr heng give me HD", 20);
		txf4.setEditable(true);
		add(txf4);
		
		txf5 = new JTextField("More example if possible", 20);
		txf5.setEditable(true);
		add(txf5);
		
		Secret s = new Secret();
		txf4.addActionListener(s);
		txf5.addActionListener(s);
	}
	
	private class Secret implements ActionListener
	{
		@Override
		public void actionPerformed(ActionEvent event)
		{
			String str = "";
			String s1 = "Summary of your changes" + "\n";
			
			if(event.getSource() == txf4)
			{
				str = "1. " + event.getActionCommand() + "\n" +
						"2. " + txf5.getText();
			}
			
			else if(event.getSource() == txf5)
			{
				str = "1. " + txf4.getText() + "\n" +
						"2. " + event.getActionCommand();
			}
			
			str = s1 + str;
			
			JOptionPane.showMessageDialog(null, str, "My " +
									"suggestion to the course",
									JOptionPane.WARNING_MESSAGE);
		}
	}
}

class GyuHyunLim_Lab_3
{
	public static void main (String [] args)
	{
		MyIntro my = new MyIntro ();
		my.setSize (400, 550);
		my.setDefaultCloseOperation (JFrame.EXIT_ON_CLOSE);
		my.setVisible (true);
	}
}