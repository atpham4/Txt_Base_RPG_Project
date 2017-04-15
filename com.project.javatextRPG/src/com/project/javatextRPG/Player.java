package com.project.javatextRPG;
import java.util.Random;

public class Player extends Actor{

	Player(String name, int hp, char symbol, int x, int y) {
		super(name, hp, symbol, x, y);
	}
	
	@Override
	public int generateRandomAttack() {
		Random rand = new Random();
		int PlayerAtt = rand.nextInt(30)+1;
		return PlayerAtt;
	}
}
