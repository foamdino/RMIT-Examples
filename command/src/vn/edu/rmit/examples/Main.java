package vn.edu.rmit.examples;

public class Main {

	public static void main(String[] args) {
		Calculator c = new Calculator();
		Invoker invoker = new Invoker(c);
		invoker.calculate(new CalculatorCommand(c, '+', 9));
		invoker.calculate(new CalculatorCommand(c, '-', 5));
		invoker.calculate(new CalculatorCommand(c, '*', 3));
		invoker.calculate(new CalculatorCommand(c, '/', 2));
		
		c.print();
		//undo the last 3 operations
		invoker.undo(3);
		c.print();
		//redo the final 3 operations
		invoker.redo(3);
		
		c.print();
	}

}
