package vn.edu.rmit.examples.coffee;

public class Mocha extends CondimentDecorator {

	private Beverage beverage;
	
	public Mocha(Beverage b) {
		this.beverage = b;
	}
	
	public double cost() {
		return 0.20d + beverage.cost();
	}
	
	public String getDescription() {
		return "with Mocha";
	}
}
