package com.cygnus.bookface;

import javax.persistence.EntityManagerFactory;
import javax.sql.DataSource;

// import org.hibernate.jpa.boot.spi.EntityManagerFactoryBuilder;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.boot.orm.jpa.EntityManagerFactoryBuilder;

@Configuration
@EnableTransactionManagement
@EnableJpaRepositories(
    entityManagerFactoryRef = "userEntityManagerFactory",
    transactionManagerRef = "userTransactionManager",
    basePackages = {
        "com.cygnus.bookface.userrepository"
    }
)

public class UserConfiguration {
    @Primary
    @Bean(name = "userDataSource")
    @ConfigurationProperties(prefix = "db2.datasource")
    public DataSource userDataSource() {
        return DataSourceBuilder.create().build();
    }

    @Primary
    @Bean(name = "userEntityManagerFactory")
    public LocalContainerEntityManagerFactoryBean
    entityManagerFactory(
        EntityManagerFactoryBuilder builder,
        @Qualifier("userDataSource") DataSource dataSource
    ) {
        return builder.dataSource(dataSource)
            .packages("com.cygnus.bookface")
            .persistenceUnit("db1")
            .build();
    }

    @Primary
    @Bean(name = "userTransactionManager")
    public PlatformTransactionManager userTransactionManager(
        @Qualifier("userEntityManagerFactory") EntityManagerFactory userEntityManagerFactory
    ) {
        return new JpaTransactionManager(userEntityManagerFactory);
    }
}
