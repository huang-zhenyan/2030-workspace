package model;

public class Blueprint {
	// Attributes
	private Floor[] floors;
	private int NOF;
	// Constructors
	public Blueprint(int number) {
		this.floors = new Floor[number];
		this.NOF = 0;
	}
	public Blueprint(Blueprint other) {
		Floor[] newfloors = new Floor[other.getFloorsList().length];
		for (int i = 0; i < other.getNOF(); i ++) {
				newfloors[i] = new Floor(other.getFloorsList()[i]);		
		}
		this.floors = newfloors;
		this.NOF = other.getNOF();
	}
	// Accessors
	public int getNOF() {
		return this.NOF;
	}
	public Floor[] getFloorsList() {
		return this.floors;
	}
	public String toString() {
		String s = "";
		double percentage = ((float) this.getNOF()/ this.getFloorsList().length) * 100;
		s = String.format("%s percents of building blueprint completed (%s out of 7 floors)", String.format("%.1f", percentage), this.NOF);
		return s;
	}
	public Floor[] getFloors() {
		Floor[] floorplans = new Floor[this.NOF];
		for (int i = 0; i < this.NOF; i ++) {
			Floor nf = new Floor(this.floors[i]);
			floorplans[i] = nf;
		}
		return floorplans;
	}
	// Mutators
	public void addFloorPlan(Floor f) {
		this.floors[this.NOF] = f;
		this.NOF ++;
	}

}
