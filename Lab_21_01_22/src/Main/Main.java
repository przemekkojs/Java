package Main;

import Wielokaty.Wielokaty;

import java.util.Collections;

import javax.swing.*;
import javax.swing.border.Border;
import java.awt.Color;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import Figura.Figura;
import Figura.Prostokat;
import Figura.Trojkat;

public class Main 
{
	private static Wielokaty figury;
	
	private static JFrame frame;
	
	private static JPanel left;
	private static JPanel right;
	
	private static JButton add;
	private static JButton write;
	private static JButton sortByColor;
	private static JButton sortByA;
	private static JButton sort;
	private static JButton maxLength;
	
	private static JTextArea writeArea;
	private static JTextArea a;
	private static JTextArea b;
	private static JTextArea c;
	private static JTextArea color;
	
	private static JCheckBox triangle;
	
	private static Border blackline;
	
	public static void main(String[] args) 
	{
		Init();
		Listeners();
	}
	
	private static void Init()
	{
		figury = new Wielokaty();
		frame = new JFrame("Figury");
		
		left = new JPanel();
		right = new JPanel();
		
		add = new JButton("Dodaj");
		write = new JButton("Wypisz");
		sortByColor = new JButton("Sortuj kolorem");
		sortByA = new JButton("Sortuj a");
		sort = new JButton("Sortuj kolor -> a");
		maxLength = new JButton("Maks obwod");
		
		writeArea = new JTextArea();
		a = new JTextArea();
		b = new JTextArea();
		c = new JTextArea();
		color = new JTextArea();
		
		triangle = new JCheckBox();
		
		blackline = BorderFactory.createLineBorder(Color.BLACK);
		
		left.add(add);
		left.add(write);
		left.add(maxLength);		
		left.add(sortByColor);
		left.add(sortByA);
		left.add(sort);		
		
		right.add(new JLabel("Czy trojkat: "));
		right.add(triangle);
		right.add(new JLabel("Bok a: "));
		right.add(a);
		right.add(new JLabel("Bok b: "));
		right.add(b);
		right.add(new JLabel("Bok c: "));
		right.add(c);
		right.add(new JLabel("Kolor: "));
		right.add(color);
		right.add(new JLabel("Log: "));
		right.add(writeArea);
				
		writeArea.setBorder(blackline);
		a.setBorder(blackline);
		b.setBorder(blackline);
		c.setBorder(blackline);
		color.setBorder(blackline);
		
		left.setLayout(new GridLayout(0, 1));
		right.setLayout(new GridLayout(0, 2));
				
		frame.add(left);
		frame.add(new JPanel());
		frame.add(right);
		
		frame.getContentPane().setLayout(new BoxLayout(frame.getContentPane(), BoxLayout.X_AXIS));
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		frame.setSize(300, 200);
		frame.setVisible(true);
	}
	
	private static void Listeners()
	{
		add.addActionListener(new ActionListener() 
		{
			@Override
			public void actionPerformed(ActionEvent e) 
			{
				if(triangle.isSelected())
				{
					if(a.getText().length() == 0 || b.getText().length() == 0 || c.getText().length() == 0 || color.getText().length() == 0)
					{
						Add(new Trojkat());
					}
					else
					{						
						Add(new Trojkat(Integer.valueOf(a.getText()), Integer.valueOf(b.getText()), Integer.valueOf(c.getText()), color.getText()));
					}
				}
				else
				{
					if(a.getText().length() == 0 || b.getText().length() == 0 || color.getText().length() == 0)
					{
						Add(new Prostokat());
					}
					else
					{
						Add(new Prostokat(Integer.valueOf(a.getText()), Integer.valueOf(b.getText()), color.getText()));
					}
				}
			}			
		});	
		
		write.addActionListener(new ActionListener() 
		{
			@Override
			public void actionPerformed(ActionEvent e) 
			{
				writeArea.setText(Write());
			}			
		});
		
		sortByColor.addActionListener(new ActionListener() 
		{
			@Override
			public void actionPerformed(ActionEvent e) 
			{				
				SortByColor();
			}			
		});
		
		sortByA.addActionListener(new ActionListener() 
		{
			@Override
			public void actionPerformed(ActionEvent e) 
			{
				SortByA();
			}			
		});
		
		sort.addActionListener(new ActionListener() 
		{
			@Override
			public void actionPerformed(ActionEvent e) 
			{
				SortByAAndColor();
			}			
		});
		
		maxLength.addActionListener(new ActionListener() 
		{
			@Override
			public void actionPerformed(ActionEvent e) 
			{
				writeArea.setText(figury.najwiekszyObwod());
			}			
		});
	}
	
	private static void Add(Figura f)
	{		
		figury.GetFigury().add(f);
	}
	
	private static String Write()
	{
		String res = "";
		
		for(Figura f : figury.GetFigury())
		{
			res += f.toString() + "\n";
		}
		
		return res;
	}
	
	private static void SortByColor()
	{
		Collections.sort(figury.GetFigury(), figury.GetCompareKolor());
	}
	
	private static void SortByA()
	{
		Collections.sort(figury.GetFigury(), figury.GetCompareA());
	}
	
	private static void SortByAAndColor()
	{		
		Collections.sort(figury.GetFigury(), figury.GetCompareA());
		Collections.sort(figury.GetFigury(), figury.GetCompareKolor());
	}
}
