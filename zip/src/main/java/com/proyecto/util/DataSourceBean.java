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
                .url("jdbc:mysql://containers-us-west-101.railway.app:6611/railway")
                .username("root")
                .password("GpOw23JDDoZlsLF98AQ2")
                .driverClassName("com.mysql.cj.jdbc.Driver")
                .build();
    }
}
