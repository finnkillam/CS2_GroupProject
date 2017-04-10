import java.util.ArrayList;
public class Group {
	private String groupName;
	private ArrayList<Student> students;
	private LinkedList assignments;
	
	public Group(String gn){
		groupName = gn;
		students = new ArrayList<Student>();
		assignments = new LinkedList();
	}
	
	public void addStudent(Student s){
		for (int i = 0; i<students.size(); i++) {
			if (!students.get(i).getName().equalsIgnoreCase(s.getName())&&!students.get(i).getIdNum().equalsIgnoreCase(s.getIdNum())) 
				students.add(s);
			else
				System.out.println("Can't add duplicate student");
		}
	}
	public void removeStudent(String name) {
		for (int i = 0; i<students.size(); i++) {
			if (students.get(i).getName().equalsIgnoreCase(name)) 
				students.remove(i);
			else
				System.out.println("Student not found.");
		}
	}
	
	public void addAssignment(Assignment a){
		assignments.addToEnd(a);
	}
	
	public void removeAssignment(String name) {
		if (assignments.containsName(name)!=-1)
			assignments.remove(assignments.containsName(name));
		else
			System.out.println("Sorry we could not find that Assignment");
	}

	public double calculateMark(){
		double mark = 0;
		int count;
		for (count = 0; count < assignments.size(); count++)
			mark += assignments.get(count).getGrade();
		return (double)mark/count;
	}
	
	public String getGroupName(){
		return groupName;
	}
	public void setGroupName(String gn){
		groupName = gn;
	}
	
	public String toString(){
		return groupName;
	}
}
