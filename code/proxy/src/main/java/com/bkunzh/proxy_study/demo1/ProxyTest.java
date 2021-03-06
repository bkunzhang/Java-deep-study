package com.bkunzh.proxy_study.demo1;

import com.bkunzh.proxy_study.demo1.UserService;
import com.bkunzh.proxy_study.demo1.UserServiceHandler;
import com.bkunzh.proxy_study.demo1.UserServiceImpl;
import org.junit.Test;

import java.lang.reflect.Proxy;

/**
 * @author bkunzhang
 * @date 2019/9/19
 */
public class ProxyTest {
    @Test
    public void t() {
        UserService userService = new UserServiceImpl();
        UserServiceHandler userServiceHandler = new UserServiceHandler(userService);
        //创建动态代理类
        UserService userServiceProxy = (UserService) Proxy.newProxyInstance(userService.getClass().getClassLoader(),
                userService.getClass().getInterfaces(), userServiceHandler);

        userServiceProxy.save(88);
        userServiceProxy.delete(9);
    }
}
