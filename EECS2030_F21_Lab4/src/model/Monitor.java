package model;

public class Monitor extends Follower {
	// Attributes
	private String name;
	private int maxchannelstofollow;
	

	
	// Constructors
	public Monitor(String name, int maxchannelstofollow) {
		this.name = name;
		this.maxchannelstofollow = maxchannelstofollow;
		this.channelsfollowed = new Channel[maxchannelstofollow];

	}
	
	// Accessors
	public String getName() {
		return "Monitor " + this.name;
	}
	
	public String toString() {
		String s = "";
		if (this.NOC == 0) {
			s += String.format("Monitor %s follows no channels.", this.name);
		}
		else {
			s += String.format("Monitor %s follows [", this.name);
			for (int i = 0; i < this.NOC; i ++) {
				s += this.channelsfollowed[i].getName();
				if (this.channelsfollowed[i].getViews() != 0) {
					double avg = (double) this.channelsfollowed[i].getWatchTime() / this.channelsfollowed[i].getViews();
					s += String.format(" {#views: %s, max watch time: %s, avg watch time: %s}", this.channelsfollowed[i].getViews(), this.channelsfollowed[i].getMaxWatchTime(), String.format("%.2f", avg));
				}
				if (i < this.NOC - 1) {
					s += ", ";
				}
			}
			s += "].";
		}
		return s;
	}
	
	// Mutator
	public void addChannel(Channel c1) {
		Channel c2 = new Channel(c1);
		this.channelsfollowed[this.NOC] = c2;
		this.NOC ++;
	}
	
}
