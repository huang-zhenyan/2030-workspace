package model;

public abstract class Student {
	protected String name;
	protected Course[] courses;
	private int NOC;
	protected double rate;
	
	public Student() {
		this.courses = new Course[100];
		this.NOC = 0;
	}
	
	public String getName() {
		return this.name;
	}
	
	public int getNOC() {
		return this.NOC;
	}
	
	public Course[] getCourses() {
		Course[] courses = new Course[this.NOC];
		for (int i = 0; i < this.NOC; i ++) {
			courses[i] = this.courses[i];
		}
		return courses;
	}
	
	public double getTuition() {
		double tuition = 0.0;
		if (this.NOC == 0) {
			return tuition;
		}
		else {
			for (int i = 0; i < this.NOC; i ++) {
				tuition += this.courses[i].getFee() * this.rate;
			}
			return tuition;
		}
	}
	
	public void register(Course course) {
		this.courses[NOC] = course;
		this.NOC ++;
	}
	
	public void drop(Course course) {
		int index = -1;
		for (int i = 0; i < this.NOC; i ++) {
			if (this.courses[i] == course) {
				index = i;
			}
		}
		
		if (index != -1) {
			for (int i = index; i < this.NOC; i ++) {
				this.courses[i] = this.courses[i + 1];
			}
			this.courses[this.NOC] = null;
			this.NOC --;
		}
	}
}
