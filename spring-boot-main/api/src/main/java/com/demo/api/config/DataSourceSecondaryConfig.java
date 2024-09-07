package com.demo.api.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.transaction.annotation.EnableTransactionManagement;

//@Configuration
//@EnableTransactionManagement
//@EnableJpaRepositories(
//        basePackages = "com.demo.domain.repository.secandary",
//        entityManagerFactoryRef = "secandaryEntityManagerFactory",
//        transactionManagerRef = "secandaryTransactionManager"
//)
public class DataSourceSecondaryConfig {
}
