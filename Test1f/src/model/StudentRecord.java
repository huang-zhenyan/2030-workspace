package model;

public class StudentRecord {
	// Attributes
	public String courseName;
	public String status;
	public Assessment[] assessments;
	public int NOA;
	
	public StudentRecord(String name) {
		this.courseName = name;
		this.status = String.format("Number of assessments in EECS2030: %s []", this.NOA);
		this.assessments = new Assessment[10];
		this.NOA = 0;
	}
	
	// Accessor
	public String getCourse() {
		return this.courseName;
	}
	
	public String getAssessmentReport() {
		String s = String.format("Number of assessments in %s: %s [", this.courseName, this.NOA);
		for (int i = 0 ; i < this.NOA; i ++) {
			s += this.assessments[i].display();
			if (i < this.NOA - 1) {
				s += ", ";
			}
		}
		s += "]";
		this.status = s;
		
		return this.status;
	}
	
	public double getCompletionRate() {
		double completionRate = 0;
		
		for (int i = 0; i < this.NOA; i ++) {
			completionRate += this.assessments[i].getWeight();
		}
		
		return completionRate;
	}
	
	public double getRawMarks() {
		double rawMarks = 0;
		
		for (int i = 0; i < this.NOA; i ++) {
			rawMarks += (this.assessments[i].getMark() * this.assessments[i].getWeight());
		}
		
		return rawMarks;
	}
	
	// Mutator
	public void addAssessment(String courseName, double weight, int mark) {
		Assessment newAssessment = new Assessment(courseName, weight);
		newAssessment.setMarks(mark);
		
		this.assessments[this.NOA] = newAssessment;
		this.NOA ++;
	}
	
	public void addAssessment(Assessment assessment) {
		this.assessments[this.NOA] = assessment;
		this.NOA ++;
	}
	
	public void changeMarksOf(String courseName, int newMark) {
		for (int i = 0; i < this.NOA; i ++) {
			if (this.assessments[i].getCourseName().equals(courseName)) {
				this.assessments[i].setMarks(newMark);
			}
		}
	}
	
	public void removeAssessment(String courseName) {
		int index = -1;
		for (int i = 0; i < this.NOA; i ++) {
			if (this.assessments[i].getCourseName().equals(courseName)) {
				index = i;
			}
		}
		
		if (index != -1) {
			this.assessments[index] = null;
			for (int a = index; a < this.NOA; a ++) {
				this.assessments[a] = this.assessments[a+1]; 
			}
			this.NOA --;
		}	
	}
	
}









