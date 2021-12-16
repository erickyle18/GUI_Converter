/**
 * Isaac, Eric
 * May 3rd, 2021
 * 
 * This program is a subclass of Converter. DistanceConverter accepts a 
 * distance in miles and converts it to kilometers.
 * 
 */

import java.util.Scanner;

public class DistanceConverter extends Converter {
	
	static Scanner input = new Scanner(System.in);
	
	//Instance variables to hold the kilometers
	private Double kilometers;
	
	//Constructor to call no argument parent constructor
	public DistanceConverter()
	{
		super();
	}
	
	//Constructor to call one argument parent constructor
	public DistanceConverter(Double userInput)
	{
		super(userInput);
	}
	
	//Overridden convert method to convert miles to kilometers
	@Override
	public Double convert()
	{
		kilometers = super.convert() * 1.609;
		return kilometers;
	}
	
}
