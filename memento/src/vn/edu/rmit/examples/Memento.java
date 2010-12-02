package vn.edu.rmit.examples;

public class Memento {
	
	private String state;
	
	public Memento(String s) {
		this.state = s;
	}
	
	public void storeState(String s) {
		this.state = s;
	}
	
	public String loadState() {
		return state;
	}

}
