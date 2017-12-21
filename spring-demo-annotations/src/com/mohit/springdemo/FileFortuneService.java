package com.mohit.springdemo;

import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.Random;

@Component
public class FileFortuneService implements FortuneService {
    private String[] data;
    private Random random = null;

    @PostConstruct
    public void readFortunes(){
        random = new Random();
        System.out.println("Fortunes being read from file");
        try{
            File fortuneFile = new File("/Users/mohitmulchandani/Desktop/JavaSpring/spring-demo-annotations/src/com/mohit/springdemo/fortunes.txt");
            BufferedReader reader = new BufferedReader(new FileReader(fortuneFile));

            data = reader.readLine().split(",");
        }catch(Exception e){
            e.printStackTrace();
            System.out.println("Yo");
        }
    }

    @Override
    public String getFortune() {
        return data[random.nextInt(data.length)];
    }
}
