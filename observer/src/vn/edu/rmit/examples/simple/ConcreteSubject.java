package vn.edu.rmit.examples.simple;

import java.util.ArrayList;
import java.util.List;

public class ConcreteSubject implements Subject {

	private List<Observer> observers = new ArrayList<Observer>(); 
	
	@Override
	public void registerObserver(Observer o) {
		observers.add(o);
	}

	@Override
	public void removeObserver(Observer o) {
		observers.remove(o);
	}

	@Override
	public void notifyObservers() {
		for(Observer o : observers) {
			o.update("updated");
		}
	}

}
