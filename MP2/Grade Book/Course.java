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
		students.get(0).toString();

	}

	/** @return The class average... ie. the average of each student average */
	public double getClassAverage(int[] grades)
	{
		double average = 0;
		for(int i = 2; i < students.size(); i++)
			average = students.get(i).getAverage();
		return average;
		/*double average = 0;
		for(int i = 2; i < students.size(); i++)
		{
			average = average + grades[i];
		}
		average = average/grades.length-2;
		return average;*/
	}

	/** Hint: Use the built in sort here */
	public void sortStudents()
	{
		Collections.sort(students);
	}

	/** @return the output as shown */
	public String toString()
	{
		return "" + students;
	}
}