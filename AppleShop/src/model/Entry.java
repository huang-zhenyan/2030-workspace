package model;

/*
 * Template of a unit of storage in the Apple refurbished shop.
 * Think of a shop as a collection of entries
 */
public class Entry {
	private String serialNumber; // e.g F9FDN4NKQ1GC (unique)
	private Product product; // the type of attribute is a reference type, denoting an existing class
							// consequently, at runtime this attribute will store the address of some product object
	
	public Entry(String serialNumber, Product product) {
		this.serialNumber = serialNumber;
		this.product = product;
	}

	// Accessors
	
	public String getSerialNumber() {
		return serialNumber;
	}

	public Product getProduct() {
		return product;
	}

	// Mutators
	
	public void setSerialNumber(String serialNumber) {
		this.serialNumber = serialNumber;
	}

	public void setProduct(Product product) {
		this.product = product;
	}
	
	/*
	 * An overloaded version of the setProduct mutator
	 * This version of set product does not expect the user to create a Product object and pass it as an argument
	 * Instead, we would expect the user to pass a String model and a value of the original price
	 * (Internally, inside the method, it's expected that a local, new Product object is created accordingly)
	 */
	public void setProduct(String model, double originalPrice) {
		// this.product = new Product(model, originalPrice);
		Product p = new Product(model, originalPrice);
		this.product = p;
	}
	
	public String toString() {
		String s = " ";
		s = String.format("[%s] %s", this.serialNumber, this.product.toString());
		return s;
	}
	
	
}
