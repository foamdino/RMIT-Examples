package vn.edu.rmit.examples;

public class D1000CoinHandler implements Handler {
	private Handler successor; // no successor
	
	public boolean handle(Coin c) {
		if(c instanceof D1000Coin ) {
			System.out.println("Handling D1000");
			return true;
		}
		System.out.println("Cannot handle : "+c);
		return false;
	}
}
