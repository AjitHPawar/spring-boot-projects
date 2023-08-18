package com.spring.config;


import lombok.extern.java.Log;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import java.sql.SQLException;

@Configuration
@Log
public class ProfileConfig {
    @Profile("local")
    @Bean
    public Object inMemoryDataSource() {
        log.info("Setting up H2 DataSource");

        return null;
    }

    @Profile("dev")
    @Bean
    public Object mysqlDataSource() {
        log.info("Setting up MySql DataSource.......By Ajit");

        return null;
    }

    @Profile("prod")
    @Bean
    public Object oracleDataSource() throws SQLException {
        log.info("Setting up Oracle DataSource");
        return null;
    }

}
