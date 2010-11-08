package vn.edu.rmit.examples.complex;

import java.awt.Label;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.Observer;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;

public abstract class TemperatureView implements Observer {

	private int h;
	private int v;
	private String label;
	private TemperatureModel model;
	private JFrame temperatureFrame;
	private JTextField display = new JTextField();
	private JButton upButton = new JButton("Raise");
	private JButton downButton = new JButton("Lower");
	
	public String getLabel() {
		return label;
	}

	public void setLabel(String label) {
		this.label = label;
	}

	public TemperatureModel getModel() {
		return model;
	}

	public void setModel(TemperatureModel model) {
		this.model = model;
	}

	public TemperatureView() {}
	
	public TemperatureView(String label, int h, int v) {
		this.label = label;
		this.h = h;
		this.v = v;
	}
	
	public void init() {
		temperatureFrame = new JFrame(label);
		temperatureFrame.add("North", new Label(label));
		temperatureFrame.add("Center", display);
		JPanel buttons = new JPanel();
		buttons.add(upButton);
		buttons.add(downButton);		
		temperatureFrame.add("South", buttons);		
		temperatureFrame.addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosing(WindowEvent e) {
				e.getWindow().setVisible(false);
				System.exit(0);
			}
		});	
		model.addObserver(this); // Connect the View to the Model
		temperatureFrame.setSize(200,100);
		temperatureFrame.setLocation(h, v);
		temperatureFrame.setVisible(true);
	}
	
	public void setDisplay(String s){ display.setText(s);}
	
	public double getDisplay() {
		double result = 0.0;
		try{	
			result = Double.valueOf(display.getText()).doubleValue();
		} catch (NumberFormatException e){
			e.printStackTrace();
		}
		return result;
	}
	
	public void addDisplayListener(ActionListener a){ display.addActionListener(a);}
	public void addUpListener(ActionListener a){ upButton.addActionListener(a);}
	public void addDownListener(ActionListener a){ downButton.addActionListener(a);}
}
