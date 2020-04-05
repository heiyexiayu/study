package com.spring.transaction.demo3;

/**
 * @Author create by  huarong
 * @Date ${Date} ${Time}
 */
public interface AccountDao {
     void outMoney(String out, Integer money);
     void inMoney(String in, Integer money);
}
