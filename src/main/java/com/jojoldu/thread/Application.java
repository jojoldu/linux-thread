package com.jojoldu.thread;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

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

    @GetMapping("/connect-hang")
    public String connectHang(@RequestParam(value = "index") String index) {
        RestTemplate restTemplate = new RestTemplateBuilder()
                .setConnectTimeout(30 * 60 * 1000) // 30분
                .setReadTimeout(30 * 60 * 1000) // 30분
                .build();

        System.out.println("index: " +index);

        return restTemplate.getForObject("http://ec2-13-125-219-239.ap-northeast-2.compute.amazonaws.com:8080/receive-hang?index="+index, String.class);
    }

    @GetMapping("/receive-hang")
    public String receiveHang(@RequestParam(value = "index") String index) throws InterruptedException {
        System.out.println(LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd hh:mm:ss"))+" index: "+index);
        Thread.sleep(12000000); // 1200초 == 20분

        return "receiveHang";
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
        return "go1100!";
    }

    @GetMapping("/4000")
    public String go4000() {
        for (int i = 0; i < 4000; i++) {
            System.out.println("i: "+i);
            threadMarker.create();
        }
        return "go4000!";
    }
}
