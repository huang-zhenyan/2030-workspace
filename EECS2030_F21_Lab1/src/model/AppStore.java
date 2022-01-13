package model;

public class AppStore {
	// Attributes
	public String branchname;
	public App[] apps;
	public int noa;
	
	// Constructors
	
	public AppStore (String name, int appsallowed) {
		this.branchname = name;
		this.apps = new App[appsallowed];
		this.noa = 0;
	}
	
	// Accessors
	public int getnoa() {
		return this.noa;
	}
	
	public String getBranch() {
		return this.branchname;
	}
	
	public App getApp(String a) {
		App app = null;
		for (int i = 0; i < this.noa; i ++) {
			if (this.apps[i].getName() == a) {
				app = this.apps[i];
			}
		}
		return app;
	}
	
	public String[] getStableApps(int n) {
		int numberofstableapps = 0;
		for (int i = 0; i < this.noa; i ++) {
			if (this.apps[i].getUpdateHistory().length >= n) {
				numberofstableapps ++;
			}
		}
		
		String[] stableapps = new String[numberofstableapps];
		int counter = 0;
		
		for (int i = 0; i < this.noa; i ++) {
			if (this.apps[i].getUpdateHistory().length >= n) {
				App app = this.apps[i];
				
				String s = "";
				s = String.format("%s (%s versions; Current Version: %s)", app.name, app.getUpdateHistory().length, app.currentversion.toString());
				
				stableapps[counter] = s;
				counter++;
			}
		}
		
		
		
		return stableapps;
	}
	
	
	// Mutators
	
	public void addApp(App a) {
		this.apps[this.noa] = a;
		this.noa ++;
	}
	
	
}
