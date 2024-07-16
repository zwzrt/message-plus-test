package cn.redcoral.chattest.controller;

import cn.redcoral.messageplus.utils.MessagePlusUtils;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @author mo
 * @Description:
 * @日期: 2024-05-26 20:59
 **/
@Controller
@RequestMapping
public class IndexController {


    @GetMapping("/")
    public String index(Model model) {
        return "index";
    }

    @GetMapping("/websocket")
    public String websocket(Model model) {
        return "websocket";
    }

    @GetMapping("/websocket-test")
    public String websocketTest(Model model) {
        return "websocket-test";
    }

    @GetMapping("/group-test")
    public String groupTest(Model model) {
        return "group-test";
    }

}
