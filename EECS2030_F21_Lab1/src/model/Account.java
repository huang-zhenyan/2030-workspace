package model;

public class Account {
	// Attributes
	public String name;
	public AppStore store;
	public String status;
	public App[] downloadedapps;
	public int noda;
	
	// Constructors
	public Account(String name, AppStore store) {
		this.name = name;
		this.store = store;
		this.status = String.format("An account linked to the %s store is created for %s.", store.getBranch(), this.name);
		this.noda = 0;
		this.downloadedapps = new App[50];
	}
	
	// Accessors
	public String toString() {
		return this.status;
	}
	
	public String[] getNamesOfDownloadedApps() {
		String[] apps = new String[noda];
		for (int i = 0; i < noda; i ++) {
			apps[i] = downloadedapps[i].getName();
		}
		return apps;
	}
	
	public App[] getObjectsOfDownloadedApps() {
		App[] apps = new App[noda];
		for (int i = 0; i < noda; i ++) {
			apps[i] = downloadedapps[i];
		}
		return apps;
	}
	
	// Mutators
	public void uninstall(String appname) {
		boolean found = false;
		int index = 0;
		for (int i = 0; i < this.noda; i ++) {
			if (this.downloadedapps[i].name == appname) {
				found = true;
				index = i;
			}
		}
		if (found) {
			for (int i = index; i < this.noda; i ++) {
				this.downloadedapps[i] = this.downloadedapps[i+1];
			}
			this.downloadedapps[this.noda-1] = null;
			this.noda = this.noda - 1;
			this.status = String.format("%s is successfully uninstalled for %s.", appname, this.name);
		}
		else {
			this.status = String.format("Error: %s has not been downloaded for %s.", appname, this.name );
		}
	}
		
	public void submitRating(String appname, int rating) {
		boolean found = false;
		for (int i = 0; i < this.noda; i ++) {
			if (this.downloadedapps[i].name == appname) {
				found = true;
			}
		}
		if (found) {
			this.store.getApp(appname).submitRating(rating);
			this.status = String.format("Rating score %d of %s is successfully submitted for %s.", rating, this.name, appname);
		}
		else {
			this.status = String.format("Error: %s is not a downloaded app for %s.", appname, this.name );
		}
	}
	
	public void switchStore (AppStore store) {
		this.store = store;
		this.status = String.format("Account for %s is now linked to the %s store.", this.name, store.branchname);
	}
	
	public void download (String name) {
		boolean found = false;
		for (int i = 0; i < this.noda; i ++) {
			if (this.downloadedapps[i].getName() == name) {
				found = true;
			}
		}
		
		if (found) {
			this.status = String.format("Error: %s has already been downloaded for %s.", name, this.name);
		}
		else {
			for (int i = 0; i < this.store.getnoa(); i ++) {
				if (this.store.apps[i].getName() == name) {
					this.downloadedapps[this.noda] = this.store.apps[i];
					this.noda ++;
					this.status = String.format("%s is successfully downloaded for %s.", name, this.name);
				}
			}
		}
		
	}
	
	
	
	
	}
	
	
	
	
	

