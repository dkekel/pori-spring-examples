package cern.pori.spring.configuration;

import jakarta.servlet.FilterRegistration;
import jakarta.servlet.ServletContext;
import jakarta.servlet.ServletRegistration;
import org.h2.server.web.JakartaWebServlet;
import org.springframework.web.WebApplicationInitializer;
import org.springframework.web.context.ContextLoaderListener;
import org.springframework.web.context.support.AnnotationConfigWebApplicationContext;
import org.springframework.web.filter.DelegatingFilterProxy;
import org.springframework.web.servlet.DispatcherServlet;

public class WebAppInitializer implements WebApplicationInitializer {

  @Override
  public void onStartup(ServletContext servletContext) {
    // Create the root Spring application context
    AnnotationConfigWebApplicationContext rootContext = new AnnotationConfigWebApplicationContext();
    rootContext.register(SpringConfiguration.class, JpaConfiguration.class);

    // Add the context loader listener
    servletContext.addListener(new ContextLoaderListener(rootContext));

    // Create the dispatcher servlet's Spring application context
    AnnotationConfigWebApplicationContext dispatcherContext = new AnnotationConfigWebApplicationContext();

    // Register and map the dispatcher servlet
    DispatcherServlet servlet = new DispatcherServlet(dispatcherContext);

    ServletRegistration.Dynamic registration = servletContext.addServlet("dispatcher",
        servlet);
    registration.setLoadOnStartup(1);
    registration.addMapping("/");

    // Register H2 Console Servlet
    ServletRegistration.Dynamic h2ConsoleServlet = servletContext.addServlet("h2-console",
        new JakartaWebServlet());
    h2ConsoleServlet.setLoadOnStartup(2);
    h2ConsoleServlet.addMapping("/h2-console/*");

    // Register Spring Security Filter
    FilterRegistration.Dynamic securityFilter = servletContext.addFilter(
        "springSecurityFilterChain", new DelegatingFilterProxy("springSecurityFilterChain"));
    securityFilter.addMappingForUrlPatterns(null, false, "/*");

  }
}
