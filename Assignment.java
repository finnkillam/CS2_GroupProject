
public class Assignment {
	private String assignmentName;
	private double weight;
	private double grade;
	
	public Assignment(String n, double w, double g){
		assignmentName = n;
		weight = w;
		grade = g;
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
}
