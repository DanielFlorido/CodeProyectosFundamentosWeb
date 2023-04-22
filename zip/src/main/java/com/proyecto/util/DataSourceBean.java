package com.proyecto.util;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

import javax.sql.DataSource;

@Configuration
@Component
public class DataSourceBean {

    @ConfigurationProperties(prefix = "spring.datasource")
    @Bean
    @Primary
    public DataSource getDataSource(){
        return DataSourceBuilder
                .create()
                .url("jdbc:mysql://172.17.0.2:3306/proyecto")
                .username("root")
                .password("12")
                .driverClassName("com.mysql.cj.jdbc.Driver")
                .build();
    }
}
