package vn.edu.rmit.examples;

public class Main {

	public static void main(String[] args) {
		DatabaseEngineProxy proxy = new DatabaseEngineProxy(new OracleDatabaseEngine());
		System.out.println(proxy.getDatabaseEngineName());
	}

}
