package org.koushik.javabrains;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @author v-almett
 *
 */
public class DrawingApp {

	public static void main(String[] args) {
//		Triangle triangle = new Triangle();
//		triangle.draw();

		ApplicationContext factory = new ClassPathXmlApplicationContext("spring.xml");
		Triangle triangle = (Triangle)factory.getBean("triangle");
		triangle.draw();
	}

}
