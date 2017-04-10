import java.util.ArrayList;

public class Manager {
	private ArrayList<Course> courses;
	private Prof prof;
	
	public Manager(Prof prof) {
		this.prof = prof;
	}
	
	public void addCourse (Course course) {
		courses.add(course);
	}

	public Prof getProf() {
		return prof;
	}

	public void setProf(Prof prof) {
		this.prof = prof;
	}

	public ArrayList<Course> getCourses() {
		return courses;
	}

	public void setCourses(ArrayList<Course> courses) {
		this.courses = courses;
	}
	
	

}
