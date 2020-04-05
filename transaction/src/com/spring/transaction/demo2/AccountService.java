package com.spring.transaction.demo2;

/**
 * @Author create by  huarong
 * @Date ${Date} ${Time}
 */
public interface AccountService {
    public void transfer(String out, String in, Integer money);
}
