package com.st.challenge.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.sql.DataSource;

@Configuration
public class DatabaseConfiguration {

    @Value("${db_params.url}")
    private String dataBaseUrl;

    @Value("${db_params.driver}")
    private String dataBaseDriverName;

    @Value("${db_params.password}")
    private String dataBasePassword;

    @Value("${db_params.username}")
    private String dataBaseUsername;

    @Bean
    public DataSource getDataSource() {
        DataSourceBuilder dataSourceBuilder = DataSourceBuilder.create();
        dataSourceBuilder.driverClassName(dataBaseDriverName);
        dataSourceBuilder.url(dataBaseUrl);
        dataSourceBuilder.username(dataBaseUsername);
        dataSourceBuilder.password(dataBasePassword);
        return dataSourceBuilder.build();
    }
}
