package com.cglib;

/**
 * @Author WYMY
 * @Date 2019/5/13 14:21
 */
public class Test {
    public static void main(String[] args) {
        //目标对象
        UserDao target = new UserDao();
        //代理对象
        UserDao proxy = (UserDao) new ProxyFactory(target).getProxyInstance();
        //执行代理对象方法
        proxy.save();
    }
}
