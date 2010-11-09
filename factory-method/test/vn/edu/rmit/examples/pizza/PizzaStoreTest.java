package vn.edu.rmit.examples.pizza;

import org.junit.Assert;
import org.junit.Test;

public class PizzaStoreTest {
	
	@Test
	public void testOrderPizza() {
		PizzaStore ps = new ChicagoPizzaStore();
		Pizza p = ps.createPizza("cheese");
		Assert.assertEquals("Chicago Style Deep Dish Cheese Pizza", p.getName());
		
		ps = new NYPizzaStore();
		p = ps.createPizza("cheese");
		Assert.assertEquals("NY Style Sauce and Cheese Pizza", p.getName());
	}
	
	@Test
	public void testCreatePizza() {
		PizzaStore ps = new ChicagoPizzaStore();
		Pizza p = ps.createPizza("veggie");
		Assert.assertEquals("Chicago Style Deep Dish Veggie Pizza", p.getName());
		
		ps = new NYPizzaStore();
		p = ps.createPizza("veggie");
		Assert.assertEquals("NY Style Sauce and Veggie Pizza", p.getName());
	}

}
