package model;

import static org.junit.Assert.assertThrows;


public class Account {
	// Attributes
	private String name;
	private int balance;
	private String status;
	private int deposit;
	// Constructors
	public Account(String name, int balance) {
		this.name = name;
		this.balance = balance;
		this.status = "regular";
		this.deposit = 0;
	}
	public Account(Account other) {
		this.name = other.getName();
		this.balance = other.getBalance();
		this.status = other.getStatus();
		this.deposit = other.getDeposit();
		
	}
	// Accessors
	public String getName() {
		return this.name;
	}
	public int getBalance() {
		return this.balance;
	}
	public String getStatus() {
		return this.status;
	}
	public int getDeposit() {
		return this.deposit;
	}
	public String toString() {
		String s = "";
		if (this.status.equals("regular")) {
			s = String.format("A %s account owned by %s with balance $%s", this.status, this.name, this.balance);
			return s;
		}
		else {
			s = String.format("A %s account owned by %s with balance $%s ($%s deposited for maintaining the VIP stauts)", this.status, this.name, this.balance, this.deposit);
		}
		return s;
	}
	public boolean equals (Object obj) {
		if (this == obj) {
			return true;
		}
		if (obj == null || this.getClass() != obj.getClass()) {
			return false;
		}
		Account other = (Account) obj;
		if (this.getName().equals(other.getName()) && this.balance == other.getBalance() && this.getStatus().equals(other.getStatus())) {
			return true;
		}
		else {
			return false;
		}
	}
	// Mutators
	public void switchToVIP(int deposit) throws InvalidStatusToSwitchException, InsufficientBalanceException {
		if (this.status.equals("VIP")) {
			throw new InvalidStatusToSwitchException("Already VIP");
		}
		else if ((this.balance - deposit) < 0) {
			throw new InsufficientBalanceException("Insufficient Balance");
		}
		else {
			this.deposit = deposit;
			this.balance -= deposit;
			this.status = "VIP";
		}
	}
	
	public void switchToRegular() throws InvalidStatusToSwitchException {
		if (this.status.equals("regular")) {
			throw new InvalidStatusToSwitchException("Already regular");
		}
		else {
			this.balance += this.deposit;
			this.deposit = 0;
			this.status = "regular";
		}
	}
}
