package vn.edu.rmit.examples;

public class DatabaseEngineProxy implements Engine {

	private Engine engine;
	
	public DatabaseEngineProxy(Engine e) {
		engine = e;
	}
	
	@Override
	public String getDatabaseEngineName() {
		return engine.getDatabaseEngineName();
	}

}
