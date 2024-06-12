package cn.redcoral.chattest;

import cn.redcoral.chattest.entity.FriendMsg;
import cn.redcoral.chattest.entity.GroupMsg;
import cn.redcoral.messageplus.port.MessagePlusBase;
import cn.redcoral.messageplus.utils.ChatUtils;
import cn.redcoral.messageplus.utils.SpringUtils;
import com.alibaba.fastjson.JSON;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import javax.websocket.*;
import javax.websocket.server.ServerEndpoint;

/**
 * @author mo
 * @Description:
 * @日期: 2024-05-25 14:21
 **/
@Component
@Slf4j
@Service
@ServerEndpoint("/api/websocket/{sid}")
public class MessageUtil extends MessagePlusBase {

    @Override
    public void onOpen(Session session,  String sid) {
        System.out.println("连接成功");
    }

    @Override
    public void onClose() {
        System.out.println("断开连接");
    }

    @Override
    public void onMessage(Object message, Session session) {
//        String type= JSON.parseObject(message.toString()).get("type").toString();
//        switch (type) {
//            case "": return;
//            case "friend": {
//                System.out.println("单发");
//                FriendMsg friendMsg1 = JSON.parseObject(message.toString(), FriendMsg.class);
//            }
//            case "group": {
//                System.out.println("群发");
//                GroupMsg groupMsg = JSON.parseObject(message.toString(), GroupMsg.class);
//                // 群发
//                ChatUtils.sendMessageToGroup(groupMsg.getGroupId(), groupMsg.getMsg());
//            }
//        }
////        ChatUtils.sendMessage(friendMsg.getFriendId(), friendMsg.getMsg());
////        ChatUtils.sendMessageToGroup();
//        System.out.println(message);
    }

    @Override
    public void onMessageBySingle(Object message, Session session) {
        System.out.println("单发");
        FriendMsg friendMsg = JSON.parseObject(message.toString(), FriendMsg.class);
        ChatUtils.sendMessage(friendMsg.getFriendId(), friendMsg.getMsg());
    }

    @Override
    public void onMessageByMass(Object message, Session session) {
        System.out.println("群发");
        GroupMsg groupMsg = JSON.parseObject(message.toString(), GroupMsg.class);
        // 群发
        ChatUtils.sendMessageToGroup(groupMsg.getGroupId(), groupMsg.getMsg());
    }

    @Override
    public void onMessageBySystem(Object message, Session session) {

    }

    @Override
    public void onError(Session session, Throwable error) {
        System.out.println("连接错误");
        ChatUtils chatUtils = ChatTestApplication.context.getBean(ChatUtils.class);
        System.out.println(chatUtils);
        error.printStackTrace();
    }
}
