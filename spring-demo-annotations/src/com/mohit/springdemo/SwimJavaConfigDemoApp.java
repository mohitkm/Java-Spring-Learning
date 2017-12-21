package com.mohit.springdemo;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class SwimJavaConfigDemoApp {
    public static void main(String... args){
        // read spring config file
        AnnotationConfigApplicationContext context =
                new AnnotationConfigApplicationContext(SportConfig.class);
        //get bean from spring container
        SwimCoach theCoach = context.getBean("swimCoach", SwimCoach.class);

        //call methods on the bean
        System.out.println(theCoach.getDailyWorkout());

        //call method to get Daily fortune
        System.out.println(theCoach.getDailyFortune());

        System.out.println("email: " + theCoach.getEmail());
        System.out.println("team: " + theCoach.getTeam());

        //close the container
        context.close();
    }
}
