package cn.redcoral.chattest;

import cn.hutool.http.server.HttpServerRequest;
import cn.redcoral.messageplus.entity.MessageType;
import cn.redcoral.messageplus.port.MessagePlusBase;
import cn.redcoral.messageplus.utils.MessagePlusUtils;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import javax.websocket.*;

/**
 * @author mo
 * @Description:
 * @日期: 2024-05-25 14:21
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
    public boolean onMessageCheck(HttpServerRequest request, String senderId, MessageType mt) {
        return true;
    }

    @Override
    public void onMessageBySystem(String senderId, Object message) {

    }

    @Override
    public boolean onMessageByInboxAndSingle(String senderId, String receiverId, Object message) {
        return MessagePlusUtils.sendMessage(receiverId, message.toString());
    }

    @Override
    public boolean onMessageByInboxAndByMass(String senderId, String groupId, String receiverId, Object message) {
        if (senderId.equals(receiverId)) return true;
        return MessagePlusUtils.sendMessage(receiverId, message.toString());
    }

    @Override
    public void onError(Session session, Throwable error) {
        System.out.println("连接错误");
        error.printStackTrace();
    }
}
