package com.jojoldu.thread;

import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

/**
 * Created by jojoldu@gmail.com on 2018. 4. 13.
 * Blog : http://jojoldu.tistory.com
 * Github : https://github.com/jojoldu
 */

@Component
public class ThreadMarker {

    private RestTemplate restTemplate;

    public ThreadMarker(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    @Async
    public void create() {
        System.out.println(Thread.currentThread());

        try {
            Thread.sleep(12000000); //1200초 == 20분
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    @Async
    public void connectHang(int i) {
        String result = restTemplate.getForObject("ec2-13-125-187-252.ap-northeast-2.compute.amazonaws.com:8080/receive-hang?index="+i
                , String.class);
        System.out.println(result);
    }

}
