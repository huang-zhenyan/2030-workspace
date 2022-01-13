package model;


public class VaccinationSite {
	// Attributes
	public String name;
	public int limitondoses;
	public int NOD;
	public VaccineDistribution[] vaccinedistrubtions;
	public int NOVD;
	public HealthRecord[] appointments;
	public int NOA;
	
	
	// Constructor
	public VaccinationSite(String name, int limitondoses) {
		this.name = name;
		this.limitondoses = limitondoses;
		this.NOD = 0;
		this.vaccinedistrubtions = new VaccineDistribution[Vaccine.recognizedvaccines.length];
		this.NOA = 0;
		this.appointments = new HealthRecord[200];
	}
	
	// Accessors
	public String toString() {
		String s = "";
		s = String.format("%s has %s available doses: <", this.name, this.NOD);
		
		for (int i = 0; i < this.NOVD; i ++) {
			s += String.format("%s doses of %s", this.vaccinedistrubtions[i].getDoses(), this.vaccinedistrubtions[i].getVaccine().getManufacturer());
			if (i < (this.NOVD - 1)) {
				s += ", ";
			}
		}
		
		s += ">";
		return s;
	}
	
	public int getNumberOfAvailableDoses() {
		return this.NOD;
	}
	
	public int getNumberOfAvailableDoses(String codename) {
		int availibledoses = 0;
		for (int i = 0; i < this.NOVD; i ++) {
			if (this.vaccinedistrubtions[i].getVaccine().getCodename() == codename) {
				availibledoses = this.vaccinedistrubtions[i].getDoses();
			}
		}
		return availibledoses;
	}
	
	
	// Mutators
	public void addDistribution(Vaccine vaccine, int doses) throws UnrecognizedVaccineCodeNameException, TooMuchDistributionException {
		boolean found = false;
		int index = 0;
		// Find if vaccine in vaccine distribution
		for (int i = 0; i < this.NOVD; i ++) {
			if (this.vaccinedistrubtions[i].getVaccine() == vaccine) {
				found = true;
				index = i;
			}
		}
		
		// if vaccine found, add dose to that vaccine
		if (found) {
			this.vaccinedistrubtions[index].addDistribution(doses);
			
			// check if total vaccine exceeds 10
			if ((this.NOD + doses) > 10) {
				throw new TooMuchDistributionException("Too Much Distribution");
			}
			else {
				this.NOD += doses;
			}
			
		}
		// else
		else {
			// find if vaccine is recognized
			boolean recognizedvaccine = false;
			for (int i = 0; i < Vaccine.recognizedvaccines.length; i ++) {
				if (Vaccine.recognizedvaccines[i].equals(vaccine.codename)) {
					recognizedvaccine = true;
				}
			}
			if (recognizedvaccine) {
				
				
				// check if total vaccines exceeds 10
				if ((this.NOD + doses) > 10) {
					throw new TooMuchDistributionException("Too Much Distribution");
				}
				else {
					this.vaccinedistrubtions[this.NOVD] = new VaccineDistribution(vaccine, doses);
					this.NOD += doses;
					this.NOVD++;
				}
				
				
			}
			else {
				throw new UnrecognizedVaccineCodeNameException("Error: Unrecognized Vaccine");
			}
		}
	}
	
	
	public void bookAppointment(HealthRecord name) throws InsufficientVaccineDosesException {
		if (this.NOD - this.NOA > 0) {
			String s = "";
			s = String.format("Last vaccination appointment for %s with %s succeeded", name.name, this.name);
			name.updateAppointmentStatus(s);
			this.appointments[this.NOA] = name;
			this.NOA++;
		}
		else {
			String s = "";
			s = String.format("Last vaccination appointment for %s with %s failed", name.name, this.name);
			name.updateAppointmentStatus(s);
			throw new InsufficientVaccineDosesException("Not enough doses");
		}
	}
	
	
	public void administer(String date) {
		int appointment = 0;
		for (int i = 0; i < this.NOVD; i ++) {
			while (this.vaccinedistrubtions[i].doses > 0 && this.appointments[appointment] != null) {
				this.appointments[appointment].addRecord(this.vaccinedistrubtions[i].getVaccine(), this.name, date);
				this.vaccinedistrubtions[i].doses--;
				this.NOD--;
				appointment ++;
			}
		}
		
		// Clear appointments
		for (int i = 0; i < this.NOA; i ++) {
			this.appointments[i] = null;
		}
		this.NOA = 0;
	}
	
	
}
