package vn.edu.rmit.examples;

public class Main {

	public static void main(String[] args) {
		Factory f = new MotorbikeFactory();
		
		if(args.length < 1) {
			printUsage();
			System.exit(1);
		}
	
		Motorbike bike = f.createMotorbike(args[0]);
		if(null == bike) {
			printUsage();
			System.exit(1);
		}
		
		System.out.println(bike.rideBike());
	}
	
	private static void printUsage() {
		System.out.println("Usage: java vn.edu.rmit.examples.Main [Click|Dream|Wave]");
	}

}
