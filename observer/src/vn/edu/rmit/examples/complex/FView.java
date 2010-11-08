package vn.edu.rmit.examples.complex;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Observable;

public class FView extends TemperatureView {

	public FView() {}
	
	public FView(int h, int v) {
		super("Farenheit Temperature", h, v);
	}
	
	public void init() {
		super.init();
		setDisplay(""+getModel().getF());
		addUpListener(new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent e) {
				getModel().setF(getModel().getF() + 1.0);
			}
		});
		addDownListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				getModel().setF(getModel().getF() - 1.0);
			}
		});
		addDisplayListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				double value = getDisplay();
				getModel().setF(value);
			}
		});
	}
	
	public void update(Observable t, Object o) {
		setDisplay("" + getModel().getF());
	}
	
}
