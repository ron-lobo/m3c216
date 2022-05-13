package com.m3.spring.example2;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan
public class LuckyNumber1 {

    public static void main(String[] args) {
        ApplicationContext appContext = new AnnotationConfigApplicationContext(LuckyNumber1.class);

        LuckyNumberServer luckyNumberServer = appContext.getBean(LuckyNumberServer.class);
        luckyNumberServer.createLuckyNumber();
    }

    @Bean
    public LuckyNumberServer getLuckyNumberServer(LuckyNumberHelper luckyNumberHelper) {
        return new LuckyNumberServer(luckyNumberHelper);
    }

//    @Bean
//    public LuckyNumberHelper getLuckyNumberHelper(LuckyNumberService service, LuckyNumberDB db) {
//        return new LuckyNumberHelperImpl(service, db);
//    }

//    @Bean
//    public LuckyNumberService getLuckyNumberService(DepA depA) {
//        return new LuckyNumberServiceImpl(depA);
//    }

//    @Bean
//    public LuckyNumberDB getLuckyNumberDB() {
//        return new LuckyNumberDBImpl();
//    }

//    @Bean
//    public DepA getDepA() {
//        return new DepAImpl();
//    }
}
