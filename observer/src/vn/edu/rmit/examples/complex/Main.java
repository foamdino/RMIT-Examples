package vn.edu.rmit.examples.complex;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Main {

	public static void main(String[] args) {
		ApplicationContext ctx = new ClassPathXmlApplicationContext("vn/edu/rmit/examples/complex/observer.xml");
		FView fv = ctx.getBean("f-view", FView.class);
		CView cv = ctx.getBean("c-view", CView.class);
		SliderView sv = ctx.getBean("slider-view", SliderView.class);
		ThermView tv = ctx.getBean("therm-view", ThermView.class);
		fv.init();
		cv.init();
		sv.init();
		tv.init();
	}
}
