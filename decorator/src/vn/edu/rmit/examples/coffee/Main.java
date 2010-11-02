package vn.edu.rmit.examples.coffee;

public class Main {

	public static void main(String[] args) {
		Beverage b = new Mocha(new VanillaSyrup(new Latte()));
		System.out.println(b.cost());
	}
	
}
