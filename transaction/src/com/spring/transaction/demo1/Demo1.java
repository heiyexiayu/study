package com.spring.transaction.demo1;

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
@ContextConfiguration("classpath:applicationContext.xml")
public class Demo1 {
    @Resource(name = "accountService")
    private AccountService accountService;

    @Test
    public void demo(){
        accountService.transfer("aaa","bbb",20);
    }
}
