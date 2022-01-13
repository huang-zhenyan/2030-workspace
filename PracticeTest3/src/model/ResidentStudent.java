package model;

public class ResidentStudent extends Student{
	
	public ResidentStudent(String name) {
		this.name = name;
	}

	public double getPremiumRate() {
		return this.rate;
	}
	
	public void setPremiumRate(double rate) {
		this.rate = rate;
	}


	
	
	
	
}
