package de.twt_gmbh.cube.configuration.db;

import org.flywaydb.core.Flyway;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;


@Configuration
@Profile("PROD")
public class FlywayConfigurationProd
{

  public FlywayConfigurationProd()
  {
  }


  @Bean()
  @Autowired
  public Flyway flyway()
  {
    // no flyway in production mode
    return null;
  }
}
