package com.project.javatextRPG;

public class RPG {

	public static void main(String[] args)
	{
		Map map = new Map();
		Input in = new Input();
		map.drawMap();
		
		while (map.getPlayerHP() > 0 )
		{
			map.movePlayer(in.readInput());
			map.drawMap();
		}
		
		System.out.println("GAME OVER");
	}

}
