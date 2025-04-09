package cern.pori.spring.service;

import cern.pori.spring.model.DummyEntity;
import cern.pori.spring.model.SpringCampusEntity;
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

  public SpringCampusEntity createSpringCampusEntity() {
    SpringCampusEntity entity = new SpringCampusEntity();
    entity.setName(repository.getName());
    entity.setCity(repository.getCity());
    entity.setYearOpened(repository.getYearOpened());
    entity.setDescription(repository.getDescription());
    entity.setAddress(repository.getAddress());
    entity.setItems(repository.getItems());
    return entity;
  }
}
