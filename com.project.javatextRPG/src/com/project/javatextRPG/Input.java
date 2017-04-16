package com.project.javatextRPG;
import java.util.Scanner;

public class Input {
	//Contains private Scanner member variable
	private Scanner input;
	
	public Input()
	{
		//1. Initializes Scanner object
		input = new Scanner(System.in);
	}
	
	public char readInput()
	{
		//1. Read only the first char from keyboard input
		char userInput = input.next().charAt(0); 

		//2. Loop to receive valid input-'while(!validInput(c))'
		while(!validInput(userInput))
		{
			input = new Scanner(System.in);;
			userInput = input.next().charAt(0); 
		}
		
		//3. Returns valid char input
		return userInput;
	}
	
	private boolean validInput(char input)
	{
		//1. Return boolean if input is/isn't valid
		if(input == 'w' || input == 'a' || input == 's' || input == 'd')
		{
			System.out.println();
			return true;
		}
		else
		{
			System.out.println("Entered invalid key");
			return false;
		}
			
	}
}
