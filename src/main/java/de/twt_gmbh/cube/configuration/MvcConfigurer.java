package de.twt_gmbh.cube.configuration;

import org.springframework.http.MediaType;
import org.springframework.web.servlet.config.annotation.ContentNegotiationConfigurer;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;


@EnableWebMvc
public class MvcConfigurer extends WebMvcConfigurerAdapter
{

  @Override
  public void addViewControllers( final ViewControllerRegistry registry )
  {
    registry.addViewController( "/login" ).setViewName( "login" );
    registry.addViewController( "/" ).setViewName( "login" );
    registry.addViewController( "/vehicles" ).setViewName( "vehicles" );
  }


  @Override
  public void configureContentNegotiation( final ContentNegotiationConfigurer configurer )
  {
    configurer.favorPathExtension( true ).favorParameter( true ).parameterName( "mediaType" ).ignoreAcceptHeader( true )
            .useJaf( false ).defaultContentType( MediaType.TEXT_HTML ).mediaType( "xml", MediaType.APPLICATION_XML )
            .mediaType( "json", MediaType.APPLICATION_JSON ).mediaType( "html", MediaType.TEXT_HTML );
  }
}
