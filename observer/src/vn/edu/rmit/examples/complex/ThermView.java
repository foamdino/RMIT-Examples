package vn.edu.rmit.examples.complex;

import java.awt.Canvas;
import java.awt.Graphics;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.Observable;
import java.util.Observer;

import javax.swing.JFrame;
import javax.swing.JPanel;

public class ThermView extends JFrame implements Observer{

	private TemperatureModel model;
	private Canvas canvas;
	private TempGauge gauge;

	public TemperatureModel getModel() {
		return model;
	}

	public void setModel(TemperatureModel model) {
		this.model = model;
	}

	public Canvas getCanvas() {
		return canvas;
	}

	public void setCanvas(Canvas canvas) {
		this.canvas = canvas;
	}

	public TempGauge getGauge() {
		return gauge;
	}

	public void setGauge(TempGauge gauge) {
		this.gauge = gauge;
	}

	public ThermView() {}
	
	public ThermView(TemperatureModel model, int h, int v) {
		super("Temperature Gauge");
	}
	
	public void init() {
		JPanel Top = new JPanel();
		add("North", Top);
		canvas.setSize(500,280);
		add("Center", canvas);		
		setSize(280, 280);
		setVisible(true);
		model.addObserver(this); // Connect to the model
		this.addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosing(WindowEvent e) {
				e.getWindow().setVisible(false);
				System.exit(0);
			}
		});	
	}
	
	// Respond to changes
	public void update(Observable obs, Object o) {
		repaint();
	}
		
	public void paint(Graphics g) {
		int farenheit = (int)model.getF(); // Use the current data to paint
		gauge.set(farenheit);
		canvas.repaint();
		super.paint(g);
	}
}
