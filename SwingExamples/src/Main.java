import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

public class Main 
{

	public static void main(String[] args) 
	{
		JFrame ramka = new JFrame();
		JButton przycisk = new JButton("Click");
		
		przycisk.setBounds(130, 100, 100, 40); //x, y, width, height
		
		ramka.add(przycisk);
		ramka.setSize(400, 500); //width, height
		ramka.setLayout(null);
		ramka.setVisible(true);
		
		przycisk.addActionListener(new ActionListener() //Button pressed action
				{
					@Override
					public void actionPerformed(ActionEvent e) 
					{
						System.out.print("a");
					}			
				});
	}
}