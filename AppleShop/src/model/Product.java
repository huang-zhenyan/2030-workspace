package model;

// Template for individual apple product in the refurbished store.
public class Product {
	// attributes (should be private so that they are only visible within the current class)
	// making attributes public will be visible to all classes
	// instead make a public accessor for this private attribute
	private String model; // ex: iPad Pro 12.9
	private String finish; // ex: Silver, Space Grey
	private int storage; // in the unit of GB, ex, 256, 512, 1000 (1TB)
	private boolean hasCellularConnectivity; // eg., false (only wifi), true (wifi + cellular)
	private double originalPrice; // eg 1789.00
	private double discountValue; // eg, 200.00
	
	
	// constructors
	
	/*
	 * IMPORTANT
	 */
	// if no constructor are declared here, an implicit default constructor is available
	// advice: if you really find the default constructor useful, define one explicitly, 
	// otherwise as soon as any addition constructor are added, the implicit one becomes unavailable 
	/*
	 * IMPORTANT
	 */
	public Product() {
		// do nothing: all attributes will store their default values after an object is created.
	}
	
	// an overloaded version of the constructor
	public Product(String model, double originalPrice) {
		this.model = model;
		this.originalPrice = originalPrice;
	}
	
	
	
	// accessors
	public String getModel() {
		return this.model;
	}
	
	public String getFinish() {
		return finish;
	}
	
	public int getStorage() {
		return storage;
	}
	
	public boolean hasCellularConnectivity() {
		return hasCellularConnectivity;
	}
	
	public double getOriginalPrice() {
		return originalPrice;
	}
	
	public double getDiscountValue() {
		return discountValue;
	}
	
	public double getPrice() {
		// local variable declarations
		double price = 0.0;
		
		
		// computation
		price = this.originalPrice - this.discountValue;
		
		// return 
		return price;
	}
	
	public String toString() {
		String s = "";
		
//		StringBuilder sb = new StringBuilder();
//		sb.append(model + " " + finish + " " + storage + "GB "
//				+ "(cellular connectivity: " + hasCellularConnectivity + "): $("
//				+ String.format("%.2f", originalPrice) + " - " + String.format("%.2f", discountValue) + ")");
//		
//		s = sb.toString();
		
		
		
//		s += model + " " + finish + " " + storage + "GB "
//				+ "(cellular connectivity: " + hasCellularConnectivity + "): $("
//				+ String.format("%.2f", originalPrice) + " - " + String.format("%.2f", discountValue) + ")";
		
		
		s = String.format("%s %s %dGB (cellular connectivity: %s): $(%.2f - %.2f)",
				this.model, this.finish, this.storage, this.hasCellularConnectivity, this.originalPrice, this.discountValue);
		
		return s;
	}
	
	
	// mutators
	public void setModel(String model) {
		this.model = model;
	}

	public void setFinish(String finish) {
		this.finish = finish;
	}

	public void setStorage(int storage) {
		this.storage = storage;
	}

	public void setHasCellularConnectivity(boolean hasCellularConnectivity) {
		this.hasCellularConnectivity = hasCellularConnectivity;
	}

	public void setOriginalPrice(double originalPrice) {
		this.originalPrice = originalPrice;
	}

	public void setDiscountValue(double discountValue) {
		this.discountValue = discountValue;
	}
	

}
