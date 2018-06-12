package so.springboot.atomikos.atomikosdemo.config;

import com.alibaba.druid.pool.DruidDataSource;
import com.alibaba.druid.pool.xa.DruidXADataSource;
import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.SqlSessionTemplate;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.jta.atomikos.AtomikosDataSourceBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.core.env.Environment;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;

import javax.sql.DataSource;
import javax.sql.XADataSource;

@Configuration
@MapperScan(basePackages = "so.springboot.atomikos.atomikosdemo.dao", sqlSessionTemplateRef = "testSqlSessionTemplateSystemDB")
public class DBSystemConfig {

    @Autowired
    private Environment env;

//    @ConfigurationProperties(prefix = "spring.datasource.druid.system")
//    @Bean(name = "systemDruidXA")
//    public DruidXADataSource createDruidDataSource() {
//        return new DruidXADataSource();
//    }

    @Bean(name = "systemdb")
    @Autowired
    @Primary
    @ConfigurationProperties(prefix = "spring.datasource.druid.system")
    public DataSource getSystemDataSource(){
        DruidXADataSource druidDataSource=getDataSource("spring.datasource.druid.system.");
        AtomikosDataSourceBean ds = new AtomikosDataSourceBean();
        ds.setXaDataSource(druidDataSource);
        return ds;

        //DruidXADataSource druidXADataSource=createDruidDataSource();
        //AtomikosDataSourceBean ds = new AtomikosDataSourceBean();
        //return ds;
    }

    @Bean(name = "testSqlSessionSystemDB")
    public SqlSessionFactory testSqlSessionFactory(@Qualifier("systemdb") DataSource dataSource)
            throws Exception {
        SqlSessionFactoryBean bean = new SqlSessionFactoryBean();
        PathMatchingResourcePatternResolver resource = new PathMatchingResourcePatternResolver();

        bean.setMapperLocations(resource.getResources("classpath*:/mapper/*.xml"));

        bean.setDataSource(dataSource);
        return bean.getObject();
    }

    @Bean(name = "testSqlSessionTemplateSystemDB")
    public SqlSessionTemplate testSqlSessionTemplate(
            @Qualifier("testSqlSessionSystemDB") SqlSessionFactory sqlSessionFactory) throws Exception {
        return new SqlSessionTemplate(sqlSessionFactory);
    }



    /**
     *
     * @param prefix
     * @return
     */
    private DruidXADataSource getDataSource(String prefix){
        DruidXADataSource druidDataSource= new DruidXADataSource();
       // DruidDataSource druidDataSource=new DruidDataSource();
        druidDataSource.setMaxActive(env.getProperty(prefix + "maxActive", Integer.class));
        druidDataSource.setUrl(env.getProperty(prefix + "url"));
        druidDataSource.setUsername(env.getProperty(prefix + "username"));
        druidDataSource.setPassword(env.getProperty(prefix + "password"));
        druidDataSource.setDriverClassName(env.getProperty(prefix + "driverClassName"));
        druidDataSource.setPoolPreparedStatements(env.getProperty(prefix + "poolPreparedStatements", Boolean.class));
        druidDataSource.setMaxPoolPreparedStatementPerConnectionSize(env.getProperty(prefix + "maxPoolPreparedStatementPerConnectionSize", Integer.class));
        druidDataSource.setValidationQuery(env.getProperty(prefix+"validationQuery"));
        druidDataSource.setValidationQueryTimeout(env.getProperty(prefix + "validationQueryTimeout", Integer.class));
        druidDataSource.setInitialSize(env.getProperty(prefix + "initialSize", Integer.class));

        return druidDataSource;
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
  //      return null;
    }
}
