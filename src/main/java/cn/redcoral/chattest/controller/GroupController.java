package cn.redcoral.chattest.controller;

import cn.redcoral.messageplus.manage.MessageManage;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @author mo
 * @Description:
 * @日期: 2024-05-26 20:59
 **/
@RestController()
@RequestMapping("/group")
public class GroupController {


    @PostMapping()
    public String createGroup(String createUserId, String name, @RequestBody List<String> clientIds) {
        return MessageManage.createGroup(createUserId, name, clientIds).getId();
    }

}
