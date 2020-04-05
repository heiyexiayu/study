package com.spring.transaction.demo3;

import org.springframework.jdbc.core.support.JdbcDaoSupport;


/**
 * @Author create by  huarong
 * @Date ${Date} ${Time}
 */
public class AccountDaoImpl extends JdbcDaoSupport implements AccountDao {
    @Override
    public void outMoney(String out, Integer money) {
        String sql="update dog set age=age - ?  where name= ?";
        this.getJdbcTemplate().update(sql,money,out);
    }

    @Override
    public void inMoney(String in, Integer money) {
        String sql="update dog set age=age + ? where name= ?";
        this.getJdbcTemplate().update(sql,money,in);
    }
}
