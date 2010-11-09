package vn.edu.rmit.examples.pizza;

public class ChicagoStyleCheesePizza extends Pizza {
	
	public ChicagoStyleCheesePizza() {
		setName("Chicago Style Deep Dish Cheese Pizza");
		setDough("Extra Thick Crust Dough");
		setSauce("Plum Tomato Sauce");
		
		addTopping("Shredded Mozzarella Cheese");
	}
	
	@Override
	public String cut() {
		return "Cutting the pizza into square slices";
	}

}
