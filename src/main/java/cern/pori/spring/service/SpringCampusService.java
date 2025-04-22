package cern.pori.spring.service;

import cern.pori.spring.model.DummyEntity;
import cern.pori.spring.model.SpringCampusEntity;
import cern.pori.spring.repository.SpringCampusRepository;
import org.springframework.security.access.prepost.PostAuthorize;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Component;
import java.time.LocalDate;

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

  @PreAuthorize("hasRole('USER')")
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

  // Only users with ROLE_ADMIN can access this method
  @PreAuthorize("hasRole('ADMIN')")
  public SpringCampusEntity getAdminSpringCampusEntity() {
    SpringCampusEntity entity = createSpringCampusEntity();
    entity.setName(entity.getName() + " (Admin Only)");
    entity.setDescription("This entity is available to admins only. " + entity.getDescription());
    return entity;
  }

  @PostAuthorize("returnObject.yearOpened.year >= 2020 or hasRole('ADMIN')")
  public SpringCampusEntity getCampusByYear(int year) {
    SpringCampusEntity entity = createSpringCampusEntity();
    // Override the year with the requested year
    LocalDate campusCreationDate = LocalDate.of(year, 1, 1);
    entity.setName(entity.getName().replaceAll("\\d{4}", String.valueOf(year)));
    entity.setYearOpened(campusCreationDate);
    entity.setDescription("This campus was established in " + year +
        ". Data for campuses before 2020 is restricted to administrators only. Date: "
        + campusCreationDate);
    return entity;
  }
}
