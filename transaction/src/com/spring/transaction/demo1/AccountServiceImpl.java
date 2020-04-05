package com.spring.transaction.demo1;

import org.springframework.transaction.TransactionStatus;
import org.springframework.transaction.support.TransactionCallbackWithoutResult;
import org.springframework.transaction.support.TransactionTemplate;

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
    //注入事务管理模板
    private TransactionTemplate transactionTemplate;
    public void setTransactionTemplate(TransactionTemplate transactionTemplate) {
        this.transactionTemplate = transactionTemplate;
    }

    @Override
    public void transfer(final String out, final String in, final Integer money) {
//        accountDao.outMoney(out,money);
//        int i=1/0;
//        accountDao.inMoney(in,money);
        transactionTemplate.execute(new TransactionCallbackWithoutResult() {
            @Override
            protected void doInTransactionWithoutResult(TransactionStatus transactionStatus) {
                accountDao.outMoney(out,money);
                int i=1/0;
                accountDao.inMoney(in,money);
            }
        });
    }
}
