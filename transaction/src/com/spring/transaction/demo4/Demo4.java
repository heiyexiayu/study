package com.spring.transaction.demo4;

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
@ContextConfiguration("classpath:applicationContext4.xml")
public class Demo4 {
    @Resource
    private AccountService accountService;
    @Test
    public void demo4(){
        accountService.transfer("aaa","bbb",20);
    }
}
