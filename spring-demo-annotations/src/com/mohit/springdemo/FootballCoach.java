package com.mohit.springdemo;

import org.springframework.stereotype.Component;

@Component
public class FootballCoach implements Coach {
    @Override
    public String getDailyWorkout() {
        return "Practice penalty kicks for 30 minutes";
    }

    @Override
    public String getDailyFortune() {
        return null;
    }
}
