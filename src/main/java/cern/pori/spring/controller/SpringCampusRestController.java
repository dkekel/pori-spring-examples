package cern.pori.spring.controller;

import cern.pori.spring.model.SpringCampusEntity;
import cern.pori.spring.service.SpringCampusService;
import java.util.List;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/campus")
class SpringCampusRestController {

  private final SpringCampusService springCampusService;

  public SpringCampusRestController(SpringCampusService springCampusService) {
    this.springCampusService = springCampusService;
  }

  // Create
  @PostMapping
  public ResponseEntity<SpringCampusEntity> createEntity(@RequestBody SpringCampusEntity entity) {
    SpringCampusEntity savedEntity = springCampusService.saveEntity(entity);
    return new ResponseEntity<>(savedEntity, HttpStatus.CREATED);
  }

  // Read all
  @GetMapping
  public ResponseEntity<List<SpringCampusEntity>> getAllEntities() {
    List<SpringCampusEntity> entities = springCampusService.getAllEntities();
    return ResponseEntity.ok(entities);
  }

  // Read one
  @GetMapping("/{id}")
  public ResponseEntity<SpringCampusEntity> getEntityById(@PathVariable("id") Long id) {
    return springCampusService.getEntityById(id)
        .map(ResponseEntity::ok)
        .orElse(ResponseEntity.notFound().build());
  }

  // Update
  @PutMapping("/{id}")
  public ResponseEntity<SpringCampusEntity> updateEntity(@PathVariable("id") Long id,
      @RequestBody SpringCampusEntity entity) {
    return springCampusService.getEntityById(id)
        .map(existingEntity -> {
          entity.setId(id);
          SpringCampusEntity updatedEntity = springCampusService.saveEntity(entity);
          return ResponseEntity.ok(updatedEntity);
        })
        .orElse(ResponseEntity.notFound().build());
  }

  // Delete
  @DeleteMapping("/{id}")
  public ResponseEntity<Void> deleteEntity(@PathVariable("id") Long id) {
    return springCampusService.getEntityById(id)
        .map(entity -> {
          springCampusService.deleteEntity(id);
          return new ResponseEntity<Void>(HttpStatus.NO_CONTENT);
        })
        .orElse(ResponseEntity.notFound().build());
  }

  @PostMapping("/sample")
  public ResponseEntity<SpringCampusEntity> createSampleEntity() {
    SpringCampusEntity entity = springCampusService.createSampleEntity();
    SpringCampusEntity savedEntity = springCampusService.saveEntity(entity);
    return new ResponseEntity<>(savedEntity, HttpStatus.CREATED);
  }
}
