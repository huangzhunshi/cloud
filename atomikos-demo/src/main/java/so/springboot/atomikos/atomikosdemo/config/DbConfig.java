//package so.springboot.atomikos.atomikosdemo.config;
//
//import com.alibaba.druid.pool.DruidDataSource;
//import com.atomikos.icatch.jta.UserTransactionImp;
//import com.atomikos.icatch.jta.UserTransactionManager;
//import com.atomikos.jdbc.AtomikosDataSourceBean;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.context.properties.ConfigurationProperties;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.context.annotation.Primary;
//import org.springframework.core.env.Environment;
//import org.springframework.transaction.jta.JtaTransactionManager;
//
//import javax.sql.DataSource;
//import javax.transaction.UserTransaction;
//import java.util.Properties;
//
//@Configuration
//public class DbConfig {
//
//    @Autowired
//    private Environment env;
//
//    @Primary
//    @Bean(name = "systemDataSource")
//    @Autowired
//    public DataSource getGidDataSource(){
//        AtomikosDataSourceBean ds = new AtomikosDataSourceBean();
//        Properties prop = build(env, "spring.datasource.druid.systemDB.");
//        ds.setXaDataSourceClassName("com.alibaba.druid.pool.xa.DruidXADataSource");
//        ds.setUniqueResourceName("systemDB");
//        ds.setPoolSize(5);
//        ds.setXaProperties(prop);
//        return ds;
//    }
//
//    /**
//     * 注入事物管理器
//     * @return
//     */
//    @Bean(name = "xatx")
//    public JtaTransactionManager regTransactionManager () {
//        UserTransactionManager userTransactionManager = new UserTransactionManager();
//        UserTransaction userTransaction = new UserTransactionImp();
//        return new JtaTransactionManager(userTransaction, userTransactionManager);
//    }
//
//
//    private Properties build(Environment env, String prefix) {
//        Properties prop = new Properties();
//        prop.put("url", env.getProperty(prefix + "url"));
//        prop.put("username", env.getProperty(prefix + "username"));
//        prop.put("password", env.getProperty(prefix + "password"));
//        prop.put("driverClassName", env.getProperty(prefix + "driverClassName", ""));
//        prop.put("initialSize", env.getProperty(prefix + "initialSize", Integer.class));
//        prop.put("maxActive", env.getProperty(prefix + "maxActive", Integer.class));
//        prop.put("minIdle", env.getProperty(prefix + "minIdle", Integer.class));
//        prop.put("maxWait", env.getProperty(prefix + "maxWait", Integer.class));
//        prop.put("poolPreparedStatements", env.getProperty(prefix + "poolPreparedStatements", Boolean.class));
//
//        prop.put("maxPoolPreparedStatementPerConnectionSize",
//                env.getProperty(prefix + "maxPoolPreparedStatementPerConnectionSize", Integer.class));
//
//        prop.put("maxPoolPreparedStatementPerConnectionSize",
//                env.getProperty(prefix + "maxPoolPreparedStatementPerConnectionSize", Integer.class));
//        prop.put("validationQuery", env.getProperty(prefix + "validationQuery"));
//        prop.put("validationQueryTimeout", env.getProperty(prefix + "validationQueryTimeout", Integer.class));
//        prop.put("testOnBorrow", env.getProperty(prefix + "testOnBorrow", Boolean.class));
//        prop.put("testOnReturn", env.getProperty(prefix + "testOnReturn", Boolean.class));
//        prop.put("testWhileIdle", env.getProperty(prefix + "testWhileIdle", Boolean.class));
//        prop.put("timeBetweenEvictionRunsMillis",
//                env.getProperty(prefix + "timeBetweenEvictionRunsMillis", Integer.class));
//        prop.put("minEvictableIdleTimeMillis", env.getProperty(prefix + "minEvictableIdleTimeMillis", Integer.class));
//        prop.put("filters", env.getProperty(prefix + "filters"));
//
//        return prop;
//    }
//
// //   private DataSource getDataSource(String prefix){
////        prop.put("url", env.getProperty(prefix + "url"));
////        prop.put("username", env.getProperty(prefix + "username"));
////        prop.put("password", env.getProperty(prefix + "password"));
////        prop.put("driverClassName", env.getProperty(prefix + "driverClassName", ""));
////        prop.put("initialSize", env.getProperty(prefix + "initialSize", Integer.class));
////        prop.put("maxActive", env.getProperty(prefix + "maxActive", Integer.class));
////        prop.put("minIdle", env.getProperty(prefix + "minIdle", Integer.class));
////        prop.put("maxWait", env.getProperty(prefix + "maxWait", Integer.class));
////        prop.put("poolPreparedStatements", env.getProperty(prefix + "poolPreparedStatements", Boolean.class));
////
////        prop.put("maxPoolPreparedStatementPerConnectionSize",
////                env.getProperty(prefix + "maxPoolPreparedStatementPerConnectionSize", Integer.class));
////
////        prop.put("maxPoolPreparedStatementPerConnectionSize",
////                env.getProperty(prefix + "maxPoolPreparedStatementPerConnectionSize", Integer.class));
////        prop.put("validationQuery", env.getProperty(prefix + "validationQuery"));
////        prop.put("validationQueryTimeout", env.getProperty(prefix + "validationQueryTimeout", Integer.class));
////        prop.put("testOnBorrow", env.getProperty(prefix + "testOnBorrow", Boolean.class));
////        prop.put("testOnReturn", env.getProperty(prefix + "testOnReturn", Boolean.class));
////        prop.put("testWhileIdle", env.getProperty(prefix + "testWhileIdle", Boolean.class));
////        prop.put("timeBetweenEvictionRunsMillis",
////                env.getProperty(prefix + "timeBetweenEvictionRunsMillis", Integer.class));
////        prop.put("minEvictableIdleTimeMillis", env.getProperty(prefix + "minEvictableIdleTimeMillis", Integer.class));
////        prop.put("filters", env.getProperty(prefix + "filters"));
// //   }
//}
