package model;

public class Follower {
	// Attributes
	protected String name;
	protected int NOC;
	protected Channel[] channelsfollowed;
	
	// Accessors
	public String getName() {
		return this.name;
	}
	
	public Channel[] getChannel() {
		return this.channelsfollowed;
	}
	
	public int getNOC() {
		return this.NOC;
	}
	

	
	// Mutators
	public void addChannel(Channel c1) {
		this.channelsfollowed[this.NOC] = c1;
		this.NOC ++;
	}
	
	public void removeChannel(Channel c1) {
		int index = -1;
		for (int i = 0; i < this.NOC ; i++) {
			if (this.channelsfollowed[i].getName().equals(c1.getName())) {
				index = i;
			}
		}
		if (index != -1) {
			this.channelsfollowed[index] = null;
			for (int i = index; i < this.NOC - 1; i ++) {
				this.channelsfollowed[i] = this.channelsfollowed[i+1];
			}
			this.NOC--;
		}
		
	}
	
	public void recommendVideo (String v1) {
		
	}
	
	public void addView(int watchtime) {
		
	}
	
	
}
