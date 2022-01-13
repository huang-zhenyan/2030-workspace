package model;

public class HealthRecord {
	// Attributes
	public String name;
	public int limitofdoses;
	public Record[] records;
	public int NOR;
	public String appointmentstatus;
	
	
	// Constructors
	public HealthRecord(String name, int limitofdoses) {
		this.name = name;
		this.limitofdoses = limitofdoses;
		this.records = new Record[this.limitofdoses];
		this.NOR = 0;
		this.appointmentstatus = String.format("No vaccination appointment for Alan yet", this.name);
	}
	
	// Accessors
	public String getAppointmentStatus() {
		String s = this.appointmentstatus;
		return s;
	}
	
	public String getVaccinationReceipt() {
		if (this.NOR > 0) {
			String s = "";
			s = String.format("Number of doses %s has received: %s [", this.name, this.NOR);
			for (int i = 0; i < this.NOR; i ++) {
				 s += String.format("%s in %s on %s", this.records[i].vaccine.toString(), this.records[i].vaccinationsite, this.records[i].date);
				 if (i < (this.NOR - 1)) {
					 s += "; ";
				 }
			}
			s += "]";
			return s;
		}
		else {
			String s = "";
			s = String.format("%s has not yet received any doses.", this.name);
			return s;
		}
		
	}
	
	
	// Mutators
	public void addRecord(Vaccine v1, String vaccinationsite, String date) {
		Record newrecord = new Record(v1, vaccinationsite, date);
		this.records[this.NOR] = newrecord;
		this.NOR ++;
	}
	
	public void updateAppointmentStatus(String s) {
		this.appointmentstatus = s;
	}
	
	
}
