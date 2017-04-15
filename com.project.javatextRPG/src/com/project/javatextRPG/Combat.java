package com.project.javatextRPG;

public class Combat {

	public Combat()
	{}
	
	public void initCombat(Player player, Monster monster)
	{
		//1.Prints each actor's name and HP
		//2. Has an infinite loop 'while(true)' that calls attackSequence() for each actor
	}
	
	public void attackSequence(Actor attacker, Actor defender)
	{
		//1. Calls getDamage(attacker)
		//2. Sets defender's HP to new value
		//3. Calls combatResults()
		//4. Prints defender's new HP
		//5. Calls checkDefeat(defender)
	}
	
	private void combatResults(Actor actor, int damage)
	{
		//1. Print actor's name and attack damage
	}
	
	private int getDamage(Actor actor)
	{
		//1. Calls actor.generateRandomAttck()
	}
	
	private void checkDefeat(Actor actor)
	{
		//Code given on two of this document
		if (actor.getHP() < 1)
		{
			System.out.println("\nCombatisover!");
			System.out.println(actor.getName() + " is defeated! \n");
			System.exit(0);
		}
	}
}
