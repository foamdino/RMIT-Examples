package vn.edu.rmit.examples;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Client {

	
	public static void main(String[] args) {
		Handler h = new D200CoinHandler();
		
		//deal with a load of coins
		for(Coin c : randomCoins()) {
			System.out.println("New coin...");
			h.handle(c);
		}
	}
	
	private static List<Coin> randomCoins() {
		List<Coin> results = new ArrayList<Coin>();
		
		//create 100 random coins
		Random r = new Random();
		while(results.size() < 100) {
			int n = r.nextInt(1000);
			if ((0 <= n) && (n<= 100)) {
				Coin c = new D200Coin();
				results.add(c);
			} else if ((101 <= n) && (n<= 400)) {
				Coin c = new D500Coin();
				results.add(c);
			} else {
				Coin c = new D1000Coin();
				results.add(c);
			}
		}
		
		return results;
	}
}
