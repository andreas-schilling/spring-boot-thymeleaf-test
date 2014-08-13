package de.twt_gmbh.cube.configuration.db;

import javax.sql.DataSource;

import org.flywaydb.core.Flyway;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;


@Configuration
@Profile("DEV")
public class FlywayConfigurationDev
{

  public FlywayConfigurationDev()
  {
  }


  @Bean(initMethod = "migrate")
  @Autowired
  public Flyway flyway( final DataSource dataSource )
  {
    final Flyway flyway = new Flyway();
    flyway.setDataSource( dataSource );
    return flyway;
  }
}
