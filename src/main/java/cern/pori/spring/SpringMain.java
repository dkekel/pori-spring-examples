package cern.pori.spring;

import cern.pori.spring.configuration.SpringConfiguration;
import cern.pori.spring.service.SpringCampusService;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class SpringMain {

  public static void main(String[] args) {
    try (var context = new AnnotationConfigApplicationContext(SpringConfiguration.class)) {
      SpringCampusService springCampusService = context.getBean(SpringCampusService.class);
      System.out.println(springCampusService.getHelloEntity());
    }
  }
}
