package vn.edu.rmit.examples.complex;

import java.awt.Canvas;
import java.awt.Color;
import java.awt.Graphics;

public class TemperatureCanvas extends Canvas {

	private TempGauge gauge;
	private static final int width = 20;
	private static final int top = 20;
	private static final int left = 100;
	private static final int height = 200;
	
	public TempGauge getGauge() {
		return gauge;
	}
	public void setGauge(TempGauge gauge) {
		this.gauge = gauge;
	}

	public void paint(Graphics g) {
		g.setColor(Color.black);
		g.drawRect(left,top, width, height);
		g.setColor(Color.red);
		g.fillOval(left-width/2, top+height-width/3,width*2, width*2);
		g.setColor(Color.black);
		g.drawOval(left-width/2, top+height-width/3,width*2, width*2);
		g.setColor(Color.white);
		g.fillRect(left+1,top+1, width-1, height-1);
		g.setColor(Color.red);
		long redtop = height*(gauge.get()-gauge.getMax())/(gauge.getMin()-gauge.getMax());
		g.fillRect(left+1, top + (int)redtop, width-1, height-(int)redtop);
	}
	
}
