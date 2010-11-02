package vn.edu.rmit.examples.coffee;

public class VanillaSyrup extends CondimentDecorator {
	private Beverage beverage;
	
	public VanillaSyrup(Beverage b) {
		this.beverage = b;
	}
	
	public double cost() {
		return 0.30d + beverage.cost();
	}
	
	public String getDescription() {
		return "with Vanilla syrup";
	}

}
