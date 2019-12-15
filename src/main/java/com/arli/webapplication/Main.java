package com.arli.webapplication;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class Main {
    public static void main(String[] args) throws InterruptedException {
        SpringApplication.run(Main.class);/*
            for (int i = 50; i >= 0; i--) {
                System.out.println("Осталось: " + ((i > 4)? i + " секунд": (i > 1)? i + " секунды" : (i == 1)? i + " секунда" : "менее секунды"));
                Thread.sleep(1000L);
            }
            System.out.println("Время истекло!");
        */
    }
}
