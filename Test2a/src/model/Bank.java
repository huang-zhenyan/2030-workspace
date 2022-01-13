package model;

public class Bank {
	// Attributes
	private Account[] accounts;
	private int NOA;
	// Constructors
	public Bank() {
		this.accounts = new Account[5];
		this.NOA = 0;
	}
	public Bank(Bank b) {
		this.accounts = b.getAccounts();
		this.NOA = b.getNOA();
	}
	// Accessors
	public Account[] getAccounts() {
		return this.accounts;
	}
	public int getNOA() {
		return this.NOA;
	}
	public int getNumberOfAccounts() {
		return this.NOA;
	}
	public Account[] getReferencesOfAccounts() {
		Account[] references = new Account[this.NOA];
		for (int i = 0; i < this.NOA; i ++) {
			references[i] = this.accounts[i];
		}
		return references;
	}
	public Account[] getCopiesOfAccounts() {
		Account[] copies = new Account[this.NOA];
		for (int i = 0; i < this.NOA; i ++) {
			copies[i] = new Account(this.accounts[i]);
		}
		return copies;
	}
	public boolean equals (Object obj) {
		if (this == obj) {
			return true;
		}
		if (obj == null || this.getClass() != obj.getClass()) {
			return false;
		}
		Bank other = (Bank) obj;
		boolean check = true;
		int k = 0;
		if (this.getNOA() != other.getNOA()) {
			return false;
		}
		else {
			while (check == true && k < this.NOA) {
				if (this.getAccounts()[k].equals(other.getAccounts()[k])) {
					check = true;
					k ++;
				}
				else {
					check = false;
				}
			}
			return check;
		}
	}
	// Mutators
	public void addAccount(Account a) {
		this.accounts[this.NOA] = a;
		this.NOA ++;
	}
	public void addAccounts(Account[] accounts) {
		for (int i = 0; i < accounts.length; i ++) {
			this.accounts[this.NOA] = accounts[i];
			this.NOA++;
		}
	}
}
