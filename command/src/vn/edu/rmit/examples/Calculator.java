package vn.edu.rmit.examples;

public class Calculator {
	
	private long currentValue;

	public void performOperation(char op, int operand) {
		System.out.println("Executing: ["+ op + "] with ["+ operand +"]");
		switch(op) {
		case '+':
			currentValue += operand;
			break;
		case '-':
			currentValue -= operand;
			break;
		case '*':
			currentValue *= operand;
			break;
		case '/':
			currentValue /= operand;
			break;
		}
	}
	
	public long getCurrentValue() {
		return this.currentValue;
	}
	
	public void print() {
		System.out.println("Current value: "+ currentValue);
	}

}
