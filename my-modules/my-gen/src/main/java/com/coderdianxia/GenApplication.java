package com.coderdianxia;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;


@SpringBootApplication
public class GenApplication {

//    @Value("${username}")
//    private String username;

    public static void main(String[] args) {
        ConfigurableApplicationContext applicationContext = SpringApplication.run(GenApplication.class, args);
//        while(true){
//            String username = applicationContext.getEnvironment().getProperty("username");
//            System.out.println("==========="+username+"=============");
//            Thread.sleep(5000);
//        }
    }
}
