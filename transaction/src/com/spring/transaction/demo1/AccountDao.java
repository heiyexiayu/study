package com.spring.transaction.demo1;

/**
 * @Author create by  huarong
 * @Date ${Date} ${Time}
 */
public interface AccountDao {
    public void outMoney(String out,Integer money);
    public void inMoney(String in,Integer money);
}
