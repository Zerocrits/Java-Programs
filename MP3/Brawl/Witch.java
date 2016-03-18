public class Witch
{
	private int health, level;
	public Witch(int h, int l)
	{
		health = h;
		level = l;
	}

	public String getAttack()
	{
		String attack = "Curse";

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
		result += "\nWitch's Level: " + getLevel();
		result += "\nWitch's Health: " + getHealth();
		return result;
	}
}