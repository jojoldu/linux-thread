package com.jojoldu.thread;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@EnableAsync
@RestController
@SpringBootApplication
public class Application {

    private ThreadMarker threadMarker;

    public Application(ThreadMarker threadMarker) {
        this.threadMarker = threadMarker;
    }

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }

    @GetMapping("/")
    public String load() {
        return "load";
    }

    @GetMapping("/1100")
    public String go1100() {
        for (int i = 0; i < 1100; i++) {
            System.out.println("i: "+i);
            threadMarker.create();
        }
        return "go!";
    }

    @GetMapping("/3000")
    public String go4000() {
        for (int i = 0; i < 4000; i++) {
            System.out.println("i: "+i);
            threadMarker.create();
        }
        return "go!";
    }


}
