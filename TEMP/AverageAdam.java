
public class AverageAdam extends Character
{
	public AverageAdam()
	{
		super(3,13);
	}

	/** @return a random attack from a list appropriate to the particular Character */
	public String getNameOfAttack()
	{
		int r = (int) (Math.random() * 4)+1;

		switch(r)
		{
			case 1 : return "Average Adam throws a punch!";
			case 2 : return "Average Adam kicks you!";
			case 3 : return "Average Adam pushes you!";
			case 4 : return "Average Adam calls in some friends!";
		}

		return "Attack Failed";
	}

	/**	@return a String with an ASCII picture of the particular Character */
	public String displayCharacter()
	{
		String result = "";
		result +="\n 	      ////^\\\\\\\\       ";
		result +="\n 	      | ^   ^ |       ";
		result +="\n 	     @ (o) (o) @      ";
		result +="\n 	      |   <   |       ";
		result +="\n 	      |  ___  |       ";
		result +="\n 	       \\_____/        ";
		result +="\n 	     ____|  |____     ";
		result +="\n 	    /    \\__/    \\    ";
		result +="\n 	   /              \\   ";
		result +="\n 	  /\\_/|        |\\_/\\  ";
		result +="\n 	 / /  |        |  \\ \\ ";
		result +="\n 	( <   |        |   > )";
		result +="\n 	 \\ \\  |        |  / / ";
		result +="\n 	  \\ \\ |________| / /  ";
		result +="\n 	   \\ \\|<I_D_I__|/ /   ";
		result +="\n 	    \\ \\ / I  \\ / /    ";
		result +="\n 	     \\ /  I   \\ /     ";
		result +="\n 	     |         |      ";
		result +="\n 	     |    |    |      ";
		result +="\n 	     |    |    |      ";
		result +="\n	     |    |    |      ";
		result +="\n 	     |    |    |      ";
		result +="\n 	     | ## | ## |      ";
		result +="\n 	     |    |    |      ";
		result +="\n 	     |    |    |      ";
		result +="\n 	     |____|____|      ";
		result +="\n 	     (____(____)      ";
		result +="\n 	      _| | _| |       ";
		result +="\n      cccC__Cccc___)      ";
		return result;
	}

	/** @return the level and health of this particular Character */
	public String toString()
	{
		return "AverageAdam Lv." + getLevel() + "\nHealth: " + getHealth();
	}
}