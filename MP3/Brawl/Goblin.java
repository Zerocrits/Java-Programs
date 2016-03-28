public class Goblin extends Character
{
	private int health, level;
	public Goblin(int h, int l)
	{
		health = h;
		level = l;
	}

	public String getNameOfAttack()
	{
		int r = (int)(Math.random() * 3+1);
		String attack = "";

		switch(r)
		{
			case(1): attack = "";
			case(2): attack = "";
			case(3): attack = "";
			case(4): attack = "";
		}

		return attack;
	}

	public int getHealth()
	{
		return health;
	}

	public int getLevel()
	{
		return level;
	}

	public String displayCharacter()
	{
		String character = "";
		character +="             ,      , ";
		character +="\n            /(.-''-.)\\ ";
		character +="\n        |\\  \\/      \\/  /| ";
		character +="\n        | \\ \\/ =.  .= \\ / | ";
		character +="\n        \\( \\   o\\/o   / )/ ";
		character +="\n         \\_, '-/  \\-' ,_/ ";
		character +="\n           /   \\__/   \\ ";
		character +="\n           \\ \\__/\\__/ / ";
		character +="\n         ___\\ \\|--|/ /___ ";
		character +="\n       /`    \\      /    `\\ ";
        character +="\n      /       '----'       \\ ";

		return character;
	}

	public String toString()
	{
		String result = "";
		result += displayCharacter();
		result += "\nAttack Used: " + getNameOfAttack();
		result += "\nGoblin's Level: " + getLevel();
		result += "\nGoblin's Health: " + getHealth();
		return result;
	}
}