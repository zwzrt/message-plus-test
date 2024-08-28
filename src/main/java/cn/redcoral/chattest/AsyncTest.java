package cn.redcoral.chattest;

import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Component;

@Component
class AsyncTest {

    @Async
    public int asyncTest() throws InterruptedException {
        Thread.sleep(1000);
        System.out.println("我是异步的...");
        return 1;
    }

}
