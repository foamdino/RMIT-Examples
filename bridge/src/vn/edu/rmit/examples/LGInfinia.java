package vn.edu.rmit.examples;

public class LGInfinia implements TV {

	private boolean on;
	private int currentChannel = -1;
	
	@Override
	public void on() {
		on = true;
	}

	@Override
	public void off() {
		on = false;
	}

	@Override
	public int tuneChannel(int c) {
		if(on) {
			currentChannel = c;
		}
		return currentChannel;
	}
	
	@Override
	public int recallChannel() {
		return -1;
	}

}
