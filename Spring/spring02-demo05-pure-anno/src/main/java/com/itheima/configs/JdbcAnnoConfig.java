package com.itheima.configs;

import com.alibaba.druid.pool.DruidDataSource;
import org.apache.commons.dbutils.QueryRunner;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

/**
 * 跟数据库相关的配置信息
 *
 * @PropertySource 引入配置文件, 结合@Value("${xxx}") xxx 是配置文件中的key
 */
@PropertySource(value = "jdbc.properties")
public class JdbcAnnoConfig {
    @Value("${jdbc.url}")
    private String url;
    @Value("${jdbc.driver}")
    private String driverName;
    @Value("${jdbc.username}")
    private String username;
    @Value("${jdbc.password}")
    private String password;

    /**
     * @Bean 告诉IOC容器这是一个需要初始化且需要注册的JavaBean
     * 默认初始化出来的bean的id是方法名称
     * @Bean.value 指定bean的id, value可以不写
     */
    @Bean("dataSource01")
    public DruidDataSource getDataSource01() {
        DruidDataSource dataSource = new DruidDataSource();
        dataSource.setUrl(url);
        dataSource.setDriverClassName(driverName);
        dataSource.setUsername(username);
        dataSource.setPassword(password);
        return dataSource;
    }

    @Bean("dataSource02")
    public DruidDataSource getDataSource02() {
        DruidDataSource dataSource = new DruidDataSource();
        dataSource.setUrl(url);
        dataSource.setDriverClassName(driverName);
        dataSource.setUsername(username);
        dataSource.setPassword(password);
        return dataSource;
    }

    /*  *//**
     * 当所需要的DruidDataSource在IOC容器中只有一个的时候,方法的形参无所谓,任意都行
     * 当所需要的DruidDataSource在IOC容器中有多个的时候,方法的形参无所谓,任意都行,但是需要加上@Qualifier("xxx"),xxx是要使用的Bean的Id
     *
     *//*
    @Bean("queryRunner")
    public QueryRunner getQueryRunner(@Qualifier("dataSource02") DruidDataSource dataSource011) {
        QueryRunner queryRunner = new QueryRunner(dataSource011);
        return queryRunner;
    }*/

    /**
     * 当所需要的DruidDataSource在IOC容器中有多个的时候,不适用@Qualifier,形参的名称必须写成和某一个Bean的Id一致
     */
    @Bean("queryRunner")
    public QueryRunner getQueryRunner(DruidDataSource dataSource01) {
        QueryRunner queryRunner = new QueryRunner(dataSource01);
        return queryRunner;
    }
}
