package vn.edu.rmit.examples;

import java.util.Date;

public interface AbstractBuilder {
	
	public void buildDay(Date d);
	public void addHotel(Date d, Hotel h);
	public void addReservation(Date d, Resort r);
	public void addSpecialEvent(Date d, String event);
	public void addTickets(int num);
	public Vacation getVacation();

}
