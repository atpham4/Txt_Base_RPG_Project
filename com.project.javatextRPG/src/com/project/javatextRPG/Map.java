package com.project.javatextRPG;

import java.util.Random;

public class Map{
	private final int SIZE;
	private final int PLAYER_LOCATION;
	private char[][] map;
	private final Player player;
	private final Monster monster;
	private final Combat combat;
	
	public Map()
	{	
		//Initialize SIZE and PLAYER_LOCATION
		SIZE = 9;
		PLAYER_LOCATION = 4;
		
		initializeMap();

		int playerX = 4;
		int playerY = 4;

		//generate location for monsterX and monsterY
		int monsterX = generateRandomLocation();
		int monsterY = generateRandomLocation();
				
		//if statement to make sure that the monster is not generated in the same location as player
		if( monsterX == PLAYER_LOCATION && monsterY == PLAYER_LOCATION)
		{
			monsterX = generateRandomLocation();
			monsterY = generateRandomLocation();			
		}

		
		//generate monster's HP
		Random rand = new Random();
		int monsterHP = rand.nextInt(100)+1;

		//create player and monster
		player = new Player("Link", 100, 'P', playerX, playerY);
		monster = new Monster("Ganon", monsterHP, 'M', monsterX, monsterY);

		combat = new Combat();
	}
	
	private void initializeMap()
	{
		map = new char [SIZE][SIZE];
		for (int row = 0; row < SIZE; row++)
		{
			for (int col = 0; col < SIZE; col ++)
			{
				map[row][col] = '-';
			}
		}
	}
	
	public void drawMap()
	{
		initializeMap();
		
		// Assign location for player and monster objects
		assignActorLocation(player);
		assignActorLocation(monster);
		
		// Print map to screen
		for (int row = 0; row < 9; row++)
		{
			for (int col = 0; col < 9; col ++)
			{
				System.out.print(map[row][col]);
				System.out.print(" ");
			}
			System.out.print("\n");
		}
	}
	

	public void assignActorLocation(Actor actor)
	{
		int X = actor.getX();
		int Y = actor.getY();
		
		char S = actor.getSymbol();
		
		map[Y][X] = S;
	}
	
	private int generateRandomLocation()
	{
		Random rand = new Random();
		int Location = rand.nextInt(8)+0;
		return Location;

	}
	
	public void movePlayer(char move)
	{
		int CurrentX = player.getX();
		int CurrentY = player.getY();
		
		
		//Use switch statement to determine player new location or quit
		switch(move)
		{
			case 'q': System.out.println("Exit game");
						System.exit(0);
						break;
		
			case 'w': player.setY(CurrentY - 1); 
						break;
					
			case 's': player.setY(CurrentY + 1); 
						break;

			case 'a': player.setX(CurrentX - 1); 
						break;
			
			case 'd': player.setX(CurrentX + 1); 
						break;
		}
		
		CurrentX = player.getX();
		CurrentY = player.getY();

		//check to see if player is at map edge
		validCoordinates(CurrentX, CurrentY);
		
		CurrentX = player.getX();
		CurrentY = player.getY();

		//Initialize combat if player encounters monster
		if (playerEncountersMonster())
			combat.initCombat(player, monster);
		
	}
	
	private boolean playerEncountersMonster()
	{
		if (monster.getX() == player.getX() && monster.getY() == player.getY())
		{
			System.out.println(player.getName() + " encounters " + monster.getName());
			return true;
		}
		else
			return false;
	}
	
	private boolean validCoordinates(int newX, int newY)
	{
		if(newX > 8 || newY > 8 || newX < 0 || newY < 0)
		{
			if (newX > 8)
				newX = 8;
			else if (newY > 8)
				newY = 8;
			else if (newX < 0)
				newX = 0;
			else if (newY < 0)
				newY = 0;
		}
		
		player.setX(newX);
		player.setY(newY);
		
		return true;
	}
	
	public int getPlayerHP()
	{
		return player.getHP();
	}

}
