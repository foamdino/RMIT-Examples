package vn.edu.rmit.examples;

public class CalculatorCommand implements Command {

	private Calculator calculator;
	private char operator;
	private int operand;
	
	public CalculatorCommand(Calculator c, char op, int operand) {
		this.calculator = c;
		this.operator = op;
		this.operand = operand;
	}
	
	@Override
	public void execute() {
		calculator.performOperation(operator, operand);
	}

	@Override
	public void unexecute() {
		calculator.performOperation(getInverse(operator), operand);		
	}

	private char getInverse(char o) {
		char undo = ' ';
		switch(o) {
		  	case '+': 
		  		undo = '-';
		  		break;
		  	case '-':
		  		undo = '+';
		  		break;
		  	case '*':
		  		undo = '/';
		  		break;
		  	case '/':
		  		undo = '*';
		  		break;
		}
		return undo;
	}
	
}
