import java.util.ArrayList;
import java.util.Collections;

public class Course
{
	private String courseName;
	private ArrayList<Student> students;

	public Course()
	{
		courseName = "";
		students = new ArrayList<Student>();
	}

	public Course(String courseName)
	{
		String course = courseName;
	}

	public void addStudent(String first, String last, int[] grades)
	{
		students.add(new Student(first,last,grades));

	}

	/** @return The class average... ie. the average of each student average */
	public double getClassAverage()
	{
		return 0;
	}

	/** Hint: Use the built in sort here */
	public void sortStudents()
	{

	}

	/** @return the output as shown */
	public String toString()
	{
		return "" + students;
	}
}