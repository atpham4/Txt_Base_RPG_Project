package com.project.javatextRPG;

public class Map{
	private final int SIZE;
	private final int PLAY_LOCATION;
	private char[][] map;
	private final Player player;
	private final Monster monster;
	private final Combat combat;
	
	public Map()
	{
		
		//1. Initialize SIZE and PLAYER_LOCATION
		//2. Call initializeMap()
		//3. Call generateRandomLocation() for monsterX and monsterY
		//4. Ensure monster is not generated in the same location as player
		//5. Call Player, Monster, and Combat constructors
		//6. Initialize 9x9 map of char
		initializeMap();
	}
	
	private void initializeMap()
	{
		//Initialize each cell of map to '-'
		map = new char [9][9];
		for (int row = 0; row < 9; row++)
		{
			for (int col = 0; col < 9; col ++)
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
		Actor p = null;
		assignActorLocation(p);
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
		actor.getX();
		actor.getY();
		//2. Assign actor.getSymbol() to location on map
		actor.getSymbol();
	}
	
	private int generateRandomLocation()
	{
		//1. Return random number within range of map edges
		return PLAY_LOCATION;

	}
	
	public void movePlayer(char move)
	{
		//1. Get player current location
		//2. Use switch statement to determine player new location or quit
		//3. Call validCoordinates() to determine if player is at map edge
		//4. If player EncountersMonster() call combat.initCombat()
	}
	
	private boolean playerEncountersMonster()
	{
		//1. Return true if player location matches monster location
	}
	
	private boolean validCoordinates(int newX, int newY)
	{
		//1. Return true if player location within range of map
	}

	@Override
	int generateRandomAttack() {
		// TODO Auto-generated method stub
		return 0;
	}
}
