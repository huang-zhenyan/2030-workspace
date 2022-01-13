package model;

public class VaccineDistribution {
	// Attributes
	public Vaccine vaccine;
	public int doses;
	
	// Constructors
	public VaccineDistribution(Vaccine vaccine, int doses) {
		this.vaccine = vaccine;
		this.doses = doses;
	}
	
	// Accessors
	public Vaccine getVaccine() {
		return this.vaccine;
	}
	
	public int getDoses() {
		return this.doses;
	}
	
	public String toString() {
		String s = "";
		s = String.format("%s doses of %s by %s", this.doses, this.vaccine.codename, this.vaccine.manufacturer);
		return s;
	}
	
	// Mutators
	public void addDistribution(int num) {
		this.doses += num;
	}
}
