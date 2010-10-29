package vn.edu.rmit.examples;

public class BinarySearch implements SearchStrategy {

	// assumes data is sorted...
	@Override
	public boolean execute(int[] data, int item) {
		if(data.length == 1) {
			return data[0] == item;
		} else {
			int pivotPos;
			if(data.length % 2 == 0) {
				pivotPos = data.length / 2;
			} else {
				pivotPos = (data.length / 2) + 1;
			}
			int pivot = data[pivotPos];
			int[] newData = new int[pivotPos+1]; // ensure enough room
			if (item < pivot) {
				for(int i=0; i<pivotPos;i++) {
					newData[i] = data[i];
				}
				execute(newData, item);
			} else if(item > pivot) {
				for(int i=pivotPos; i<data.length; i++) {
					newData[i-pivotPos] = data[i];
				}
				execute(newData, item);
			} else { // item == pivot -> found!
				return true;
			}
		}
		return false; //should never get here
	}

}
