package vn.edu.rmit.examples.coffee;

import org.junit.Assert;
import org.junit.Test;

import vn.edu.rmit.examples.coffee.Beverage;
import vn.edu.rmit.examples.coffee.Espresso;
import vn.edu.rmit.examples.coffee.HouseBlend;
import vn.edu.rmit.examples.coffee.Latte;
import vn.edu.rmit.examples.coffee.Mocha;
import vn.edu.rmit.examples.coffee.VanillaSyrup;

public class CoffeeTest {
	
	private Beverage testBeverage;
	
	@Test
	public void testEspresso() {
		testBeverage = new Espresso();
		Assert.assertEquals(testBeverage.cost(), 1.99d, 0);
	}
	
	@Test
	public void testHouseBlend() {
		testBeverage = new HouseBlend();
		Assert.assertEquals(testBeverage.cost(), 0.89d, 0);
	}

	@Test
	public void testLatte() {
		testBeverage = new Latte();
		Assert.assertEquals(testBeverage.cost(), 0.99d, 0);
	}
	
	@Test
	public void testMochaEspresso() {
		testBeverage = new Mocha(new Espresso());
		Assert.assertEquals(testBeverage.cost(), 2.19d, 0);
	}
	
	@Test
	public void testMochaVanillaSyrupLatte() {
		testBeverage = new Mocha(new VanillaSyrup(new Latte()));
		Assert.assertEquals(testBeverage.cost(), 1.49d, 0);
	}
	
}
