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
    public void create() throws InterruptedException {
        System.out.println(Thread.currentThread());
        Thread.sleep(1200000);
    }

}
