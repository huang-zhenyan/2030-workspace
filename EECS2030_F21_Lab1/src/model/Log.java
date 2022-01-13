package model;

public class Log {
	// Attributes
	private String version;
	private String[] fixes = new String[10];
	private int nof = 0;
	
	// Constructors
	public Log() {
		// Do nothing
	}
	
	public Log(String v) {
		this.version = v;
		this.fixes = new String[10];
		this.nof = 0;
	}
	
	
	// Accessors
	public String getVersion() {
		return this.version;
	}
	
	public int getNumberOfFixes() {
		return this.nof;
	}
	
	public String getFixes() {
		String listoffixes = "[";
		for (int i = 0; i < this.nof ; i ++ ) {
			if (i < (this.nof - 1)) {
				listoffixes += this.fixes[i] + ", ";
			}
			else {
				listoffixes += this.fixes[i];
			}
		}
		listoffixes += "]";
		return listoffixes;
	}
	
	public String toString() {
		String s = " ";
		s = String.format("Version %s contains %d fixes %s", this.version, this.nof, this.getFixes());
		return s;
	}
	
	
	// Mutators
	public void addFix(String f) {
		this.fixes[this.nof] = f;
		this.nof ++;
	}
	
}


