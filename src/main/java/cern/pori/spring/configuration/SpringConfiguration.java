package cern.pori.spring.configuration;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * Spring MVC Configuration.
 * Most of the configuration is now handled by Spring Boot auto-configuration.
 * This class only contains custom configuration that extends the default behavior.
 */
@Configuration
public class SpringConfiguration implements WebMvcConfigurer {

  // Static resources configuration
  @Override
  public void addResourceHandlers(ResourceHandlerRegistry registry) {
    registry.addResourceHandler("/resources/**")
        .addResourceLocations("classpath:/resources/");
  }

}
