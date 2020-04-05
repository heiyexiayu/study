package com.spring.transaction.demo3;

import com.spring.transaction.demo4.AccountService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.annotation.Resource;

/**
 * @Author create by  huarong
 * @Date ${Date} ${Time}
 * 基于AspectJ
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:applicationContext3.xml")
public class Demo3 {
    @Resource(name = "accountService")
    private AccountService accountService;
    @Test
    public void demo1(){
        accountService.transfer("aaa","bbb",20);
    }
}
