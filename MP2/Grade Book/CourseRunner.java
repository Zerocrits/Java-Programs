// CourseRunner

public class CourseRunner
{
	public static void main(String[] args)
	{
		Course per4 = new Course("APCS");

		per4.addStudent("Bugs", "Bunny", new int[] {90,88,100,100,88} );
		per4.addStudent("Sylvester", "Cat", new int[] {45,23,62,99} );
		per4.addStudent("Taz", "Devil", new int[] {84,99,77,100} );
		per4.addStudent("Tweety", "Bird", new int[] {66,54,21,98,88} );

		System.out.println(per4);
	}
}