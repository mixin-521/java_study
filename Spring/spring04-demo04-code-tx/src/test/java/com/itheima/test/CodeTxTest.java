package com.itheima.test;

import com.zaxxer.hikari.HikariDataSource;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.transaction.TransactionStatus;
import org.springframework.transaction.support.TransactionCallback;
import org.springframework.transaction.support.TransactionTemplate;

public class CodeTxTest {
    public static void main(String[] args) {
        //1. 创建数据源
        HikariDataSource dataSource = new HikariDataSource();
        dataSource.setDriverClassName("com.mysql.jdbc.Driver");
        dataSource.setJdbcUrl("jdbc:mysql://47.105.158.112:10007/studytest?characterEncoding=utf8");
        dataSource.setUsername("root");
        dataSource.setPassword("zd521707");
        //2. 创建jdbc模版
        final JdbcTemplate jdbcTemplate = new JdbcTemplate();
        jdbcTemplate.setDataSource(dataSource);
        //3.创建事务管理器
        DataSourceTransactionManager transactionManager = new DataSourceTransactionManager();
        transactionManager.setDataSource(dataSource);
        //4.创建事务模版
        TransactionTemplate transactionTemplate = new TransactionTemplate();
        transactionTemplate.setTransactionManager(transactionManager);
        //4. 进行事务操作
        transactionTemplate.execute(new TransactionCallback<Object>() {
            @Override
            public Object doInTransaction(TransactionStatus status) {
                //操作数据库
                jdbcTemplate.update("update t_account set money = money - ? where name = ?  ", 100.0, "zs");

                int i = 1/0;

                jdbcTemplate.update("update t_account set money = money + ? where name = ?  ", 100.0, "ls");
                return null;
            }
        });
    }

}
