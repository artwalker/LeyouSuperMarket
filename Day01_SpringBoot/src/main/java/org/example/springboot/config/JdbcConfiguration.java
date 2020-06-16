package org.example.springboot.config;

import com.alibaba.druid.pool.DruidDataSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

import javax.sql.DataSource;

/**
 * @author HackerStar
 * @create 2020-05-31 20:52
 */
@Configuration
//@PropertySource("classpath:jdbc.properties")
@EnableConfigurationProperties(JdbcProperties.class)
public class JdbcConfiguration {
//    @Value("${jdbc.url}")
//    String url;
//    @Value("${jdbc.driverClassName}")
//    String driverClassName;
//    @Value("${jdbc.username}")
//    String username;
//    @Value("${jdbc.password}")
//    String password;

//    @Autowired
//    private JdbcProperties jdbcProperties;

//    private JdbcProperties jdbcProperties;
//
//    public JdbcConfiguration(JdbcProperties jdbcProperties) {
//        this.jdbcProperties = jdbcProperties;
//    }

//    @Bean
//    public DataSource dataSource(JdbcProperties jdbcProperties) {
//        DruidDataSource dataSource = new DruidDataSource();
//        dataSource.setUrl(jdbcProperties.getUrl());
//        dataSource.setDriverClassName(jdbcProperties.getDriverClassName());
//        dataSource.setUsername(jdbcProperties.getUsername());
//        dataSource.setPassword(jdbcProperties.getPassword());
//        return dataSource;
//    }

    @Bean
    @ConfigurationProperties(prefix = "jdbc")
    public DataSource dataSource() {
        DruidDataSource dataSource = new DruidDataSource();
        return dataSource;
    }
}
