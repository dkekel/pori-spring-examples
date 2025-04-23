package cern.pori.spring.service;

import cern.pori.spring.model.SpringCampusEntity;
import cern.pori.spring.repository.SpringCampusJpaRepository;
import cern.pori.spring.repository.SpringCampusRepository;
import java.time.Duration;
import java.time.LocalDate;
import java.util.List;
import java.util.Optional;
import org.springframework.security.access.prepost.PostAuthorize;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class SpringCampusService {

  private final SpringCampusRepository legacyRepository;
  private final SpringCampusJpaRepository jpaRepository;

  public SpringCampusService(SpringCampusRepository legacyRepository,
      SpringCampusJpaRepository jpaRepository) {
    this.legacyRepository = legacyRepository;
    this.jpaRepository = jpaRepository;
  }

  @PreAuthorize("hasRole('ADMIN')")
  public SpringCampusEntity createSampleEntity() {
    SpringCampusEntity entity = new SpringCampusEntity();
    entity.setName(legacyRepository.getName());
    entity.setCity(legacyRepository.getCity());
    entity.setYearOpened(legacyRepository.getYearOpened());
    entity.setDescription(legacyRepository.getDescription());
    entity.setAddress(legacyRepository.getAddress());
    entity.setItems(legacyRepository.getItems());
    return entity;
  }

  // Only users with ROLE_ADMIN can access this method
  @PreAuthorize("hasRole('ADMIN')")
  public SpringCampusEntity getAdminSpringCampusEntity() {
    SpringCampusEntity entity = createSampleEntity();
    entity.setName(entity.getName() + " (Admin Only)");
    entity.setDescription("This entity is available to admins only. " + entity.getDescription());
    return entity;
  }

  @PostAuthorize("returnObject.yearOpened.year >= 2020 or hasRole('ADMIN')")
  public SpringCampusEntity getCampusByYear(int year) {
    SpringCampusEntity entity = createSampleEntity();
    // Override the year with the requested year
    LocalDate campusCreationDate = LocalDate.of(year, 1, 1);
    entity.setName(entity.getName().replaceAll("\\d{4}", String.valueOf(year)));
    entity.setYearOpened(campusCreationDate);
    entity.setDescription("This campus was established in " + year +
        ". Data for campuses before 2020 is restricted to administrators only. Date: "
        + campusCreationDate);
    return entity;
  }

  // CRUD Operations

  // Create
  // Update
  @PreAuthorize("hasRole('ADMIN')")
  @Transactional
  public SpringCampusEntity saveEntity(SpringCampusEntity entity) {
    try {
      var result = jpaRepository.save(entity);
      Thread.sleep(Duration.ofSeconds(30));
      return result;
    } catch (InterruptedException ex) {
      throw new RuntimeException(ex);
    }
  }

  // Read
  @Transactional(readOnly = true)
  public List<SpringCampusEntity> getAllEntities() {
    return jpaRepository.findAll();
  }

  @Transactional(readOnly = true)
  public Optional<SpringCampusEntity> getEntityById(Long id) {
    return jpaRepository.findById(id);
  }

  // Delete
  @PreAuthorize("hasRole('ADMIN')")
  @Transactional(readOnly = true)
  public void deleteEntity(Long id) {
    jpaRepository.deleteById(id);
  }
}
