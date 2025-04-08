package cern.pori.spring;

import cern.pori.spring.configuration.SpringConfiguration;
import cern.pori.spring.service.SpringService;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class SpringMain {

  public static void main(String[] args) {
    try (var context = new AnnotationConfigApplicationContext(SpringConfiguration.class)) {
      SpringService springService = context.getBean(SpringService.class);
      System.out.println(springService.getHello());
    }
  }
}
