package model;

import java.util.Arrays;

public class SumsOfPrefixes extends SeqOperation{

	public SumsOfPrefixes(int[] seq1) {
		super(seq1);
	}

	@Override
	public String toString() {
		String string = "";
		
		// get sum of prefixes
		String sumofprefixes = sumPrefixes(this.seq1);
		

		
		string = String.format("Sums of prefixes of %s is: %s", Arrays.toString(this.seq1), sumofprefixes);
		return string;
	}
	
	public String sumPrefixes(int[] seq1) {
		String sumofprefixes = "[0, ";
		int i = 0;
		while (i < seq1.length) {
			int sum = 0;
			for (int j = 0; j <= i; j ++) {
				sum += seq1[j];
			}
			sumofprefixes += sum;
			sumofprefixes += ", ";
			i ++;
		}
		sumofprefixes = sumofprefixes.substring(0, sumofprefixes.length()-2);
		sumofprefixes += "]";
		
		return sumofprefixes;
	}

}
