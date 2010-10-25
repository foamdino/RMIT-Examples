package vn.edu.rmit.examples.knights;

public class DamselRescuingKnight implements Knight {
	
	private RescueDamselQuest quest;
	
	public DamselRescuingKnight() {
		quest = new RescueDamselQuest();
	}

	public void embarkOnQuest() {
		quest.embark();
	}
}
