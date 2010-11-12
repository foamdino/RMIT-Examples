package vn.edu.rmit.examples;

import java.util.Date;

public class VacationBuilder implements AbstractBuilder {

	private Vacation vacation = new Vacation();
	
	
	@Override
	public void buildDay(Date d) {
		Day day = new Day();
		day.setDate(d);
		vacation.addDay(day);
	}

	@Override
	public void addSpecialEvent(Date d, String event) {
		Day day = vacation.getActivities().get(d);
		if(null!= day) {
			day.setSpecialEvent(event);
		} else {
			// create day first
			buildDay(d);
			addSpecialEvent(d, event);
		}
	}

	@Override
	public void addTickets(int num) {
		this.vacation.setNumberOfPeople(num);
	}

	@Override
	public Vacation getVacation() {
		return this.vacation;
	}

	@Override
	public void addHotel(Date d, Hotel h) {
		Day day = vacation.getActivities().get(d);
		if(null!= day) {
			day.setHotel(h);
		} else {
			// create day first
			buildDay(d);
			addHotel(d, h);
		}
	}

	@Override
	public void addReservation(Date d, Resort r) {
		Day day = vacation.getActivities().get(d);
		if(null!= day) {
			day.setResort(r);
		} else {
			// create day first
			buildDay(d);
			addReservation(d, r);
		}
		
	}

}
