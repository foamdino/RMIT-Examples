package vn.edu.rmit.examples;

public abstract class RemoteControl {
	
	// this is the 'implementor'
	private TV tv;
	
	public void on() {
		tv.on();
	}
	
	public void off() {
		tv.off();
	}
	
	public int setChannel(int c) {
		return tv.tuneChannel(c);
	}
	
	public int returnToPriorChannel() {
		return tv.recallChannel();
	}
}
