package com.springcore.annotations;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class CoachApp {

	public static void main(String[] args) {

		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
		
		Coach tennisCoach = context.getBean("myTennisCoach", Coach.class);
		
		System.out.println(tennisCoach.getDailyWorkouts());
		
		System.out.println(tennisCoach.getDailyFortunes());
		
		context.close();
	}

}
