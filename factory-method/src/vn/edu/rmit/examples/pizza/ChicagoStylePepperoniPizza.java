package vn.edu.rmit.examples.pizza;

public class ChicagoStylePepperoniPizza extends Pizza {
	
	public ChicagoStylePepperoniPizza() {
		setName("Chicago Style Deep Dish Pepperoni Pizza");
		setDough("Extra Thick Crust Dough");
		setSauce("Plum Tomato Sauce");
		
		addTopping("Shredded Mozzarella Cheese");
		addTopping("Sliced Pepperoni Sausage");
	}
	
	@Override
	public String cut() {
		return "Cutting the pizza into square slices";
	}

}
