package model;

import java.util.Arrays;

public class Projection extends BinarySeqOperation {

	public Projection(int[] seq1, int[] seq2) {
		super(seq1, seq2);
	}

	@Override
	public String toString() {
		String string = "";
		
		// project seq1 onto seq2
		String projected = project(this.seq1, this.seq2);
		
		
		string += String.format("Projecting %s to %s results in: %s", Arrays.toString(seq1), Arrays.toString(seq2), projected);
		
		return string;
	}

	public String project(int[] seq1, int[] seq2) {		
		// project seq1 onto seq2	
		String projected = "[";
		for (int i = 0; i < this.seq2.length; i ++) {
			boolean found = false;
			for (int j = 0; j < this.seq1.length; j ++) {
				if (this.seq2[i] == this.seq1[j]) {
					found = true;
				}
			}
			if (found) {
				projected += this.seq2[i];
				projected += ", ";
			}
		}
		if (projected.length() > 2) {
			projected = projected.substring(0, projected.length()-2);
		}
		projected += "]";
		
		return projected;
	}
}
