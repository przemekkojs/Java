package Game;

import java.awt.BorderLayout;
import java.awt.*;

import javax.swing.*;

import Map.Map;
import Player.Player;
import Processors.ArrayProcessor;
import Processors.Constants;
import Processors.Logger;

public class UI 
{
	private static JFrame frame;
	
	private static JTextArea gameArea;
	private static JTextArea logArea;
	private static JTextField controlField;
	
	private static JScrollPane scroll;
	
	private static JPanel logPanel;
	private static JPanel gamePanel;
	private static JPanel controlsPanel;
	
	public static void InitializeFrame()
	{
		frame = new JFrame("Game");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);		
		frame.setSize(500, 500);
		frame.setResizable(false);
	
		frame.getContentPane().add(BorderLayout.NORTH, controlsPanel);
		frame.getContentPane().add(BorderLayout.CENTER, gamePanel);
		frame.getContentPane().add(BorderLayout.SOUTH, logPanel);
		
		frame.setVisible(true);		
		
		frame.addWindowListener(new java.awt.event.WindowAdapter() {
            @Override
            public void windowClosing(java.awt.event.WindowEvent windowEvent) 
            {
                Logger.Log(String.format("%s%n", Constants.GAME_EXIT));
                Pause.SaveGame();
            }
        });
	}
	
	public static void InitializeControls(Player player, Map map)
	{
		controlField = new JTextField(1);
		controlField.setText("");
	}
	
	public static void InitializeGameArea()
	{		
		gameArea = new JTextArea();		
		
		Font font = new Font(Constants.UI_FONT, Font.BOLD, Constants.UI_FONT_SIZE);
		gameArea.setFont(font);
	}
	
	public static void InitializeLogArea()
	{
		logArea = new JTextArea();
		scroll = new JScrollPane (logArea);		
		
		logArea.setEditable(false);
		scroll.setAutoscrolls(true);			    
		
		scroll.setVerticalScrollBarPolicy (ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);		
	}
	
	public static void InitializePanels()
	{
		logPanel = new JPanel();
		gamePanel = new JPanel();
		controlsPanel = new JPanel();		
		
		controlsPanel.add(new JLabel("Controls"));	
		controlsPanel.add(controlField);
		controlsPanel.setLayout(new BoxLayout(controlsPanel, BoxLayout.X_AXIS));
		controlsPanel.setBorder(BorderFactory.createLineBorder(null));
		controlsPanel.setBounds(0,0,500,25);
		
		gamePanel.add(new JLabel("Game"));		
		gamePanel.add(gameArea);			
		gamePanel.setLayout(new BoxLayout(gamePanel, BoxLayout.Y_AXIS));
		gamePanel.setBorder(BorderFactory.createLineBorder(null));
		gamePanel.setBounds(25,30,450,300);
		
		logPanel.add(new JLabel("Logs"));	
		logPanel.add(logArea);		
		logPanel.setLayout(new BoxLayout(logPanel, BoxLayout.Y_AXIS));
		logPanel.setBorder(BorderFactory.createLineBorder(null));
		logPanel.setBounds(0,485,500,25);
	}
	
	public static void Log(String text)
	{
		logArea.setText(String.format("%s%s", logArea.getText(), text));
	}
	
	public static void Display(char[][] scene)
	{			
		System.out.print(ArrayProcessor.CharArrayToString(scene));
		gameArea.setText(String.format("%s", ArrayProcessor.CharArrayToString(scene)));
	}
	
	public static String GetControls()
	{		
		String res = controlField.getText();
		controlField.setText("");
		return res;		
	}
}
