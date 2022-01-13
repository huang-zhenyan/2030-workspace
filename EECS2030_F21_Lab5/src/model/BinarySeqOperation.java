package model;

public abstract class BinarySeqOperation extends SeqOperation{
	protected int[] seq2;

	public BinarySeqOperation(int[] seq1, int[] seq2) {
		super(seq1);
		this.seq2 = seq2;
	}
	
}
