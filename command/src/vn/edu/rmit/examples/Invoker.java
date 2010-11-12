package vn.edu.rmit.examples;

import java.util.ArrayList;
import java.util.List;

public class Invoker {

	private List<Command> commands = new ArrayList<Command>();
	//command position in list
	private int currentCommand;
	private Calculator calculator;
	
	public Invoker(Calculator c) {
		this.calculator = c;
	}
	
	public void calculate(Command c) {
		//add to history
		commands.add(c);
		c.execute();
	}
	
	public void undo(int level) {
		for(int i=(commands.size()-1); (i+level) > (commands.size()-1); i--) {
			commands.get(i).unexecute();
		}
	}
	
	public void redo(int level) {
		for(int i=commands.size()-level; i < commands.size(); i++) {
			commands.get(i).execute();
		}
	}
}
