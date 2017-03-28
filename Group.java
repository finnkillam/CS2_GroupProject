import java.util.ArrayList;
public class Group {
	private String groupName;
	private ArrayList<Student> students;
	private ArrayList<Assignment> assignments;
	
	public Group(String gn){
		groupName = gn;
		students = new ArrayList<Student>();
		assignments = new ArrayList<Assignment>();
	}
	
	public void addStudent(Student s){
		students.add(s);
	}
	
	public void addAssignment(Assignment a){
		assignments.add(a);
	}
	
	//public double calculateMark(){
		//this method will calculate marks by taking assignment grades from the assignment arraylist
		
	//}
}
