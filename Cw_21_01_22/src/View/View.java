package View;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;

public class View 
{
	private static JFrame frame;
	private static JButton button;
	private static JCheckBox check;
	private static JTextArea area;
	
	private static JPanel topPanel;
	private static JPanel bottomPanel;
	
	public View()
	{
		topPanel = new JPanel();
		bottomPanel = new JPanel();
		
		frame = new JFrame("Szybka aplikacja");
		button = new JButton("Zatwierdz");
		check = new JCheckBox();
		area = new JTextArea();
	}	
	
	public void Init()
	{
		topPanel.setLayout(new BoxLayout(topPanel, BoxLayout.X_AXIS));
		bottomPanel.setLayout(new BoxLayout(bottomPanel, BoxLayout.PAGE_AXIS));
		
		topPanel.add(new JLabel("Czy prawdziwy: "));
		topPanel.add(check);
		bottomPanel.add(area);
		bottomPanel.add(button);		
		
		frame.add(topPanel);
		frame.add(bottomPanel);
		
		frame.getContentPane().setLayout(new BoxLayout(frame.getContentPane(), BoxLayout.PAGE_AXIS));
		frame.setSize(300, 300);
		frame.setVisible(true);
	}
}