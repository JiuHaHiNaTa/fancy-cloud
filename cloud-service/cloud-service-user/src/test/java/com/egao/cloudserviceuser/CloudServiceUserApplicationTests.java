package com.egao.cloudserviceuser;

import com.egao.cloudserviceuser.entity.User;
import com.egao.cloudserviceuser.mapper.UserMapper;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import javax.annotation.Resource;

@SpringBootTest
class CloudServiceUserApplicationTests {

    @Resource
    UserMapper mapper;

    @Test
    void contextLoads() {
        User user = new User();
        user.setUsername("test");
        user.setPassword("1997");
        user.setNickname("测试");
        mapper.save(user);
    }

}
