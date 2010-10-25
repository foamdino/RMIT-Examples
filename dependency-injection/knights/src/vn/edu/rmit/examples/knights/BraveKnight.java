package vn.edu.rmit.examples.knights;

public class BraveKnight implements Knight {
	
	private Quest quest;
	
	public BraveKnight(Quest q) {
		this.quest = q;
	}
	
	public void embarkOnQuest() {
		quest.embark();
	}

}
