package com.spring.transaction.demo3;


/**
 * @Author create by  huarong
 * @Date ${Date} ${Time}
 */
public class AccountServiceImpl implements AccountService {
   //注入
    private AccountDao accountDao;
    public void setAccountDao(AccountDao accountDao) {
        this.accountDao = accountDao;
    }

    @Override
    public void transfer( String out,  String in,  Integer money) {
        accountDao.outMoney(out,money);
        int i=1/0;
        accountDao.inMoney(in,money);
    }
}
