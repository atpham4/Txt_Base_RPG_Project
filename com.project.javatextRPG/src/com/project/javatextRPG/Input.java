package com.project.javatextRPG;
import java.util.Scanner;

public class Input {
	private Scanner input;
	
	public Input()
	{
		input = new Scanner(System.in);
	}
	
	public char readInput()
	{
		char userInput = input.next().charAt(0); 

		while(!validInput(userInput))
		{
			input = new Scanner(System.in);;
			userInput = input.next().charAt(0); 
		}
		
		return userInput;
	}
	
	private boolean validInput(char input)
	{
		if(input == 'w' || input == 'a' || input == 's' || input == 'd' || input == 'q')
		{
			System.out.println();
			return true;
		}
		else
		{
			System.out.println("Error: Entered invalid key");
			return false;
		}
			
	}
}
