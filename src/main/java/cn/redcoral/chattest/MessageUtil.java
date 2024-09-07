package cn.redcoral.chattest;

import cn.hutool.http.server.HttpServerRequest;
import cn.redcoral.messageplus.data.entity.message.Message;
import cn.redcoral.messageplus.port.MessagePlusBase;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import javax.websocket.Session;


/**
 * @author mo
 **/
@Slf4j
@Service
public class MessageUtil implements MessagePlusBase {

    @Override
    public String onOpen(Session session, String sid) {
        System.out.println("连接成功");
        return sid;
    }

    @Override
    public void onClose(String sid) {
        System.out.println("断开连接");
    }

    @Override
    public void onMessageBySystem(String senderId, String message) {
    }

    @Override
    public String login(String username, String password) {
        if ("123456".equals(username) && "123456".equals(password)) {
            return "123456";
        } else return null;
    }
}
