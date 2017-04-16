package com.project.javatextRPG;

public class Combat extends Map{
	
	Combat()
	{
		
	}

	public void initCombat(Player player, Monster monster)
	{
		//1.Prints each actor's name and HP
		System.out.println(player.getName() + "HP: " + player.getHP() + " | " + monster.getName() + "HP: " + monster.getHP());
		
		//2. Has an infinite loop 'while(true)' that calls attackSequence() for each actor
		while(player.getHP() > 0 || monster.getHP() > 0)
		{
			attackSequence(player, monster);
			attackSequence(monster, player);
		}
	}
	
	public void attackSequence(Actor attacker, Actor defender)
	{
		//1. Calls getDamage(attacker)
		int damage = getDamage(attacker);
		
		//2. Sets defender's HP to new value
		defender.setHP(defender.getHP() - damage);
		
		//3. Calls combatResults()
		combatResults(attacker, damage);
		
		//4. Prints defender's new HP
		System.out.println(defender.getName() + " HP: " + defender.getHP());
		
		//5. Calls checkDefeat(defender)
		checkDefeat(defender);
	}
	
	private void combatResults(Actor actor, int damage)
	{
		//1. Print actor's name and attack damage
		System.out.println(actor.getName() + " attacks with " + damage);
	}
	
	private int getDamage(Actor actor)
	{
		//1. Calls actor.generateRandomAttck()
		return actor.generateRandomAttack();
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
