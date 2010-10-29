package vn.edu.rmit.examples;

import java.util.Arrays;
import java.util.Hashtable;
import java.util.Random;

public class Searcher {

	private Hashtable<String,SearchStrategy> strategies = new Hashtable<String,SearchStrategy>();
	
	public static void main(String[] args) {
		RandomSearch rs = new RandomSearch();
		LinearSearch ls = new LinearSearch();
		BinarySearch bs = new BinarySearch();
		
		Searcher searcher = new Searcher();
		searcher.addStrategy("random",rs);
		searcher.addStrategy("linear",ls);
		searcher.addStrategy("binary",bs);
		
		// based on input arg choose appropriate strategy
		if(args.length < 2) {
			usage();
			System.exit(1);
		}
		
		int item = Integer.parseInt(args[0]);
		String strategy = args[1];
		searcher.find(strategy, item);
	}
	
	private static void usage() {
		System.out.println("java vn.edu.rmit.examples.Searcher item [random|linear|binary]");
	}
	
	public void find(final String strategy, final int item) {
		System.out.println("searching for : "+item);
		SearchStrategy strat = strategies.get(strategy);
		if(strat.execute(getData(), item)) {
			System.out.println("found "+ item + " in data");
		} else {
			System.out.println("not found");
		}
	}
	
	//generate some test data
	public int[] getData() {
		int[] data = new int[1000];
		for(int i=0; i<1000; i++) {
			data[i] = new Random().nextInt(10);
		}
		Arrays.sort(data);
		return data;
	}
	
	public void addStrategy(final String key, final SearchStrategy ss) {
		strategies.put(key, ss);
	}
	
}
