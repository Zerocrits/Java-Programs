public class Player
{
	private int health, level;
	public Player(int h, int l)
	{
		health = h;
		level = l;
	}

	public String getAttack()
	{
		String attack = "Slash";

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