public class Vampire extends Character
{
	private int health, level;
	public Vampire(int h, int l)
	{
		health = h;
		level = l;
	}

	public String getNameOfAttack()
	{
		String attack = "Blood Suck";

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
		result += "\nAttack Used: " + getNameOfAttack();
		result += "\nVampire's Level: " + getLevel();
		result += "\nVampire's Health: " + getHealth();
		return result;
	}
}