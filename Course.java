import java.util.ArrayList;
import java.util.LinkedList;
public class Course {
	private String courseName;
	private LinkedList <Student> allStudents;
	private LinkedList <Group> allGroups;
	
	
	public Course(String cn){
		courseName = cn;
		allStudents = new LinkedList();
		allGroups = new LinkedList();
	}
	public void setCourseName(String c){
		courseName = c;
	}
	public String getCourseName(){
		return courseName;
	}
	public void addCourse(Course c){
		//add's a course to the specified LinkedList/arraylist of Courses in the professor(manager) class.
	}
	public void addGroup(Group g){
		//add group to end of group linkedlist??? not sure if we need this one.
	}
	
	//public void fillCourse() method will take in a .txt file of student names and their ID numbers.
	
	//public void 
}
