package de.twt_gmbh.cube.configuration;

import javax.persistence.EntityManagerFactory;
import javax.sql.DataSource;

import org.h2.jdbcx.JdbcDataSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.DependsOn;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.instrument.classloading.InstrumentationLoadTimeWeaver;
import org.springframework.orm.hibernate4.HibernateExceptionTranslator;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.Database;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import de.twt_gmbh.cube.configuration.db.H2ServerPublisher;


@Configuration
@EnableJpaRepositories(basePackages = { "de.twt_gmbh.cube.db" })
@EnableTransactionManagement
public class HibernateConfigurationDev
{
  @Bean
  public PlatformTransactionManager transactionManager()
  {
    final EntityManagerFactory factory = entityManagerFactory().getObject();
    return new JpaTransactionManager( factory );
  }


  @Bean
  @DependsOn("flyway")
  public LocalContainerEntityManagerFactoryBean entityManagerFactory()
  {
    final LocalContainerEntityManagerFactoryBean factory = new LocalContainerEntityManagerFactoryBean();

    final HibernateJpaVendorAdapter vendorAdapter = new HibernateJpaVendorAdapter();
    vendorAdapter.setDatabase( Database.H2 );
    vendorAdapter.setShowSql( Boolean.TRUE );

    factory.setDataSource( dataSource() );
    factory.setJpaVendorAdapter( vendorAdapter );
    factory.setPackagesToScan( "de.twt_gmbh.cube.model" );

    factory.afterPropertiesSet();
    factory.setLoadTimeWeaver( new InstrumentationLoadTimeWeaver() );
    return factory;
  }


  @Bean(initMethod = "start", destroyMethod = "stop")
  @DependsOn("entityManagerFactory")
  public H2ServerPublisher h2ServerInitializer()
  {
    return new H2ServerPublisher();
  }


  @Bean
  public HibernateExceptionTranslator hibernateExceptionTranslator()
  {
    return new HibernateExceptionTranslator();
  }


  @Bean
  public DataSource dataSource()
  {
    final JdbcDataSource dataSource = new JdbcDataSource();
    dataSource.setUrl( "jdbc:h2:mem:cube;DB_CLOSE_DELAY=-1" );
    dataSource.setUser( "sa" );
    dataSource.setPassword( "" );
    return dataSource;
  }
}
