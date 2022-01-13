package model;

public class Course {
	// Attributes
	private String name;
	private double fee;
	
	// Constructor
	public Course(String name, double fee) {
		this.name = name;
		this.fee = fee;
	}
	
	// Accessors
	public double getFee() {
		return this.fee;
	}
}
