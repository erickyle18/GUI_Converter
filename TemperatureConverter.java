/**
 * 
 * Isaac, Eric
 * May 3rd, 2021
 * 
 * This program is a subclass  of Converter. TemperatureConverter accepts a temperature
 * in fahrenheit and converts it to a temperature in celsius.
 * 
 */

import java.util.Scanner;

public class TemperatureConverter extends Converter {
	
	static Scanner input = new Scanner(System.in);
	
	//Instance variables to hold the celsius
	private double celsius;
	
	
	//Constructor to call no argument parent constructor
	public TemperatureConverter()
	{
		super();
	}
	
	//Constructor to call one argument parent constructor
	public TemperatureConverter(Double userInput)
	{
		super(userInput);
	}
	
	//Override the superclass Convert method
	@Override
	public Double convert()
	{
		celsius = ((super.convert() - 32)*5)/9;
		return celsius;
	}
	
}
