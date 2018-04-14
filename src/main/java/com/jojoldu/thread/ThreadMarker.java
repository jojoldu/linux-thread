package com.jojoldu.thread;

import org.springframework.boot.web.client.RestTemplateBuilder;
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

    }

}
