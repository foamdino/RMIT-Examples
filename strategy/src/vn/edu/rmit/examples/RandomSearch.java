package vn.edu.rmit.examples;

import java.util.Random;

public class RandomSearch implements SearchStrategy {

	@Override
	public boolean execute(int[] data, int item) {
		boolean found = false;
		while(!found) {
			int index = new Random().nextInt(data.length + 1);
			if(item == data[index]) {
				found = true;
			}
		}
		return found;
	}

}
