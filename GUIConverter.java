/**
 * Isaac, Eric
 * May 3rd, 2021
 * 
 * This program creates a GUI with three buttons. Button "Distance Converter" which makes
 * use of the DistanceConverter subclass, button "Temperature Converter" which makes use
 * of the TemperatureConverter subclass, and button "exit" which exits the program.
 * 
 */

import java.awt.BorderLayout;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JButton;
import java.awt.Dimension;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;


public class GUIConverter extends JFrame {
	
	//create JPanel to add JButtons to
	JPanel panel1 = new JPanel();
	
	//Create left button, right button, and bottom button
	JButton button1 = new JButton("Distance Converter");
	JButton button2 = new JButton("Temperature Converter");
	JButton button3 = new JButton("Exit");
	
	//Constructor
	public GUIConverter()
	{
		super("Welcome to Converter");
		
		//Set border layout for panel 1
		panel1.setLayout(new BorderLayout());
		
		//create dimensions for button1 and button2 and set the preferred size
		Dimension longer = new Dimension(300, 100);
		Dimension shorter = new Dimension(200,100);
		button1.setPreferredSize(longer);
		button2.setPreferredSize(shorter);
		
		//Add all the buttons to the panel in the specified region
		panel1.add(button1, BorderLayout.WEST);
		panel1.add(button2, BorderLayout.EAST);
		panel1.add(button3, BorderLayout.SOUTH);
		
		//add panel1 to the JFrame
		add(panel1);
		
		//Instantiate ButtonHandler object and,
		//add it as an ActionListner for all of the Buttons
		ButtonHandler handler = new ButtonHandler();
		button1.addActionListener(handler);
		button2.addActionListener(handler);
		button3.addActionListener(handler);
	}
	
	//private inner class to handle Buttons
	private class ButtonHandler implements ActionListener
	{
		@Override
		public void actionPerformed(ActionEvent event)
		{
			//If button1, "Distance Converter" is clicked
			if(event.getSource() == button1)
			{
				//Display an input dialog, and assign the input to the String "miles"
				String miles = JOptionPane.showInputDialog(button1, "Input miles distance to convert");
				
				//If miles is not a valid input...
				if(miles == null || miles == "" || miles.isEmpty() || miles.isBlank())
				{
					//Call the no argument DistanceConverter Constructor which sets the input to "NaN"
					//Display "NaN" in a message dialog
					DistanceConverter distance1 = new DistanceConverter();
					double newNan = distance1.getUserInput();
					String newNan2 = Double.toString(newNan);
					JOptionPane.showMessageDialog(button1, newNan2);
				}
				else
				{
					//Read in the valid input, call the one argument DistanceConverter constructor
					//calculate the conversion, and display the result in a message dialog
					double miles2 = Double.parseDouble(miles);
					DistanceConverter distance1 = new DistanceConverter(miles2);
					double kilometers = distance1.convert();
					String kilometers2 = Double.toString(kilometers);
					JOptionPane.showMessageDialog(button1, miles + " miles equals " + kilometers2 + " km");
				}
			}
			//If button2, "Temperature Converter" is clicked
			else if(event.getSource() == button2)
			{
				//Display an input dialog, and assign the user input to the String "fahrenheit"
				String fahrenheit = JOptionPane.showInputDialog(button2, "Input Fahrenheit temperature to convert");
				
				//If fahrenheit is an invalid String...
				if(fahrenheit == null || fahrenheit == "" || fahrenheit.isEmpty() || fahrenheit.isBlank())
				{
					//Call the no argument TemperatureConverter Constructor which sets the input to "NaN"
					//Display "NaN" in a message dialog
					TemperatureConverter temp1 = new TemperatureConverter();
					double newNan = temp1.getUserInput();
					String newNan2 = Double.toString(newNan);
					JOptionPane.showMessageDialog(button2, newNan2);
				}
				else
				{
					//Read in the valid input, call the one argument TemperatureConverter constructor
					//calculate the conversion, and display the result in a message dialog
					double fahrenheit2 = Double.parseDouble(fahrenheit);				
					TemperatureConverter temp1 = new TemperatureConverter(fahrenheit2);
					double celsius = temp1.convert();
					String celsius2 = Double.toString(celsius);	
					JOptionPane.showMessageDialog(button2, fahrenheit + " F equals " + celsius + " C");
				}
			}
			//else if button3, "Exit" is clicked. Terminate the program.
			else if(event.getSource() == button3)
				System.exit(1);
		}
	
	}
	
	//main method to begin program execution of GUIConverter
	public static void main(String[] args)
	{
		GUIConverter gui1 = new GUIConverter();
		gui1.setSize(500, 200);
		gui1.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		gui1.setVisible(true);
	}

}
