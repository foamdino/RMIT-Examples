package vn.edu.rmit.examples.knights;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class KnightMain {

	public static void main(String[] args) {
		
		ApplicationContext ctx = new ClassPathXmlApplicationContext("vn/edu/rmit/examples/knights/knights.xml");
		
		Knight k = ctx.getBean("knight", Knight.class);
		k.embarkOnQuest();
	}
	
}
