package model;

public class Subscriber extends Follower {
	// Attributes
	private String name;
	private int maxchannelstofollow;
	private int maxvideosrecommended;
	private int NOV;
	private String[] videosrecommneded;
	
	// Constructor
	public Subscriber(String name, int maxchannelstofollow, int maxvideosrecommneded) {
		this.name = name;
		this.maxchannelstofollow = maxchannelstofollow;
		this.maxvideosrecommended = maxvideosrecommneded;
		this.NOC = 0;
		this.NOV = 0;
		this.channelsfollowed = new Channel[maxchannelstofollow];
		this.videosrecommneded = new String[maxvideosrecommended];
	}
	
	// Accessors
	public String getName() {
		return "Subscriber " + this.name;
	}
	
	public String toString() {
		String s = "";
		// Checks Channels
		if (this.NOC == 0) {
			s += String.format("Subscriber %s follows no channels ", this.name);
		}
		else {
			s += String.format("Subscriber %s follows [", this.name);
			for (int i = 0; i < this.NOC; i ++) {
				s += this.channelsfollowed[i].getName();
				if (i < this.NOC - 1) {
					s += ", ";
				}
			}
			s += "] ";
		}
		
		// Checks Videos
		if (this.NOV == 0) {
			s += "and has no recommended videos.";
		}
		else {
			s += "and is recommended <";
			for (int i = 0; i < this.NOV; i ++) {
				s += this.videosrecommneded[i];
				if (i < this.NOV - 1) {
					s += ", ";
				}
			}
			s += ">.";
		}
		
		return s;
	}
	
	// Mutators
	public void recommendVideo(String v1) {
		this.videosrecommneded[this.NOV] = v1;
		this.NOV ++;
	}
	
	public void watch(String v1, int watchtime) {
		Channel c = null;
		for (int i = 0; i < this.NOC; i ++) {
			for (int v = 0; v < this.channelsfollowed[i].getNOV(); v ++) {
				if (this.channelsfollowed[i].getVideo()[v].equals(v1)) {
					c = this.channelsfollowed[i];
					c.addView(watchtime);
				}
			}
		}
		
		
	}
}
