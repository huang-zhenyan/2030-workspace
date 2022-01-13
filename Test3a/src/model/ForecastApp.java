package model;

public class ForecastApp extends WeatherApp{
	private String type;
	private int[] max;
	private double[] avg;
	private int[] total;
	private int NOT;
	private String[] forecast;
	private int[] pressure;

	public ForecastApp(String name, int number) {
		super(name, number);
		type = "Weather Forecast App";
		this.max = new int[this.NOWS];
		this.avg = new double[this.NOWS];
		this.forecast = new String[this.NOWS];
		this.total = new int[this.NOWS];
		this.pressure = new int[this.NOWS];
		this.NOT = 0;
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
			s += String.format("Weather Forecast App %s is connected to %s stations: %s.", this.name, this.NOWS, ws);
		}
		return s;
	}
	
	public void updateMeasurements(WeatherStation ws, int temp, int pressure) {
		int index = -1;
		for (int i = 0; i < this.NOWS; i ++) {
			if (this.weatherstations[i] == ws) {
				index = i;
			}
		}
		
		if (index != -1) {
			if (this.max[index] < temp) {
				this.max[index] = temp;
			}
			this.total[index] += temp;
			this.NOT ++;
			this.avg[index] = this.total[index] / this.NOT;
			if (this.forecast[index] == null) {
				this.forecast[index] = "unlikely to rain";
			}
			else {
				if (this.pressure[index] > pressure) {
					this.forecast[index] = "likely to rain";
				}
			}
			this.pressure[index] = pressure;
		}
	}

	@Override
	public String[] getConnectedForcastersOf(String s) {
		String[] sa = new String[100];
		return sa;
		
	}

}
