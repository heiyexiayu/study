package com.spring.transaction.demo2;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.annotation.Resource;

/**
 * @Author create by  huarong
 * @Date ${Date} ${Time}
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:applicationContext2.xml")
public class Demo2 {
    //注入代理类
    //@Resource(name = "accountService")
    @Resource(name = "accountServiceProxy")
    private AccountService accountService;


    @Test
    public void demo2(){
       accountService.transfer("aaa","bbb",20);
    }
}
