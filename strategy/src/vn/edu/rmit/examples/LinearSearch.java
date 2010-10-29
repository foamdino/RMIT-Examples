package vn.edu.rmit.examples;

public class LinearSearch implements SearchStrategy {

	@Override
	public boolean execute(int[] data, int item) {
		for(int i=0; i<data.length; i++) {
			if(item == data[i]) {
				return true;
			}
		}
		return false;
	}

}
