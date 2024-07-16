package cn.redcoral.chattest;

import cn.redcoral.chattest.entity.FriendMsg;
import cn.redcoral.chattest.entity.GroupMsg;
import cn.redcoral.messageplus.port.MessagePlusBase;
import cn.redcoral.messageplus.utils.MessagePlusUtils;
import com.alibaba.fastjson.JSON;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import javax.websocket.*;
import javax.websocket.server.ServerEndpoint;
import java.util.List;

/**
 * @author mo
 * @Description:
 * @日期: 2024-05-25 14:21
 **/
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
    public boolean onMessage(Object message, Session session) {
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
        return false;
    }

    @Override
    public boolean onMessageBySingle(Object message, Session session) {
//        System.out.println("单发");
        FriendMsg friendMsg = JSON.parseObject(message.toString(), FriendMsg.class);
        return MessagePlusUtils.sendMessage(friendMsg.getFriendId(), friendMsg.getMsg());
    }

    @Override
    public List<String> onMessageByMass(Object message, Session session) {
//        System.out.println("群发");
        GroupMsg groupMsg = JSON.parseObject(message.toString(), GroupMsg.class);
        // 群发
        return MessagePlusUtils.sendMessageToGroupBarringMe(this.client_id, groupMsg.getGroupId(), groupMsg.getMsg());
    }

    @Override
    public boolean onMessageBySystem(Object message, Session session) {
        return true;
    }

    /**
     * 收到收件箱的单发消息
     */
    @Override
    public void onMessageByInboxAndSingle(Object message, Session session) {
        FriendMsg friendMsg = JSON.parseObject(message.toString(), FriendMsg.class);
        MessagePlusUtils.sendMessage(client_id, friendMsg.getMsg());
    }
    /**
     * 收到收件箱的群发消息
     */
    @Override
    public void onMessageByInboxAndByMass(Object message, Session session) {
        GroupMsg groupMsg = JSON.parseObject(message.toString(), GroupMsg.class);
        MessagePlusUtils.sendMessage(client_id, groupMsg.getMsg());
    }
    /**
     * 收到收件箱的系统消息
     */
    @Override
    public void onMessageByInboxAndSystem(Object message, Session session) {

    }

    @Override
    public void onError(Session session, Throwable error) {
        System.out.println("连接错误");
//        ChatUtils chatUtils = ChatTestApplication.context.getBean(ChatUtils.class);
//        System.out.println(chatUtils);
        error.printStackTrace();
    }
}
