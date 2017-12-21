package com.mohit.springdemo;

public class BasketballCoach implements Coach {
    private FortuneService fortuneService;

    public BasketballCoach(FortuneService fortuneService) {
        this.fortuneService = fortuneService;
    }

    @Override
    public String getDailyWorkout() {
        return "Dribble the ball for 1 hour";
    }

    @Override
    public String getDailyFortune() {
        return "Basketball: " + fortuneService.getFortune();
    }

    public void startup(){
        System.out.println("Some startup code");
    }

    public void cleanup(){
        System.out.println("Some cleanup code");
    }
}
