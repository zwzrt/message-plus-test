package cn.redcoral.chattest;

import cn.redcoral.messageplus.entity.Group;
import cn.redcoral.messageplus.port.GroupInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Component;

/**
 * 群组管理
 * @author mo
 * @日期: 2024-06-11 20:42
 **/
@Component
public class MyGroupInterface implements GroupInterface {

    @Autowired
    private StringRedisTemplate stringRedisTemplate;

    /**
     * 开发者自定义的群组查询接口（二级）
     * @param groupId 群组ID
     * @return 群组
     */
    @Override
    public Group getGroupInCustom(String groupId) {
        return null;
    }

}
