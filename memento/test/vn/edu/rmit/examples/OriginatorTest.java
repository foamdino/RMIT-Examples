package vn.edu.rmit.examples;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class OriginatorTest {
	
	private Originator originator;
	
	@Before
	public void setUp() throws Exception {
		originator = new Originator();
	}
	
	@Test
	public void testSaveToMementoWithNoState() throws Exception {
		Memento m = originator.saveToMemento();
		Assert.assertNotNull(m);
		Assert.assertNull(m.loadState());
	}
	
	@Test
	public void testSaveToMemento() throws Exception {
		originator.setCurrentState("testing a");
		Memento m = originator.saveToMemento();
		Assert.assertEquals("testing a", m.loadState());
	}
	
}
