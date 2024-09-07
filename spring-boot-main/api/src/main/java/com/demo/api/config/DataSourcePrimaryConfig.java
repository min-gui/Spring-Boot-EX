package com.demo.api.config;


import jakarta.persistence.EntityManagerFactory;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.boot.orm.jpa.EntityManagerFactoryBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import javax.sql.DataSource;
import java.util.HashMap;
import java.util.Map;

@Configuration
@EnableTransactionManagement
@EnableJpaRepositories(
        basePackages = "com.demo.domain.repository.primary",
        entityManagerFactoryRef = "primaryEntityManagerFactory",
        transactionManagerRef = "primaryTransactionManager"
)
public class DataSourcePrimaryConfig {
    @Primary
    @Bean(name = "primaryDataSource")
    @ConfigurationProperties(prefix = "spring.datasource.primary")
    public DataSource primaryDataSource() {
        return DataSourceBuilder.create().build();
    }

    /*
    * import org.springframework.boot.orm.jpa.EntityManagerFactoryBuilder;
    * EntityManagerFactoryBuilder 는 EntityManagerFactory 생성 도구.
    * EntityManagerFactory 는 JPA에서 데이터베이스와 상호작용하는 객체, EntityManager를 생성하는 팩토리.
    * LocalContainerEntityManagerFactoryBean는 EntityManagerFactory를 생성하고 관리하는 역할,
    * DB 에 맞는 설정들을 적용하고 JPA 프로바이더(Hibernate)를 구성할 수 있다.
    */
    @Primary
    @Bean(name = "primaryEntityManagerFactory")
    public LocalContainerEntityManagerFactoryBean primaryEntityManagerFactory(
            EntityManagerFactoryBuilder builder, @Qualifier("primaryDataSource") DataSource dataSource) {

        Map<String, Object> jpaProperties = new HashMap<>();
        jpaProperties.put("hibernate.hbm2ddl.auto", "validate");  // ddl-auto 설정

        //dataSource DB URL, USER, PASSWD 정보 포함.
        return builder.dataSource(dataSource)
                //entity들 위치.
                .packages("com.demo.domain.entity")
                //각 DB 구분 하느 역할, 트랜잭션 독립 처리 할 수 있도록 해준다.
                .persistenceUnit("primary")
                .properties(jpaProperties)
                .build();
    }

    /*
    * PlatformTransactionManager 트랜잭션 관리를 일관되게 처리.
    * JDBC : DataSourceTransactionManager,
    * JPA : JpaTransactionManager,
    * JTA(분산) : JtaTransactionManager
    * 트랜잭션 관리등 다양한 트랜잭션 리소스와 연동하여 사용 가능.
    *
    * @Transactional은 PlatformTransactionManager를 통해 트랜잭션을 시작하고 커밋, 롤백하는 매커니즘 제공.
    * */

    @Primary
    @Bean(name = "primaryTransactionManager")
    public PlatformTransactionManager primaryTransactionManager(
            @Qualifier("primaryEntityManagerFactory") EntityManagerFactory entityManagerFactory) {
        return new JpaTransactionManager(entityManagerFactory);
    }
}
