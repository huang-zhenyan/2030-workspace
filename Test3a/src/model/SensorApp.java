package model;

public class SensorApp extends WeatherApp{
	private String type;

	public SensorApp(String name, int number) {
		super(name, number);
		type = "Weather Sensor App";
	}
	
	public String getType() {
		return this.type;
	}
	
	public String toString() {
		String s = "";
		
		String ws = "<";
		for (int i = 0; i < this.NOWS; i ++) {
			ws += this.weatherstations[i].getName();
			if (i < this.NOWS - 1) {
				ws += ", ";
			}
		}
		ws += ">";
		
		if (this.NOWS == 0) {
			s += String.format("%s %s is connected to no stations.", this.type, this.name);
		}
		else {
			s += String.format("Weather Sensor App %s is connected to %s stations: %s.", this.name, this.NOWS, ws);
		}
		return s;
	}
	
	public void updateMeasurements(String name, int temp, int pressure) {
		for (int i = 0; i < this.NOWS; i ++) {
			if (this.weatherstations[i].equals(name)) {
				this.weatherstations[i].updateMeasurements(temp, pressure);
			}
		}
	}


	public void updateMeasurements(WeatherStation ws, int temp, int pressure) {
	}

	@Override
	public String[] getConnectedForcastersOf(String s) {
		String[] sa = new String[100];
		return sa;
		
	}
	
}
