package com.mohit.springdemo;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class AnnotationDemoApp {
    public static void main(String... args){
        // read spring config file
        ClassPathXmlApplicationContext context =
                new ClassPathXmlApplicationContext("applicationContext.xml");

        //get bean from spring container
        Coach theCoach = context.getBean("tennisCoach", Coach.class);

        //call methods on the bean
        System.out.println(theCoach.getDailyWorkout());

        //call method to get Daily fortune
        System.out.println(theCoach.getDailyFortune());

        //close the container
        context.close();
    }
}
