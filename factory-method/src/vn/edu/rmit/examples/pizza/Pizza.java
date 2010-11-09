package vn.edu.rmit.examples.pizza;

import java.util.ArrayList;
import java.util.List;

public abstract class Pizza {
	private String name;
	private String dough;
	private String sauce;
	private List<String> toppings = new ArrayList<String>();
	
	public void prepare() {
		System.out.println("Preparing "+name);
		System.out.println("Tossing dough...");
		System.out.println("Adding sauce...");
		System.out.println("Adding toppings...");
		for(String t : toppings) {
			System.out.println("\t"+t);
		}
	}
	
	public String bake() {
		return "Bake for 25 minutes at 350F";
	}
	
	public String cut() {
		return "Cutting the pizza into diagonal slices";
	}
	
	public String box() {
		return "Place pizza in official box";
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDough() {
		return dough;
	}

	public void setDough(String dough) {
		this.dough = dough;
	}

	public String getSauce() {
		return sauce;
	}

	public void setSauce(String sauce) {
		this.sauce = sauce;
	}

	public List<String> getToppings() {
		return toppings;
	}

	public void setToppings(List<String> toppings) {
		this.toppings = toppings;
	}

	public void addTopping(String s) {
		this.toppings.add(s);
	}
	
}
