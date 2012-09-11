package com.thoughtworks.twu.persistence;

import com.thoughtworks.twu.domain.Country;
import com.thoughtworks.twu.domain.LocationPresences;
import org.hibernate.SessionFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseBuilder;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseType;
import org.springframework.orm.hibernate4.HibernateTransactionManager;
import org.springframework.orm.hibernate4.LocalSessionFactoryBuilder;

import javax.sql.DataSource;

public abstract class RepositoryContextConfiguration {

    private EmbeddedDatabaseBuilder builder;

    protected RepositoryContextConfiguration(String... sqls) {
        builder = new EmbeddedDatabaseBuilder()
                .setName(this.getClass().getName())
                .setType(EmbeddedDatabaseType.H2)
                .addScript("classpath:twu_database/schema.sql");
        for (String sql : sqls) {
            builder = builder.addScript(sql);
        }
    }

    @Bean
    public DataSource repoDataSource() {
        return builder.build();
    }

    @Bean
    public SessionFactory repoSessionFactory() {
        return new LocalSessionFactoryBuilder(repoDataSource())
                .addAnnotatedClass(Country.class)
                .addAnnotatedClass(LocationPresences.class).
                        buildSessionFactory();
    }

    @Bean
    public HibernateTransactionManager repoTransactionManager() {
        return new HibernateTransactionManager(repoSessionFactory());
    }
}
