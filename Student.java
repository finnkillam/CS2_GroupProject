
public class Student extends Person implements Comparable {
	private String idNum;
	private double prereqGrade;

	public Student(String name, String id, double grade) {
		super(name);
		idNum = id;
		prereqGrade = grade;
	}
	
	@Override
	public int compareTo(Object comparestu) {
		if (this.getGrade()<((Student) comparestu).getGrade())
			return -1;
		else if (this.getGrade() > ((Student)comparestu).getGrade())
			return 1;
		else
			return 0;
	}

	public String getIdNum() {
		return idNum;
	}

	public void setIdNum(String idNum) {
		this.idNum = idNum;
	}

	public double getGrade() {
		return prereqGrade;
	}

	public void setGrade(double prereqGrade) {
		this.prereqGrade = prereqGrade;
	}
	public String getName() {
		return super.getName();
	}
	public void setName(String name) {
		super.setName(name);
	}
	
	public String toString () {
		return super.getName() + "(" + idNum + ") " + prereqGrade + "%";
	}

}
