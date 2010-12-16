package vn.edu.rmit.examples;

public class D500CoinHandler implements Handler {

	Handler successor = new D1000CoinHandler();
	
	public boolean handle(Coin c) {
		if(c instanceof D500Coin ) {
			System.out.println("Handling D500");
			return true;
		} else {
			System.out.println("Passing to successor");
			if(successor.handle(c)) {
				return true;
			}
		}
		System.out.println("Cannot handle : "+c);
		return false;
	}
}
