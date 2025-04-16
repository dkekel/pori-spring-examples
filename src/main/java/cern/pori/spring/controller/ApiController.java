package cern.pori.spring.controller;

import cern.pori.spring.model.SpringCampusEntity;
import cern.pori.spring.service.SpringCampusService;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/public")
public class ApiController {

  private final SpringCampusService springCampusService;

  public ApiController(SpringCampusService springCampusService) {
    this.springCampusService = springCampusService;
  }

  @GetMapping(path = "/hello", produces = MediaType.APPLICATION_JSON_VALUE)
  public ResponseEntity<SpringCampusEntity> helloRest() {
    var helloEntity = springCampusService.createSpringCampusEntity();
    return ResponseEntity.ok(helloEntity);
  }
}
