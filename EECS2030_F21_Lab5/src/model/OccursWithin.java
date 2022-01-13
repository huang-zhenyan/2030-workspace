package model;

import java.util.Arrays;

public class OccursWithin extends BinarySeqOperation{

	public OccursWithin(int[] seq1, int[] seq2) {
		super(seq1, seq2);
	}

	@Override
	public String toString() {
		String string = "";
		boolean occurswithin = occursHelper(seq1, seq2);
		if (occurswithin) {
			string = String.format("%s occurs within %s", Arrays.toString(seq1), Arrays.toString(seq2));
		}
		else {
			string = String.format("%s does not occur within %s", Arrays.toString(seq1), Arrays.toString(seq2));
		}
		return string;
	}
	
	public boolean occursHelper(int[] seq1, int[] seq2) {
		boolean found = true;
		for (int i = 0; i < seq2.length; i ++) {
			if (seq2[i] == seq1[0]) {
				found = true;
				for (int j = 0; j < seq1.length; j ++) {
					// if index out of seq2 or elements not equal then exit
					if (seq2.length <= i + j || seq1[j] != seq2[i + j]) {
						found = false;
					}
				}

				if (found) {
					return true;
				}
		}
		}
		return false;
	}
	

}
