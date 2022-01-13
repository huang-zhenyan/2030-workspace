package model;

public class NonResidentStudent extends Student{
	
	public NonResidentStudent(String name) {
		this.name = name;
	}
	
	
	public double getDiscountRate() {
		return this.rate;
	}
	
	public void setDiscountRate(double rate) {
		this.rate = rate;
	}

	
}
