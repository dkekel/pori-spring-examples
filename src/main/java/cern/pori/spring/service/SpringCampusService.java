package cern.pori.spring.service;

import cern.pori.spring.model.DummyEntity;
import cern.pori.spring.repository.SpringCampusRepository;
import org.springframework.stereotype.Component;

@Component
public class SpringCampusService {

  private final SpringCampusRepository repository;

  public SpringCampusService(SpringCampusRepository repository) {
    this.repository = repository;
  }

  public DummyEntity getHelloEntity() {
    String helloMessage = repository.getHello();
    var items = repository.getItems();
    return new DummyEntity(helloMessage, items);
  }
}
