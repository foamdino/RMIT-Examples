package vn.edu.rmit.examples.pizza;

public abstract class PizzaStore {
	
	public Pizza orderPizza(String type) {
		Pizza p;
		p = createPizza(type);
		p.prepare();
		p.bake();
		p.cut();
		p.box();
		
		return p;
	}
	
	protected abstract Pizza createPizza(String type);

}
