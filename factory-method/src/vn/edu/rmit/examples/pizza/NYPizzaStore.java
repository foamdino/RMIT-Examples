package vn.edu.rmit.examples.pizza;

public class NYPizzaStore extends PizzaStore {
	
	public Pizza createPizza(String type) {
		if(type.equals("cheese")) {
			return new NYStyleCheesePizza();
		} else if(type.equals("veggie")) {
			return new NYStyleVeggiePizza();
		} else if(type.equals("clam")) {
			return new NYStyleClamPizza();
		} else if(type.equals("pepperoni")) {
			return new NYStylePepperoniPizza();
		} else {
			return null;
		}
	}

}
