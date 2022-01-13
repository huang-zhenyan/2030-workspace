package model;

public class Transcript {
	// Attributes
	public String name;
	public Registration[] registrations;
	public int NOT;
	
	// Constructors
	public Transcript(String name) {
		this.name = name;
		this.registrations = new Registration[60];
		this.NOT = 0;
	}
	
	// Accessors
	public String getStudentName() {
		return this.name;
	}
	
	public int getNumberOfRegistrations() {
		return this.NOT;
	}
	
	public Registration[] getReport() {
		Registration[] outputregistrations = new Registration[this.NOT];
		for (int i = 0; i < this.NOT; i ++) {
			outputregistrations[i] = this.registrations[i];
		}
		return outputregistrations;
	}
	
	public int getMarks(String courseName) {
		int marks = -1;
		for (int i = 0; i < this.NOT; i ++) {
			if (this.registrations[i].getCourseName().equals(courseName)) {
				marks = this.registrations[i].getMarks();
			}
		}
		return marks;
	}
	
	public double getWeightedGPA() {
		int total = 0;
		double weightedGPA = 0;
		if (this.NOT > 0) {
			for (int i = 0; i < this.NOT; i ++) {
				total += this.registrations[i].getWeightedGradePoint();
			}
			weightedGPA = (double) total/this.NOT;
		}

		return weightedGPA;
	}
	
	// Mutators
	public void addRegistration(Registration r) {
		this.registrations[this.NOT] = r;
		this.NOT ++;
	}
	
	public void addRegistration(String name, int credit) {
		Registration r = new Registration(name, credit);
		this.registrations[this.NOT] = r;
		this.NOT ++;
	}
	
	public void addRegistrations(Registration[] registrations) {
		for (int i = 0; i < registrations.length; i ++) {
			this.registrations[this.NOT] = registrations[i];
			this.NOT ++;
		}
	}
	
	public void setMarks(String courseName, int newMark) {
		for (int i = 0; i < this.NOT; i ++) {
			if (this.registrations[i].courseName.equals(courseName)) {
				this.registrations[i].setMarks(newMark);
			}
		}
	}
	
	
}
