package model;

public class RegistrationSystem {
	// Attributes
	private Transcript[] transcript;
	private int NOT;
	
	// Constructors
	public RegistrationSystem() {
		this.transcript = new Transcript[500];
		this.NOT = 0;
	}
	
	// Accesors
	public Transcript[] getReport() {
		Transcript[] outputTranscripts = new Transcript[this.NOT];
		for (int i = 0; i < this.NOT; i ++) {
			outputTranscripts[i] = this.transcript[i];
		}
		return outputTranscripts;
	}
	
	public int getMarks(String studentName, String courseName) {
		int marks = -1;
		
		for (int i = 0; i < this.NOT; i ++) {
			if (this.transcript[i].getStudentName().equals(studentName)) {
				Registration[] registrations = this.transcript[i].getReport();
				for (int r = 0; r < registrations.length; r ++) {
					if (registrations[r].getCourseName().equals(courseName)) {
						marks = registrations[r].getMarks();
					}
				}
			}
		}
		
		return marks;
	}
	
	// Mutator
	public void addTranscript(Transcript t) {
		this.transcript[this.NOT] = t;
		this.NOT ++;
	}
	
}
