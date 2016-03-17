public class Vampire
{
	private int health, level;
	public Vampire(int h, int l)
	{
		health = h;
		level = l;
	}

	public String getAttack()
	{
		String attack = "move here";

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


		return character;
	}

	public String toString()
	{
		String result = "";
		result += displayCharacter();
		result += "\nAttack Used: " + getAttack();
		result += "\n(insert name here)'s Level: " + getLevel();
		result += "\n(insert name here)'s Health: " + getHealth();
		return result;
	}
}