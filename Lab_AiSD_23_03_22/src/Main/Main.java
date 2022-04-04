package Main;

import Simulation.Simulation;
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Main 
{
	private static Simulation simulation;
	
	private static JFrame frame;
	
	private static JButton writeAll;
	private static JButton writeColor;
	private static JButton writeValue;
	private static JButton removeCovered;
	private static JButton showStats;
	
	private static JTextArea output;
	
	private static JTextField value;
	private static JTextField color;
	
	private static JPanel left;
	private static JPanel right;
	
	public static void main(String[] args) 
	{
		InitMenu();
		Init();
		
		writeAll.addActionListener(new ActionListener() 
		{
			@Override
			public void actionPerformed(ActionEvent e) 
			{
				output.setText(simulation.Write());
			}			
		});
		showStats.addActionListener(new ActionListener() 
		{
			@Override
			public void actionPerformed(ActionEvent e) 
			{
				output.setText(simulation.ShowInfo());
			}			
		});
		writeColor.addActionListener(new ActionListener() 
		{
			@Override
			public void actionPerformed(ActionEvent e) 
			{
				if(color.getText().length() > 0) output.setText(simulation.WriteColor(Integer.parseInt(color.getText())));
			}			
		});
		writeValue.addActionListener(new ActionListener() 
		{
			@Override
			public void actionPerformed(ActionEvent e) 
			{
				if(value.getText().length() > 0) output.setText(simulation.WriteValue(Integer.parseInt(value.getText())));
			}			
		});
		removeCovered.addActionListener(new ActionListener() 
		{
			@Override
			public void actionPerformed(ActionEvent e) 
			{
				simulation.RemoveCovered();
			}			
		});
	}
	
	private static void Init()
	{
		simulation = new Simulation();
		simulation.Init();
	}
	
	private static void InitMenu()
	{
		frame = new JFrame("Karty");
		frame.getContentPane().setLayout(new BoxLayout(frame.getContentPane(), BoxLayout.X_AXIS));
		
		left = new JPanel();
		right = new JPanel();		
		
		left.setLayout(new BoxLayout(left, BoxLayout.Y_AXIS));
		right.setLayout(new BoxLayout(right, BoxLayout.Y_AXIS));
		
		writeAll = new JButton("Wypisz wszystko");
		writeColor = new JButton("Wypisz o kolorze: ");
		writeValue = new JButton("Wypisz o wartoœci: ");
		removeCovered = new JButton("Usuñ zakryte");
		showStats = new JButton("Liczba odkrytych");
		
		output = new JTextArea();
		
		value = new JTextField();
		color = new JTextField();
		
		left.add(showStats);
		left.add(writeAll);
		left.add(removeCovered);
		left.add(writeColor);
		left.add(color);
		left.add(writeValue);
		left.add(value);
		
		right.add(output);
		
		frame.getContentPane().add(left);
		frame.getContentPane().add(right);
		
		frame.setSize(300, 300);
		frame.setVisible(true);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
}