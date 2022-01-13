package model;

public class Registration {
	// Attributes
	public String courseName;
	public int numCredit;
	public int rawMarks = 0;
	
	// Constructors
	public Registration(String courseName, int numCredit, int rawMarks) {
		this.courseName = courseName;
		this.numCredit = numCredit;
		this.rawMarks = rawMarks;
	}
	
	public Registration(String courseName, int numCredit) {
		this.courseName = courseName;
		this.numCredit = numCredit;
		this.rawMarks = 0;
	}
	
	// Accessor
	public String getCourseName() {
		return this.courseName;
	}
	
	public int getNumberOfCredits() {
		return this.numCredit;
	}
	
	public int getMarks() {
		return this.rawMarks;
	}
	
	public String getLetterGrade() {
		String letter = "";
		if (this.rawMarks >= 90) {
			letter = "A+";
		}
		else if (this.rawMarks >= 80) {
			letter = "A";
		}
		else if (this.rawMarks >= 70) {
			letter = "B";
		}
		else if (this.rawMarks >= 60) {
			letter = "C";
		}
		else if (this.rawMarks >= 50) {
			letter = "D";
		}
		else {
			letter = "F";
		}
		
		return letter;
	}
	
	public int getWeightedGradePoint() {
		int gradePoint = 0;
		String grade = this.getLetterGrade();
		
		if (grade.equals("A+")) {
			gradePoint = 9;
		}
		else if (grade.equals("A")) {
			gradePoint = 8;
		}
		else if (grade.equals("B")) {
			gradePoint = 7;
		}
		else if (grade.equals("C")) {
			gradePoint = 6;
		}
		else if (grade.equals("D")) {
			gradePoint = 5;
		}
		
		int weightedGradePoint = gradePoint * this.numCredit;
		
		return weightedGradePoint;
	}
	
	
	// Mutator
	
	public void setMarks(int newMark) {
		this.rawMarks = newMark;
	}
	
	
	
}


