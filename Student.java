
public class Student extends Person {
	private String idNum;
	private double prereqGrade;

	public Student(String name, String id, double grade) {
		super(name);
		idNum = id;
		prereqGrade = grade;
	}

	public String getIdNum() {
		return idNum;
	}

	public void setIdNum(String idNum) {
		this.idNum = idNum;
	}

	public double getPrereqGrade() {
		return prereqGrade;
	}

	public void setPrereqGrade(double prereqGrade) {
		this.prereqGrade = prereqGrade;
	}

	

}
