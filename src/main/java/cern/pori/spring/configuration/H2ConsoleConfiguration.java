package cern.pori.spring.configuration;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * Configuration for H2 Console.
 * Spring Boot automatically enables and configures the H2 console based on application.properties.
 * This class only adds a convenient redirect from /h2 to /h2-console.
 */
@Configuration
public class H2ConsoleConfiguration implements WebMvcConfigurer {

    /**
     * Add a view controller for the H2 console.
     * This makes it easier to access the console from the browser.
     */
    @Override
    public void addViewControllers(ViewControllerRegistry registry) {
        // Add a redirect from /h2 to the H2 console
        registry.addRedirectViewController("/h2", "/h2-console");
    }
}
