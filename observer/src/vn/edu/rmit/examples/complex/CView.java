package vn.edu.rmit.examples.complex;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Observable;

public class CView extends TemperatureView {

	public CView() {}
	
	public CView(int h, int v) {
		super("Celsius Temperature", h, v);
	}
	
	public void init() {
		super.init();
		setDisplay(""+getModel().getC());
		addUpListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				getModel().setC(getModel().getC() + 1.0);
			}
		});
		addDownListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				getModel().setC(getModel().getC() - 1.0);
			}
		});
		addDisplayListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				double value = getDisplay();
				getModel().setC(value);
			}
		});
	}
	
	public void update(Observable t, Object o) {
		setDisplay("" + getModel().getC());
	}
}
