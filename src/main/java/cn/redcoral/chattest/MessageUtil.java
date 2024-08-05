package cn.redcoral.chattest;

import cn.hutool.http.server.HttpServerRequest;
import cn.redcoral.messageplus.entity.Message;
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
    public boolean onMessageCheck(HttpServerRequest request, Message message) throws Exception {
        return true;
    }

    @Override
    public void onFailedMessage(Message message) {

    }

    @Override
    public void onMessageBySystem(String senderId, String message) {
    }
}
