package com.mohit.springdemo;

import java.util.Random;

public class RandomFortuneService implements FortuneService {

    @Override
    public String getFortune() {
        Random random = new Random();
        String[] fortuneMessages = {"this is fortune message1", "this is fortune message2", "this is fortune message3"};
        return fortuneMessages[random.nextInt(3)];
    }
}
