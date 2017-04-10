import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;

public class Course {
	private String name;
	private ArrayList<Student> allStudents;
	private ArrayList<Group> allGroups;
	
	public Course(String cn){
		name = cn;
		allStudents = new ArrayList<Student>();
		allGroups = new ArrayList<Group>();
	}
	
	//method to import students from txt files
	public void importStudents(String stuFile, String numFile, String gradeFile) throws IOException {
		Scanner inStu = new Scanner (new File(stuFile));
		Scanner inNum = new Scanner (new File(numFile));
		Scanner inGrade = new Scanner (new File(gradeFile));
		
		while (inStu.hasNextLine())
			allStudents.add(new Student(inStu.nextLine(),inNum.nextLine(),inGrade.nextDouble()));

		inStu.close();
		inNum.close();
		inGrade.close();
	}
	
	//method to add one student
	public void addStudent(String name, String id, double grade) {
		for (int i = 0; i<allStudents.size(); i++) {
			if (!allStudents.get(i).getName().equalsIgnoreCase(name)&&!allStudents.get(i).getIdNum().equalsIgnoreCase(id)) 
				allStudents.add(new Student(name,id,grade));
			else
				System.out.println("Can't add duplicate student");
		}
	}
	
	//get-set below
	public int getSize() {
		return allStudents.size();
	}
	public int getNumGroups() {
		return allGroups.size();
	}
	public ArrayList<Student> getAllStudents() {
		return allStudents;
	}
	public void setAllStudents(ArrayList<Student> allStudents) {
		this.allStudents = allStudents;
	}
	public ArrayList<Group> getAllGroups() {
		return allGroups;
	}
	public void setAllGroups(ArrayList<Group> allGroups) {
		this.allGroups = allGroups;
	}
	public void setname(String c){
		name = c;
	}
	public String getname(){
		return name;
	}
}
