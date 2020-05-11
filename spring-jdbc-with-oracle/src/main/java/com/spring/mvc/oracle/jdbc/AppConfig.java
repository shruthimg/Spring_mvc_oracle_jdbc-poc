package com.spring.mvc.oracle.jdbc;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

import javax.sql.DataSource;

@Configuration
@ComponentScan
public class AppConfig {
    @Bean
    public DataSource dataSource() {
        DriverManagerDataSource ds = new DriverManagerDataSource();
        ds.setDriverClassName(oracle.jdbc.driver.OracleDriver.class.getName());
        ds.setUrl("jdbc:oracle:thin:@localhost:1521:xe");
        ds.setUsername("system");
        ds.setPassword("system");
        return ds;
    }

    public static void main(String[] args) {
        AnnotationConfigApplicationContext context =
                new AnnotationConfigApplicationContext(AppConfig.class);
        context.getBean(EmployeeClient.class).process();
    }
}
