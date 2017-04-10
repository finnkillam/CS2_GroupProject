import java.util.ArrayList;
public class Group {
	private String groupName;
	private ArrayList<Student> students;
	
	public Group(String gn){
		groupName = gn;
		students = new ArrayList<Student>();
	}
	
	public void addStudent(Student s){
		if (students.isEmpty()) {
			students.add(s);
		}
		else {	
			if (!students.contains(s)) {
				students.add(s);
				System.out.println("Student Added");
			}
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

	
	public String getGroupName(){
		return groupName;
	}
	public void setGroupName(String gn){
		groupName = gn;
	}
	
	public ArrayList<Student> getStudents() {
		return students;
	}

	public void setStudents(ArrayList<Student> students) {
		this.students = students;
	}

	public String toString(){
		return groupName + students;
	}
}
