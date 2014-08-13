package de.twt_gmbh.cube.configuration;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.annotation.web.servlet.configuration.EnableWebMvcSecurity;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;


@Configuration
@EnableWebMvcSecurity
@EnableGlobalMethodSecurity(prePostEnabled = true)
public class SecurityConfiguration extends WebSecurityConfigurerAdapter
{

  @Override
  protected void configure( final HttpSecurity http ) throws Exception
  {
    http.authorizeRequests().anyRequest().authenticated();
    http.formLogin().failureUrl( "/login?error" ).defaultSuccessUrl( "/start", true ).loginPage( "/login" ).permitAll()
            .and().logout().logoutRequestMatcher( new AntPathRequestMatcher( "/logout" ) )
            .logoutSuccessUrl( "/login?logout" ).permitAll();
  }


  @Override
  protected void configure( final AuthenticationManagerBuilder auth ) throws Exception
  {
    auth.inMemoryAuthentication().withUser( "user" ).password( "password" ).roles( "USER" ).and().withUser( "admin" )
            .password( "adminpassword" ).roles( "ADMIN" );
  }
}
