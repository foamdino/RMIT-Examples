package vn.edu.rmit.examples.complex;

import java.awt.Frame;
import java.awt.Scrollbar;
import java.awt.event.AdjustmentEvent;
import java.awt.event.AdjustmentListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.Observable;
import java.util.Observer;

public class SliderView implements Observer {

	private int h;
	private int v;
	private Scrollbar tempControl = new Scrollbar(Scrollbar.HORIZONTAL, 0, 10, -50, 160);
	private TemperatureModel model;
	private Frame sliderFrame = new Frame("Celsius Slider");
	
	public TemperatureModel getModel() {
		return model;
	}

	public void setModel(TemperatureModel model) {
		this.model = model;
	}

	public SliderView(int h, int v) {
		this.h = h;
		this.v = v;
		
	}
	
	public void init() {
		model.addObserver(this); //Observe the temperature model
		sliderFrame.add(tempControl);
		tempControl.addAdjustmentListener(new AdjustmentListener() {
			@Override
			public void adjustmentValueChanged(AdjustmentEvent e) {
				model.setC(tempControl.getValue());
			}
		});
		sliderFrame.setSize(250,50);
		sliderFrame.setLocation(h, v);
		sliderFrame.setVisible(true);
		sliderFrame.addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosing(WindowEvent e) {
				e.getWindow().setVisible(false);
				System.exit(0);
			}
		});		
	}
	
	public void update(Observable t, Object o) {
		double temp = ((TemperatureModel)t).getC();
		tempControl.setValue((int)temp); // Move the slider thumb
	}
	
}
