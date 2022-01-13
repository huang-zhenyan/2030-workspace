package model;


public class Floor {
	// Attributes
	private int maxcapacity;
	private int utilizedcapacity;
	private Unit[] units;
	private int NOU;
	// Constructors
	public Floor(int maxcapacity) {
		this.maxcapacity = maxcapacity;
		this.utilizedcapacity = 0;
		this.units = new Unit[20];
		this.NOU = 0;
	}
	
	public Floor(Floor other) {
		this.maxcapacity = other.getMaxCapacity();
		this.utilizedcapacity = other.getUtilizedCapacity();
		this.units = other.getUnits();
		this.NOU = other.getNOU();
	}
	
	// Accessors
	public int getMaxCapacity() {
		return this.maxcapacity;
	}
	public int getUtilizedCapacity() {
		return this.utilizedcapacity;
	}
	public int getNOU() {
		return this.NOU;
	}
	public Unit[] getUnits() {
		return this.units;
	}
	public String toString() {
		String s = "";
		s = String.format("Floor's utilized space is %s sq ft (%s sq ft remaining): [", this.utilizedcapacity, this.maxcapacity);
		for (int i = 0; i < this.NOU; i ++) {
			s += String.format("%s: %s sq ft (%s' by %s')", this.units[i].getName(), String.format("%.0f", this.units[i].getSquareFeet()), String.format("%.0f", this.units[i].getWidth()), String.format("%.0f", this.units[i].getLength()));
			if (i < this.NOU - 1) {
				s += ", ";
			}
		}
		s += "]";
		return s;
	}
	public boolean equals (Object obj) {
		if (this == obj) {
			return true;
		}
		if (obj == null || this.getClass() != obj.getClass()) {
			return false;
		}
		Floor other = (Floor) obj;
		
		boolean equalsize = this.maxcapacity == other.maxcapacity;
		
		Unit[] floor1units = new Unit[this.NOU];
		for (int i = 0;  i < this.NOU; i ++) {
			floor1units[i] = this.units[i];
		}
		Unit[] floor2units = new Unit[other.getNOU()];
		for (int i = 0;  i < other.getNOU(); i ++) {
			floor2units[i] = other.getUnits()[i];
		}
		if (floor1units.length != floor2units.length) {
			return false;
		}
		// Now compare floor1units with floor2units, if two units are the same, remove them from both lists.
		for (int i = 0; i < floor1units.length; i ++) {
			for (int j = 0; j < floor2units.length; j ++) {
				if (floor1units[i] != null) {
					if (floor1units[i].equals(floor2units[j])) {
						floor1units[i] = null;
						floor2units[j] = null;
					}
				}
			}
		}
		// Now finally check if both lists are null, if yes they are equal
		boolean equalspace = true;
		int k = 0;
		while (equalspace && k < floor1units.length) {
			if (floor1units[k] != floor2units[k]) {
				equalspace = false;
				k ++;
			}
			else {
				k ++;
			}
		}
		
		return equalsize && equalspace;
		
	}
	// Mutators
	public void addUnit(String name, int width, int length) throws InsufficientFloorSpaceException {
		Unit u = new Unit(name, width, length);
		if (this.maxcapacity >= u.getSquareFeet()) {
			this.units[this.NOU] = u;
			this.NOU ++;
			this.maxcapacity -= u.getSquareFeet();
			this.utilizedcapacity += u.getSquareFeet();
		}
		else {
			throw new InsufficientFloorSpaceException("Not enough space.");
		}
		
	}
}
