package vn.edu.rmit.examples.complex;

import java.util.Observable;

public class TemperatureModel extends Observable {
	
	private double tempF = 32.0d;

	public double getF() {
		return tempF;
	}

	public void setF(double f) {
		this.tempF = f;
		setChanged();
		notifyObservers();
	}
	
	public double getC() {
		return (tempF - 32.0) * (5.0 / 9.0);
	}
	
	public void setC(double c) {
		this.tempF = c * (9.0/5.0) + 32.0;
		setChanged();
		notifyObservers();
	}
}
