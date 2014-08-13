package de.twt_gmbh.cube.configuration;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.context.annotation.ComponentScan;


@ComponentScan(basePackages = { "de.twt_gmbh.cube" })
@EnableAutoConfiguration
public class Application
{

  public static void main( final String[] args )
  {
    final SpringApplication application = new SpringApplicationBuilder( Application.class ).application();
    application.setAdditionalProfiles( "DEV" );
    application.run( args );
  }
}
