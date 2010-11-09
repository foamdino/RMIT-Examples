package vn.edu.rmit.examples.pizza;

public class ChicagoStyleVeggiePizza extends Pizza {
	
	public ChicagoStyleVeggiePizza() {
		setName("Chicago Style Deep Dish Veggie Pizza");
		setDough("Extra Thick Crust Dough");
		setSauce("Plum Tomato Sauce");
		
		addTopping("Shredded Mozzarella Cheese");
		addTopping("Sliced Peppers");
		addTopping("Chopped Onions");
		addTopping("Finely Chopped Chillies");
	}
	
	@Override
	public String cut() {
		return "Cutting the pizza into square slices";
	}

}
