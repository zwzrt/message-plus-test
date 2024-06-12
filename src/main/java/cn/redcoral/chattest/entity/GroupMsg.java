package cn.redcoral.chattest.entity;

import lombok.Data;

/**
 * 群组消息类
 * @author mo
 * @日期: 2024-05-26 22:01
 **/
@Data
public class GroupMsg {
    private String groupId;
    private String msg;
}
