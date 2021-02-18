package edu.eci.arsw.lacman.logic;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import edu.eci.arsw.lacman.service.LacmanServices;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ApplicationContext appContext = new ClassPathXmlApplicationContext("applicationContext.xml");
		LacmanServices m = appContext.getBean(LacmanServices.class);
		System.out.println(m.getSaludo());
	}

}
