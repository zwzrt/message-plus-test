package cn.redcoral.chattest;

import org.springframework.context.annotation.Configuration;

/**
 * @author mo
 * @日期: 2024-09-07 13:36
 **/
@Configuration
public class InterfAbst implements Interf {
    public  void sout() {
        System.out.println("是我");
    }
}
