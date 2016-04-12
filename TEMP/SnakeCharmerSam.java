//Madison Miatke
//SnakeCharmerSam
//Extend Character upepr level chracter to fight

public class SnakeCharmerSam extends Character
{
	public SnakeCharmerSam()
	{
		super(5,16);
	}
	/** @return a random attack from a list appropriate to the particular Character */
	public String getNameOfAttack()
	{
		int r = (int) (Math.random() * 4)+1;

		switch(r)
		{
			case 1 : return "Snake Charmer Sam makes his snake attack you!";
			case 2 : return "Snake Charmer Sam plays a deafening note!";
			case 3 : return "Snake Charmer Sam hits you with his flute!";
			case 4 : return "Snake Charmer Sam calls in an army of snakes!";
		}

		return "Attack Failed";
	}

	/**	@return a String with an ASCII picture of the particular Character */
	public String displayCharacter()
	{
		String result = "";

		result +="\n        ___                                                    ";
		result +="\n      ,'._,`.                                                  ";
		result +="\n     (-.___.-)                                                 ";
		result +="\n     (-.___.-)                                                 ";
		result +="\n     `-.___.-'                                                 ";
		result +="\n      ((  @ @|              .            __                    ";
		result +="\n       \\   ` |         ,\\   |`.    @|   |  |      _.-._        ";
		result +="\n      __`.`=-=mm===mm:: |   | |`.   |   |  |    ,'=` '=`\\      ";
		result +="\n     (    `-'|:/  /:/  `/  @| | |   |, @| @|   /---)W(---\\     ";
		result +="\n      \\ \\   / /  / /         @| |   '         (----| |----) ,~ ";
		result +="\n      |\\ \\ / /| / /            @|              \\---| |---/  |  ";
		result +="\n      | \\ V /||/ /                              `.-| |-,'   |  ";
		result +="\n      |  `-' |V /                                 \\| |/    @'  ";
		result +="\n      |    , |-'                                 __| |__       ";
		result +="\n      |    .;: _,-.                         ,--''..| |..''--.  ";
		result +="\n      ;;:::' '    )                        (`--::__|_|__::--') ";
		result +="\n    ,-'     _ ,  /                          \\`--...___...--'/  ";
		result +="\n   (    -:--'/  /                           /`--...___...--'\\  ";
		result +="\n    '-._  `''._/                           /`---...___...---'\\ ";
		result +="\n        '-._   '---.                      (`---....___....---')";
		result +="\n         .' ',._ ,' )                     |`---....___....---'|";
		result +="\n         /`._|  `|  |                     (`---....___....---')";
		result +="\n        (   \\    |  /                      \\`---...___...---'/ ";
		result +="\n         `.  `,  ^''                        `:--...___...--;'  ";
		result +="\n           `.,'                               `-._______.-'      ";

		return result;
	}

	/** @return the level and health of this particular Character */
	public String toString()
	{
		return "Snake Charmer Sam Lv." + getLevel() + "\nHealth: " + getHealth();
	}
}