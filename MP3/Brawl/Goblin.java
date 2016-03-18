public class Goblin
{
	private int health, level;
	public Goblin(int h, int l)
	{
		health = h;
		level = l;
	}

	public String getAttack()
	{
		String attack = "Explosives";

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
		result += "\nAttack Used: " + getAttack();
		result += "\nGoblin's Level: " + getLevel();
		result += "\nGoblin's Health: " + getHealth();
		return result;
	}
}