package vn.edu.rmit.examples;

public class MotorbikeFactory implements Factory {

	@Override
	public Motorbike createMotorbike(String type) {
		Motorbike mb = null;
		
		if(type.equals("Click")) {
			mb = new HondaClick();
		} else if(type.equals("Dream")) {
			mb = new HondaDream();
		} else if(type.equals("Wave")) {
			mb = new HondaWave();
		}
		return mb;
	}

}
