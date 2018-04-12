package com.jojoldu.thread;

import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Component;

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
            Thread.sleep(1200000); //120초
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

}
