package model;

public class App {
	public String name;
	public int[] ratings;
	public int nor;
	public Log[] updatelog = new Log[20];
	public int nol;
	public String averagerating = "n/a";
	public Log currentversion;
	
	// Constructors
	public App(String name, int nor) {
		this.name = name;
		this.ratings = new int[nor];
		this.nor = 0;
		this.updatelog = new Log[20];
		this.nol = 0;
		this.averagerating = "n/a";
		this.currentversion = null;
	}
	
	// Accessors
	public String getName() {
		return this.name;
	}
	
	public String getWhatIsNew() {
		String s = "";
		if (this.nol == 0) {
			s = "n/a";
		}
		else {
			s = this.updatelog[this.nol - 1].toString();
		}
		return s;
	}
	
	public Log[] getUpdateHistory() {
		Log[] updatehistory = new Log[this.nol];
		for (int i = 0; i < this.nol ; i ++) {
			updatehistory[i] = this.updatelog[i];
		}
		return updatehistory;
	}
	
	public Log getVersionInfo(String v) {
		Log log;
		log = null;
		for (int i = 0; i < this.nol; i ++) {
			if (this.updatelog[i].getVersion() == v) {
				log = this.updatelog[i];
			}
		}
		return log;
	}
	
	public String getRatingReport() {
		String s = "";
		if (this.nor == 0) {
			s = "No ratings submitted so far!";
		}
		else {
			int score1 = 0;
			int score2 = 0;
			int score3 = 0;
			int score4 = 0;
			int score5= 0;
			for (int i = 0; i < this.nor; i ++) {
				if (this.ratings[i] == 1) {
					score1 ++;
				}
				else if (this.ratings[i] == 2) {
					score2 ++;
				}
				else if (this.ratings[i] == 3) {
					score3 ++;
				}
				else if (this.ratings[i] == 4) {
					score4 ++;
				}
				else {
					score5 ++;
				}
			}
			s = "Average of " + this.nor + " ratings: " + this.averagerating + " (Score 5: " + score5 + ", Score 4: " + score4 + 
					", Score 3: " + score3 + ", Score 2: " + score2 + ", Score 1: " + score1 + ")";
		}
		return s;
	}
	
	public String toString() {
		if (this.currentversion == null) {
			String s = "";
			s = String.format("%s (Current Version: %s; Average Rating: %s)", this.name, "n/a", this.averagerating);
			return s;
		}
		else {
			String s = "";
			s = String.format("%s (Current Version: %s; Average Rating: %s)", this.name, this.currentversion.toString(), this.averagerating);
			return s;
		}
		
	}
	
	// Mutators
	
	public void releaseUpdate(String u) {
		Log update = new Log(u);
		this.updatelog[this.nol] = update;
		this.nol ++;
		this.currentversion = update;
	}
	
	public void submitRating(int r) {
		this.ratings[this.nor] = r;
		this.nor ++;
		double avgrating = 0;
		for (int i = 0; i < this.nor; i ++) {
			avgrating += this.ratings[i];
		}
		avgrating = avgrating / this.nor;
		String output = avgrating + "";
		output = String.format("%.1f", avgrating);
		this.averagerating = output;
	}
	
	
}

