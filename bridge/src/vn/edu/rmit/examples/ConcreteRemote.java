package vn.edu.rmit.examples;

public class ConcreteRemote extends RemoteControl {

	private int currentChannel;
	
	@Override
	public void on() {
		on();
	}
	
	@Override
	public void off() {
		off();
	}
	
	@Override
	public int setChannel(int c) {
		return setChannel(c);
	}
	
	public int nextChannel() {
		return setChannel(currentChannel + 1);
	}
	
	public int previousChannel() {
		return setChannel(currentChannel - 1);
	}
	
	@Override
	public int returnToPriorChannel() {
		return super.returnToPriorChannel();
	}
}
