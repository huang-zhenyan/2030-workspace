package model;

public class SeqEvaluator {
	protected SeqOperation[] operations;
	protected int NOIC;
	protected String[] sequences;
	protected int NOS;
	
	public SeqEvaluator(int n) {
		this.sequences = new String[n];
		this.NOIC = 0;
		this.NOS = 0;
	}
	
	public void addOperation(String operation, int[] seq1, int[] seq2) throws IllegalOperationException {
	}
}
