package vn.edu.rmit.examples.pizza;

public class ChicagoStyleClamPizza extends Pizza {
	public ChicagoStyleClamPizza() {
		setName("Chicago Style Deep Dish Clam Pizza");
		setDough("Extra Thick Crust Dough");
		setSauce("Plum Tomato Sauce");
		
		addTopping("Shredded Mozzarella Cheese");
		addTopping("Clams");
	}
	
	@Override
	public String cut() {
		return "Cutting the pizza into square slices";
	}

}
