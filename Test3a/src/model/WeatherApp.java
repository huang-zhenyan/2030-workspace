package model;

public abstract class WeatherApp {
	protected String name;
	protected WeatherStation[] weatherstations;
	protected int NOWS;
	protected String type;
	
	public WeatherApp(String name, int number) {
		this.name = name;
		this.weatherstations = new WeatherStation[number];
		this.NOWS = 0;
	}
	
	abstract public String getType();
	
	public String getName() {
		return this.name;
	}
	
	public void connect(WeatherStation ws) {
		this.weatherstations[this.NOWS] = ws;
		this.NOWS ++;
	}
	
	abstract public String toString();
	
	abstract public void updateMeasurements(WeatherStation ws, int temp, int pressure);
	
	abstract public String[] getConnectedForcastersOf(String s);
	
}
