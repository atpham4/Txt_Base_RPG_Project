package com.project.javatextRPG;

public class RPG {

	public static void main(String[] args)
	{
		Map map = new Map();
		Input in = new Input();
		map.drawMap();
		
		while (map.getPlayerHP() > 0 )
		{
			System.out.println("up: w | down: s | left: a | right: d | quit: q");
			System.out.print("move: ");
			map.movePlayer(in.readInput());
			map.drawMap();
		}
	}

}
