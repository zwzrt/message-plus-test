package cn.redcoral.chattest;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.scheduling.annotation.Async;

@SpringBootTest
class ChatTestApplicationTests {

    @Autowired
    private AsyncTest asyncTest;

    @Test
    void contextLoads() throws InterruptedException {
        asyncTest.asyncTest();
    }

}
