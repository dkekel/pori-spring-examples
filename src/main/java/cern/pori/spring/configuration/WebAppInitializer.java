package cern.pori.spring.configuration;

import jakarta.servlet.ServletContext;
import jakarta.servlet.ServletRegistration;
import org.springframework.web.WebApplicationInitializer;
import org.springframework.web.context.ContextLoaderListener;
import org.springframework.web.context.support.AnnotationConfigWebApplicationContext;
import org.springframework.web.servlet.DispatcherServlet;

public class WebAppInitializer implements WebApplicationInitializer {

  @Override
  public void onStartup(ServletContext servletContext) {
    // Create the root Spring application context
    AnnotationConfigWebApplicationContext rootContext = new AnnotationConfigWebApplicationContext();
    rootContext.register(SpringConfiguration.class);

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
  }
}