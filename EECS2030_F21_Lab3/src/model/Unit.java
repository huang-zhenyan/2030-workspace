package model;

public class Unit {
	// Attributes
	private String name;
	private double width;
	private double length;
	private double squaredfeet;
	boolean feet;
	// Constructors
	public Unit(String name, int width, int length) {
		this.name = name;
		this.width = width;
		this.length = length;
		this.squaredfeet = width*length;
		this.feet = true;
	}
	// Accessors
	public String getName() {
		return this.name;
	}
	public double getWidth() {
		return this.width;
	}
	public double getLength() {
		return this.length;
	}
	public double getSquareFeet() {
		return this.squaredfeet;
	}
	public boolean getFeet() {
		return this.feet;
	}
	public String toString() {
		if (this.feet == true) {
			String s = "";
			s = String.format("A unit of %s square feet (%s' wide and %s' long) functioning as %s", String.format("%.0f", this.squaredfeet), String.format("%.0f", this.width), String.format("%.0f", this.length), this.name);
			return s;
		}
		else {
			String s = "";
			s = String.format("A unit of %s square meters (%s m wide and %s m long) functioning as %s", String.format("%.2f", this.squaredfeet), String.format("%.2f", this.width), String.format("%.2f", this.length), this.name);
			return s;
		}	
	}
	public boolean equals (Object obj) {
		if (this == obj) {
			return true;
		}
		if (obj == null || this.getClass() != obj.getClass()) {
			return false;
		}
		Unit other = (Unit) obj;
		boolean check = false;
		if (this.feet != other.feet) {
			this.toogleMeasurement();
			check = this.squaredfeet == other.squaredfeet && this.getName() == other.getName();
			this.toogleMeasurement();
		}
		else {
			check = this.squaredfeet == other.squaredfeet && this.getName() == other.getName();
		}
		return check;
		
	}
	// Mutators
	public void toogleMeasurement() {
		if (this.feet == true) {
			this.width = this.width * 0.3048;
			this.length = this.length * 0.3048;
			this.squaredfeet = this.width * this.length;
			this.feet = false;
		}
		else {
			this.width = this.width * 3.28;
			this.length = this.length * 3.28;
			this.squaredfeet = this.width * this.length;
			this.feet = true;
		}
	}
	
	
	
}
