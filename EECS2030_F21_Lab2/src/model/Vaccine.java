package model;

public class Vaccine {
	//Attributes
	public String codename;
	public String type;
	public String manufacturer;
	public static final String[] recognizedvaccines  = {"mRNA-1273", "BNT162b2", "Ad26.COV2.S", "AZD1222"};
	
	
	//Constructors
	public Vaccine(String codename, String type, String manufacturer) {
		this.codename = codename;
		this.type = type;
		this.manufacturer = manufacturer;
	}
	
	
	//Accessors
	public String toString() {
		boolean recognized = false;
		String s = "";
		for (int i = 0; i < this.recognizedvaccines.length; i ++) {
			if (this.codename.equals(this.recognizedvaccines[i])) {
				recognized = true;
			}
		}
		if (recognized) {
			s = String.format("Recognized vaccine: %s (%s; %s)", this.codename, this.type, this.manufacturer);
		}
		else {
			s = String.format("Unrecognized vaccine: %s (%s; %s)", this.codename, this.type, this.manufacturer);
		}
		return s;
	}
	
	public String getCodename() {
		return this.codename;
	}
	
	public String getManufacturer() {
		return this.manufacturer;
	}
	
	//Mutators

	

}
