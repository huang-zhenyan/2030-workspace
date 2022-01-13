package model;

public class FilterAll extends SeqEvaluator{
	protected String[] occurswithin;
	private int NOO;

	public FilterAll(int n) {
		super(n);
		this.occurswithin = new String[n];
		this.NOO = 0;
	}
	
	public void addOperation(String operation, int[] seq1, int[] seq2) throws IllegalOperationException{
		if (operation.equals("op:projection")) {
			this.NOIC ++;
		}
		else if (operation.equals("op:sumsOfPrefixes")) {
			this.NOIC ++;
		}
		else if (operation.equals("op:occursWithin")) {
			BinarySeqOperation binOp = new OccursWithin(seq1, seq2);
			SeqOperation op = binOp;
			boolean occurs = ((OccursWithin) op).occursHelper(seq1, seq2);
			if (occurs) {
				this.occurswithin[this.NOO] = "true";
				this.NOO ++;
			}
			else {
				this.occurswithin[this.NOO] = "_";
				this.NOO ++;
			}
		}
		else {
			throw new IllegalOperationException("No such operation");
		}
	}
	
	public String toString() {
		if (this.NOIC > 0) {
			String string = String.format("Filter cannot be evaluated due to %s incompatile operations.", this.NOIC);
			return string;
		}
		else {
			String string = "Filter result is: ";
			
			for (int i = 0; i < this.NOO; i ++) {
				string += this.occurswithin[i];
				if (i < this.NOO - 1) {
					string += ", ";
				}
			}
			
			return string;
		}
	}

}
