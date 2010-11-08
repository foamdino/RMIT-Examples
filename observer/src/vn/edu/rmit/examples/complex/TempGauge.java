package vn.edu.rmit.examples.complex;

public class TempGauge {

	private int max;
	private int min;
	private int current;
	
	public TempGauge(final int min, final int max){
		this.min = min; 
		this.max = max; 
	}

	public void set(int level) { 
		current = level; 
	}	
	
	public int get(){
		return current;
	}
	
	public int getMax(){
		return max;
	}
	
	public int getMin(){
		return min;
	}
}
