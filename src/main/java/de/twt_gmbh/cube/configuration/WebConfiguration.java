package de.twt_gmbh.cube.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class WebConfiguration {

	@Bean
	public MvcConfigurer mvcConfigurer() {
		return new MvcConfigurer();
	}
}
