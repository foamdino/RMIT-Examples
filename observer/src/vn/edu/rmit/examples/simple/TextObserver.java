package vn.edu.rmit.examples.simple;

public class TextObserver implements Observer {

	private String state;
	
	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	@Override
	public void update(String message) {
		state = message;
	}
}
