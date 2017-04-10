
public class Assignment {
	private String name;
	private double weight;
	private double grade;
	private boolean complete;
	
	public Assignment(String n, double w, double g){
		name = n;
		weight = w;
		grade = g;
		complete = false;
	}
	
	public String getName() {
		return name;
	}

	public void setName(String assignmentName) {
		this.name = assignmentName;
	}

	public double getWeight(){
		return weight;
	}
	public double getGrade(){
		return grade;
	}
	public void setWeight(double w){
		weight = w;
	}
	public void setGrade(double g){
		grade = g;
	}

	public boolean getComplete() {
		return complete;
	}

	public void setComplete(boolean complete) {
		this.complete = complete;
	}
	
}
