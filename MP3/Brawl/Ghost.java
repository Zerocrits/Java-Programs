public class Ghost extends Character
{
	private int health, level;
	public Ghost(int h, int l)
	{
		health = h;
		level = l;
	}

	public String getNameOfAttack()
	{
		String attack = "Haunt";

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
		character += " .-.";
		character += "\n(o o)";
		character += "\n| O \\ ";
		character += "\n \\   \\ ";
  		character += "\n  `~~~`";

		return character;
	}

	public String toString()
	{
		String result = "";
		result += displayCharacter();
		result += "\nAttack Used: " + getNameOfAttack();
		result += "\nGhost's Level: " + getLevel();
		result += "\nGhost's Health: " + getHealth();
		return result;
	}
}