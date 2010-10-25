package vn.edu.rmit.examples.knights;

import org.mockito.*;
import org.junit.Test;

public class BraveKnightTest {

	@Test
	public void testKnightShouldEmbarkOnQuest() {
		// (1) create a 'mock' version of our quest
		Quest mockQuest = Mockito.mock(Quest.class);
		
		// (2) create a BraveKnight and pass in the quest
		BraveKnight knight = new BraveKnight(mockQuest);
		
		// (3) go on quest (the actual method we're testing)
		knight.embarkOnQuest();
		
		// (4) check that the embark method is called 1 time only
		Mockito.verify(mockQuest, Mockito.times(1)).embark();
	}
	
}
