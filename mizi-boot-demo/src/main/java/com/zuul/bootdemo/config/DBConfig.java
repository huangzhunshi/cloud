package com.zuul.bootdemo.config;

import com.alibaba.druid.pool.DruidDataSource;

import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.annotation.MapperScan;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;

import java.sql.SQLException;

@ComponentScan
@Configuration
@ConfigurationProperties(prefix="spring.db")
@MapperScan(basePackages = "com.zuul.bootdemo.dao", sqlSessionFactoryRef = "primarySqlSessionFactory")
public class DBConfig {

    private Logger logger = LoggerFactory.getLogger(getClass());

    private String driver;

    private String url;

    private String username;

    private String password;

    private int maxActive;

    private int maxWait;

    private int initialSize;

    private int timeBetweenEvictionRunnsMillis;

    private int maxOpenPreparedStatementPerConnectionSize;

    private int minEvictableIdleTimeMillis;

    private int minIdle;

    private String validationQuery;

    private boolean testWhileIdle;

    private boolean testOnBorrow;

    private boolean testOnReturn;

    private boolean poolPreparedStatements;

    private String connectionProperties;

    private String filters;

    @Primary
    @Bean(name = "primaryDataSource")
    public javax.sql.DataSource primaryDruidDataSource() {
        logger.info("初始化primaryDruidDataSource ------------->");
        DruidDataSource druidDataSource = new DruidDataSource();
        druidDataSource.setDriverClassName(driver);
        druidDataSource.setUrl(url);
        druidDataSource.setUsername(username);
        druidDataSource.setPassword(password);

        druidDataSource.setMaxActive(100);
        druidDataSource.setInitialSize(initialSize);
        druidDataSource.setMinIdle(minIdle);
        druidDataSource.setMaxWait(maxWait);
        druidDataSource.setTimeBetweenConnectErrorMillis(timeBetweenEvictionRunnsMillis);
        druidDataSource.setMinEvictableIdleTimeMillis(minEvictableIdleTimeMillis);
        druidDataSource.setValidationQuery(validationQuery);
        druidDataSource.setTestWhileIdle(testWhileIdle);
        druidDataSource.setTestOnBorrow(testOnBorrow);
        druidDataSource.setTestOnReturn(testOnReturn);
        druidDataSource.setPoolPreparedStatements(poolPreparedStatements);
        druidDataSource.setMaxOpenPreparedStatements(maxOpenPreparedStatementPerConnectionSize);
        druidDataSource.setConnectionProperties(connectionProperties);
        try {
            druidDataSource.setFilters(filters);
        } catch (SQLException e) {
            logger.error("druid configuration initialization filter", e);
        }
        return druidDataSource;
    }

    @Primary
    @Bean(name = "primarySqlSessionFactory")
    public SqlSessionFactory primarySqlSessionFactory(@Qualifier("primaryDataSource") javax.sql.DataSource primaryDataSource) {
        logger.info("初始化primarySqlSessionFactory ------------->");
        SqlSessionFactoryBean sqlSessionFactoryBean = new SqlSessionFactoryBean();
        sqlSessionFactoryBean.setDataSource(primaryDataSource);
        PathMatchingResourcePatternResolver resource = new PathMatchingResourcePatternResolver();
        try {
            sqlSessionFactoryBean.setMapperLocations(resource.getResources("classpath*:/mapper/*.xml"));
            sqlSessionFactoryBean.setConfigLocation(resource.getResource("classpath:/db/mybatis-config.xml"));
            return sqlSessionFactoryBean.getObject();
        } catch (Exception e) {
            logger.error("初始化SqlSessionFactory失败",e);
            throw new RuntimeException();
        }
    }

    @Primary
    @Bean(name = "transactionManager")
    public DataSourceTransactionManager primaryTransactionManager(@Qualifier("primaryDataSource") javax.sql.DataSource primaryDataSource) {
        return new DataSourceTransactionManager(primaryDataSource);
    }
}
