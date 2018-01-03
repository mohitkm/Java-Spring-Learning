package com.mohit.aopdemo;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.stereotype.Component;

@Configuration
@EnableAspectJAutoProxy
@ComponentScan("com.mohit.aopdemo")
public class DemoConfig {

}
