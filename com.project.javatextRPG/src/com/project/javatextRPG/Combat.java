package com.project.javatextRPG;

public class Combat{
	
	Combat(){}

	public void initCombat(Player player, Monster monster)
	{
		System.out.println(player.getName() + " HP: " + player.getHP() + " | " + monster.getName() + " HP: " + monster.getHP());
		
		while(player.getHP() > 0 || monster.getHP() > 0)
		{
			attackSequence(player, monster);
			attackSequence(monster, player);
		}
	}
	
	public void attackSequence(Actor attacker, Actor defender)
	{
		int damage = getDamage(attacker);		
		defender.setHP(defender.getHP() - damage);
		combatResults(attacker, damage);		
		System.out.println(defender.getName() + " HP: " + defender.getHP());		
		checkDefeat(defender);
	}
	
	private void combatResults(Actor actor, int damage)
	{
		System.out.println(actor.getName() + " attacks with " + damage);
	}
	
	private int getDamage(Actor actor)
	{
		return actor.generateRandomAttack();
	}
	
	private void checkDefeat(Actor actor)
	{
		if (actor.getHP() < 1)
		{
			System.out.println("\nCombat is over!");
			System.out.println(actor.getName() + " is defeated! \n");
			System.exit(0);
		}
	}
}
