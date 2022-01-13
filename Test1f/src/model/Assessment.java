package model;

public class Assessment {
	// Attributes
	public String name;
	public double weight;
	public int mark;
	String status;
	
	// Constructor
	public Assessment(String name, double weight) {
		this.name = name;
		this.weight = weight;
		this.mark = 0;
		this.status = String.format("Assessment created: %s accounts for %s percents of the course.", this.name, String.format("%.3f", this.weight * 100));
	}
	
	// Accessors
	public String toString() {
		return this.status;
	}
	
	public double getWeight() {
		return this.weight;
	}
	
	public int getMark() {
		return this.mark;
	}
	
	public String getCourseName() {
		return this.name;
	}
	
	// Mutators
	public void setMarks(int mark) {
		int oldmark = this.mark;
		this.mark = mark;
		this.status = String.format("Marks of assessment %s (accounting for %s percents of the course) is changed from %s to %s.", this.name, String.format("%.3f", this.weight * 100), oldmark, this.mark );
	}
	
	public void setWeight(double weight) {
		double oldweight = this.weight;
		this.weight = weight;
		this.status = String.format("Weight of assessment %s (with marks %s) is changed from %s percents to %s percents.", this.name, this.mark, String.format("%.3f", oldweight * 100), String.format("%.3f", this.weight * 100));
	}
	
	public String display() {
		String s = "";
		s = String.format("%s (weight: %s percents; marks: %s)", this.name, String.format("%.3f", this.weight * 100), this.mark);
		return s;
	}
}
