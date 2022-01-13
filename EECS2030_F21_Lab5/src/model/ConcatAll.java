package model;

public class ConcatAll extends SeqEvaluator{

	public ConcatAll(int n) {
		super(n);
	}
	
	public void addOperation(String operation, int[] seq1, int[] seq2) throws IllegalOperationException{
		if (operation.equals("op:projection")) {
			BinarySeqOperation binOp = new Projection(seq1, seq2);
			SeqOperation op = binOp;
			this.sequences[this.NOS] = ((Projection) op).project(seq1, seq2);
			this.NOS ++;
		}
		else if (operation.equals("op:sumsOfPrefixes")) {
			SeqOperation op = new SumsOfPrefixes(seq1);
			this.sequences[this.NOS] = ((SumsOfPrefixes) op).sumPrefixes(seq1);
			this.NOS ++;
		}
		else if (operation.equals("op:occursWithin")) {
			this.NOIC ++;
		}
		else {
			throw new IllegalOperationException("No such operation");
		}
		
	}
	
	public String toString() {
		if (this.NOIC > 0) {
			String string = String.format("Concat cannot be evaluated due to %s incompatile operations.", this.NOIC);
			return string;
		}
		else {
			String string = "Concat(";
			for (int i = 0; i < this.NOS; i++) {
				string += this.sequences[i];
				if (i < this.NOS - 1) {
					string += ", ";
				}
			}
			string += ") = ";
			
			// concatenate all sequences in array this.sequences
			string += "[";
			for (int i = 0; i < this.NOS; i ++) {
				String sequence = this.sequences[i];
				for (int j = 1; j < sequence.length() - 1; j ++) {
					string += sequence.charAt(j);
				}
				if (i < this.NOS - 1 && !(this.sequences[i + 1].equals("[]"))) {
					string += ", ";
				}
				
			}
			string += "]";
			
			
			return string;
		}
		
	}

}
