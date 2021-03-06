package com.cowboy.sbe.web.common.config;/**
 * Created by Administrator on 2017/11/6/0006.
 */

import com.github.pagehelper.PageHelper;
import lombok.extern.slf4j.Slf4j;
import org.apache.ibatis.plugin.Interceptor;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.Resource;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;
import org.springframework.core.io.support.ResourcePatternResolver;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.TransactionManagementConfigurer;

import javax.sql.DataSource;
import java.io.IOException;
import java.util.Properties;

/**
 * @author Tangynbo
 * @version 1.0
 * @create 2017-11-06 16:02
 **/
@Configuration
@Slf4j
public class MybatisConfig implements TransactionManagementConfigurer {
    @Autowired
    private DataSource dataSource;
    @Value("${mybatis.configLocation}")
    private String configLocation;
    @Value("${mybatis.mapperLocations}")
    private String mapperLocations;

    @Bean(name = "sqlSessionFactory")
    public SqlSessionFactoryBean sqlSessionFactoryBean() {
        try{
            SqlSessionFactoryBean sqlSessionFactoryBean = new SqlSessionFactoryBean();
            sqlSessionFactoryBean.setDataSource(dataSource);
            //mybaitis 配置文件
            ResourcePatternResolver resourcePatternResolver = new PathMatchingResourcePatternResolver();
            Resource resource = resourcePatternResolver.getResource(configLocation);
            sqlSessionFactoryBean.setConfigLocation(resource);
            //mybati mapper 文件路径
            sqlSessionFactoryBean.setMapperLocations(new PathMatchingResourcePatternResolver().getResources(mapperLocations));

            //分页插件
            PageHelper pageHelper = new PageHelper();
            Properties props = new Properties();
            props.setProperty("reasonable", "true");
            props.setProperty("supportMethodsArguments", "true");
            props.setProperty("returnPageInfo", "check");
            props.setProperty("params", "count=countSql");
            pageHelper.setProperties(props);

            //添加插件
            sqlSessionFactoryBean.setPlugins(new Interceptor[]{pageHelper});
            return sqlSessionFactoryBean;
        }catch (IOException e) {
            log.error("mybatis resolver mapper*xml is error",e);
            return null;
        } catch (Exception e) {
            log.error("mybatis sqlSessionFactoryBean create error",e );
            return null;
        }
    }

  /*  @Bean
    public SqlSessionTemplate sqlSessionTemplate(SqlSessionFactory sqlSessionFactory) {
        return new SqlSessionTemplate(sqlSessionFactory);
    }*/

    @Override
    public PlatformTransactionManager annotationDrivenTransactionManager() {
        return new DataSourceTransactionManager(dataSource);
    }
}
