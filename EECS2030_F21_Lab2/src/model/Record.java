package model;

public class Record {
	// Attributes
	public Vaccine vaccine;
	public String vaccinationsite;
	public String date;
	
	// Constructor
	public Record(Vaccine vaccine, String vaccinationsite, String date) {
		this.vaccine = vaccine;
		this.vaccinationsite = vaccinationsite;
		this.date = date;
	}
}
