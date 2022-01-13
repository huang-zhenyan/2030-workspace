package model;

public class Channel {
	// Attributes
	private String name;
	private int maxfollowers;
	private int maxvideos;
	private int NOF;
	private int NOV;
	private String[] videos;
	private Follower[] followers;
	private int views;
	private int watchtime;
	private int maxwatchtime;
	
	// Constructors
	public Channel (String name, int maxfollowers, int maxvideos) {
		this.name = name;
		this.maxfollowers = maxfollowers;
		this.maxvideos = maxvideos;
		this.NOF = 0;
		this.NOV = 0;
		this.videos = new String[maxvideos];
		this.followers = new Follower[maxfollowers];
		this.views = 0;
		this.watchtime = 0;
		this.maxwatchtime = 0;
	}
	
	public Channel (Channel other) {
		this.name = other.getName();
		this.maxfollowers = other.getMaxfollowers();
		this.maxvideos = other.getMaxVideos();
		this.NOF = other.getNOF();
		this.NOV = other.getNOV();
		this.videos = other.getVideo();
		this.followers = other.getFollower();
		this.views = 0;
		this.watchtime = 0;
		this.maxwatchtime = 0;
	}
	
	// Accessors
	public String getName() {
		return this.name;
	}
	
	public int getMaxfollowers() {
		return this.maxfollowers;
	}
	
	public int getMaxVideos() {
		return this.maxvideos;
	}
	
	
	public String[] getVideo() {
		return this.videos;
	}
	
	public Follower[] getFollower() {
		return this.followers;
	}
	
	public int getNOV() {
		return this.NOV;
	}
	
	public int getNOF() {
		return this.NOF;
	}
	
	public int getViews() {
		return this.views;
	}
	
	public int getWatchTime() {
		return this.watchtime;
	}
	
	public int getMaxWatchTime() {
		return this.maxwatchtime;
	}
	
	public String toString() {
		// Checks for video
		String s = "";
		if (this.NOV == 0) {
			s += String.format("%s released no videos", this.name);
		}
		else {
			s += String.format("%s released <", this.name);
			for (int i = 0; i < this.NOV; i ++) {
				s += this.videos[i];
				if (i < this.NOV - 1) {
					s += ", ";
				}
			}
			s += ">";
		}
		
		// Checks for followers
		if (this.NOF == 0) {
			s += " and has no followers.";
		}
		else {
			s += " and is followed by [";
			for (int i = 0; i < this.NOF; i ++) {
				s += this.followers[i].getName();
				if (i < this.NOF - 1) {
					s += ", ";
				}
			}
			s+= "].";

		}
		return s;
		
	}
	
	// Mutators
	public void releaseANewVideo(String video) {
		this.videos[this.NOV] = video;
		this.NOV ++;
		for (int i = 0; i < this.NOF; i ++) {
			if (this.followers[i] instanceof Subscriber) {
				this.followers[i].recommendVideo(video);
			}
		}
	}
	
	public void follow(Follower f1) {
		this.followers[this.NOF] = f1;
		this.NOF ++;
		f1.addChannel(this);
	}
	
	public void unfollow(Follower f1) {
		int index = -1;
		for (int i = 0; i < this.NOF; i++) {
			if (this.followers[i].equals(f1)) {
				index = i;
			}
		}
		if (index != -1) {
			this.followers[index].removeChannel(this);
			this.followers[index] = null;
			for (int i = index; i < this.NOF - 1; i ++) {
				this.followers[i] = this.followers[i+1];
			}
			this.NOF--;
		}
		
	}
	
	public void addView(int watchtime) {
		this.views ++;
		if (watchtime > this.maxwatchtime) {
			this.maxwatchtime = watchtime;
		}
		this.watchtime += watchtime;
		
		for (int i = 0; i < this.NOF; i ++) {
			if (this.followers[i] instanceof Monitor) {
				
				
			}
		}
	}
	
	
	
}
