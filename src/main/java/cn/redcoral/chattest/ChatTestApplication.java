package cn.redcoral.chattest;

import cn.redcoral.messageplus.entity.Group;
import cn.redcoral.messageplus.utils.ChatUtils;
import cn.redcoral.messageplus.EnableMessagePlus;
import cn.redcoral.messageplus.utils.GroupManage;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

import java.util.Arrays;

@Slf4j
@SpringBootApplication
@EnableMessagePlus // 开启message增强
public class ChatTestApplication {

    public static ApplicationContext context;

    public static String groupId = "";

    public static void main(String[] args) {
        context = SpringApplication.run(ChatTestApplication.class, args);

        /**
         * 初始化
         */
        log.info("开始初始化...");

        // 创建群组
//        Group group = ChatUtils.createGroup("001", "相亲相爱一家人", Arrays.asList("002", "003"));
//        groupId = group.getId();
        log.info("群组ID：{}", groupId);

        log.info("初始化完成...");

        log.info("访问地址：http://localhost:8080/");
    }

}
