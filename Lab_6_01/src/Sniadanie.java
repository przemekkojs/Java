import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Sniadanie 
{
	private static JFrame frame;
	
	private static JPanel left;
	private static JPanel right;
	
	private static JCheckBox croissant;
	private static JCheckBox butter;
	private static JCheckBox jam;
	private static JCheckBox coffee;
	
	private static JTextArea info;
	private static JTextArea cost;
	
	private static JButton accept;
	
	private static JLabel infoLabel;
	private static JLabel costLabel;
	
	private static int overallCost = 0;
	
	private static String costText;
	private static String infoText;
	
	public static void main(String[] args)
	{
		Initialize();
		Start();
		
		accept.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) 
			{
				Accept();
			} 			
		});	
	}
	
	private static void Accept()
	{
		overallCost = 0;
		infoText = "";
		
		if(croissant.isSelected()) 
		{
			overallCost += 2;
			infoText += "Rogal, ";
		}
		
		if(butter.isSelected())
		{
			overallCost += 1;
			infoText += "Mas³o, ";
		}
		
		if(jam.isSelected())
		{
			overallCost += 1;
			infoText += "D¿em, ";
		}
		
		if(coffee.isSelected())
		{
			overallCost += 2;
			infoText += "Kawa, ";
		}
		
		costText = String.format("Koszt: %d", overallCost);
		
		cost.setText(costText);
		info.setText(infoText);
	}
	
	private static void Initialize()
	{
		frame = new JFrame("Œniadanie");
		
		left = new JPanel();
		right = new JPanel();
		
		croissant = new JCheckBox("Rogal - 2z³");
		butter = new JCheckBox("Mas³o - 1z³");
		jam = new JCheckBox("D¿em - 1z³");
		coffee = new JCheckBox("Kawa - 2z³");
	
		accept = new JButton("Akceptuj");
		
		info = new JTextArea();
		cost = new JTextArea();
		
		infoLabel = new JLabel("Twoje Œniadanie: ");
		costLabel = new JLabel("Koszt: ");
		
		left.add(croissant);
		left.add(butter);
		left.add(jam);
		left.add(coffee);
		left.add(accept);
		
		right.add(infoLabel);
		right.add(info);
		right.add(costLabel);
		right.add(cost);
		
		left.setBorder(BorderFactory.createTitledBorder("Wybierz:"));
		left.setLayout(new BoxLayout(left, BoxLayout.Y_AXIS));
		
		right.setBorder(BorderFactory.createTitledBorder("Info:"));
		right.setLayout(new BoxLayout(right, BoxLayout.Y_AXIS));
	}
	
	private static void Start()
	{
		frame.add(left, BorderLayout.WEST);
		frame.add(right, BorderLayout.EAST);
		
		frame.setSize(300, 200);
		frame.setVisible(true);
		frame.setDefaultCloseOperation(3);
	}
}