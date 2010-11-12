package vn.edu.rmit.examples;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

public class Vacation {
	private int numberOfPeople;
	private Map<Date, Day> activities = new HashMap<Date, Day>();
	public int getNumberOfPeople() {
		return numberOfPeople;
	}
	public void setNumberOfPeople(int numberOfPeople) {
		this.numberOfPeople = numberOfPeople;
	}
	public Map<Date, Day> getActivities() {
		return activities;
	}
	public void setActivities(Map<Date, Day> activities) {
		this.activities = activities;
	}

	public void addDay(Day d) {
		this.activities.put(d.getDate(), d);
	}
	
	public String toString() {
		StringBuffer sb = new StringBuffer();
		sb.append("Vacation for : " + (numberOfPeople > 1 ? numberOfPeople+" people " : 1 +" person") + "\n");
		for(Day d : activities.values()) {
			sb.append("\tOn "+ d.getDate()+ "\n");
			if(null != d.getHotel()) {
				sb.append("\t\tStaying at : "+d.getHotel().getName()+"\n");
			}
			if(null != d.getResort()) {
				sb.append("\t\tGoing to : "+d.getResort().getName()+"\n");
			}
			if(null != d.getSpecialEvent()) {
				sb.append("\t\tWith a special event: "+ d.getSpecialEvent()+"\n");
			}
		}
		return sb.toString();
	}
	
}
