import java.util.ArrayList;

public class Student implements Comparable<Student>
{
	private String first, last;
	private ArrayList <Integer> grades;
	private double average;

	public Student()
	{
		first = last = "";
		average = 0;
		grades = new ArrayList<Integer>();
	}

	public Student(String first, String last, int[] arrGrades)
	{
		first = first;
		last = last;
		for(int i = 0; i < grades.size(); i++)
			grades.add(arrGrades[i]);
	}

	/**	@return the average for this student */
	public double getAverage()
	{
		return average;
	}

	/** @return the correct comparison of last name and first name
	*	Hint: check to see if the last names are the same
	*			if so -> compare first names
	*			otherwise compare last names
	*	Extra Hint: You don't need to re-invent the wheel here...
	*				The underlying data type is String
	*/
	public int compareTo(Student rhs)
	{
		return 0;
	}

	/** @return LastName, FirstName followed by the student's grades and their average
	*			with a tab in-between.
	*	Ex: Bunny, Bugs     Grades: [90, 88, 100, 100, 88]  Average: 93.2
	*/
	public String toString()
	{
		return first + ", " + last + "\t Grades: " + grades + "\t" + average;
	}
}

