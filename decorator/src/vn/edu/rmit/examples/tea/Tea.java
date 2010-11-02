package vn.edu.rmit.examples.tea;

public abstract class Tea {
	
	private String description = "Unknown tea";
	
	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String makingProcess() {
		return description;
	}
	
	public abstract double cost();

}
