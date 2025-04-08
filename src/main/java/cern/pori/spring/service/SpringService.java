package cern.pori.spring.service;

import cern.pori.spring.repository.SpringRepository;
import org.springframework.stereotype.Component;

@Component
public class SpringService {

  private final SpringRepository repository;

  public SpringService(SpringRepository repository) {
    this.repository = repository;
  }

  public String getHello() {
    return repository.getHello();
  }
}
