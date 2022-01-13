package model;

public class WeatherStation {
	private String name;
	private WeatherApp[] weatherapps;
	private int NOA;
	private int temp;
	private int pressure;

	public WeatherStation(String name, int number) {
		this.name = name;
		this.weatherapps = new WeatherApp[number];
		this.temp = 0;
		this.pressure = 0;
	}
	
	public String getName() {
		return this.name;
	}
	
	public int getTemp() {
		return this.temp;
	}
	
	public int getPressure() {
		return this.pressure;
	}
	
	public String toString() {
		String s = "";
		
		String apps = "<";
		for (int i = 0; i < this.NOA; i ++) {
			apps += this.weatherapps[i].getType() + " ";
			apps += this.weatherapps[i].getName();
			if (i < this.NOA - 1) {
				apps += ", ";
			}
		}
		apps += ">";
		
		if (this.NOA == 0) {
			s += String.format("%s has no connected apps.", this.name);
		}
		else {
			s += String.format("%s is connected by %s apps: %s.", this.name, this.NOA, apps);
		}
		return s;
	}
	
	public SensorApp[] getSensors() {
		int numberofsensors = 0;
		int NOS = 0;
		for (int i = 0; i < this.NOA; i ++) {
			if (this.weatherapps[i] instanceof SensorApp) {
				numberofsensors ++;
			}
		}
		SensorApp[] sensorapps = new SensorApp[numberofsensors];
		for (int i = 0; i < this.NOA; i ++) {
			if (this.weatherapps[i] instanceof SensorApp) {
				sensorapps[NOS] = (SensorApp) this.weatherapps[i];
				NOS ++;
			}
		}
		return sensorapps;
	}
	
	public void connect(WeatherApp app) {
		this.weatherapps[this.NOA] = app;
		this.NOA ++;
		app.connect(this);
	}

	public void updateMeasurements(int temp, int pressure) {
		this.temp = temp;
		this.pressure = pressure;
		for (int i = 0; i < this.NOA; i ++) {
			if (this.weatherapps[i] instanceof ForecastApp) {
			}
		}
	}
}
