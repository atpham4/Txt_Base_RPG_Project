package com.project.javatextRPG;

import java.util.Random;

public class Monster extends Actor{
	@Override
	public int generateRandomAttack() {
		Random rand = new Random();
		int MonsterAtt = rand.nextInt(30)+1;
		return MonsterAtt;
	}

	Monster(){}
	
	Monster(String name, int hp, char symbol, int x, int y) {
		super(name, hp, symbol, x, y);
	}
	
}
