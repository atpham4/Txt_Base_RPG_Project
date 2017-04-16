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
		//1. Initialize SIZE and PLAYER_LOCATION
		SIZE = 9;
		PLAYER_LOCATION = 4;
		
		//2. Call initializeMap()
		initializeMap();

		int playerX = 4;
		int playerY = 4;

		//3. Call generateRandomLocation() for monsterX and monsterY
		int monsterX = generateRandomLocation();
		int monsterY = generateRandomLocation();
				
		//4. Ensure monster is not generated in the same location as player
		if( monsterX == PLAYER_LOCATION && monsterY == PLAYER_LOCATION)
		{
			monsterX = generateRandomLocation();
			monsterY = generateRandomLocation();			
		}

		Random rand = new Random();
		int monsterHP = rand.nextInt(100)+1;

		//5. Call Player, Monster, and Combat constructors
		player = new Player("Link", 100, 'P', playerX, playerY);
		monster = new Monster("Ganon", monsterHP, 'M', monsterX, monsterY);
		combat = new Combat();


		//6. Initialize 9x9 map of char
	}
	
	private void initializeMap()
	{
		//Initialize each cell of map to '-'
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
		//1. Call initializeMap()
		initializeMap();
		
		//2. Call assignActorLocation() for player and monster objects
		assignActorLocation(player);
		assignActorLocation(monster);
		
		//3. Print map to screen with a space between each element
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
		//1. Get actor x and y location
		int X = actor.getX();
		int Y = actor.getY();
		
		//2. Assign actor.getSymbol() to location on map
		char S = actor.getSymbol();
		
		map[Y][X] = S;
	}
	
	private int generateRandomLocation()
	{
		//1. Return random number within range of map edges
		Random rand = new Random();
		int Location = rand.nextInt(8)+0;
		return Location;

	}
	
	public void movePlayer(char move)
	{
		//1. Get player current location
		int CurrentX = player.getX();
		int CurrentY = player.getY();
		
		
		//2. Use switch statement to determine player new location or quit
		try
		{
			if (move == 'q')
				throw new Exception();

		}
		catch(Exception e)
		{
			System.out.println("Exit game");
			System.exit(0);
		}
		
		if(move == 'w')
			player.setY(CurrentY - 1); 
		else if (move == 's')
			player.setY(CurrentY + 1);
		else if (move == 'a')
			player.setX(CurrentX - 1);
		else if (move == 'd')
			player.setX(CurrentX + 1);

		CurrentX = player.getX();
		CurrentY = player.getY();

		//3. Call validCoordinates() to determine if player is at map edge
		validCoordinates(CurrentX, CurrentY);
		
		//4. If player EncountersMonster() call combat.initCombat()
		if (playerEncountersMonster())
			combat.initCombat(player, monster);
		
	}
	
	private boolean playerEncountersMonster()
	{
		//1. Return true if player location matches monster location
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
		//1. Return true if player location within range of map
		if(newX > 9 || newY > 9)
		{
			System.out.println("Error; Player cannot move outside of the map");
		}
			return true;
	}
	
	public int getPlayerHP()
	{
		return player.getHP();
	}

}
