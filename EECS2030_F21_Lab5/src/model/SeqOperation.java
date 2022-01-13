package model;

public abstract class SeqOperation {
	protected int[] seq1;

	
	public SeqOperation(int[] seq1) {
		this.seq1 = seq1;
	}

	
	public abstract String toString();
	
}
