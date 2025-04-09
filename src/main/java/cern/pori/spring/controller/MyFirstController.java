package cern.pori.spring.controller;

import cern.pori.spring.model.DummyEntity;
import cern.pori.spring.service.SpringCampusService;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class MyFirstController {

  private final SpringCampusService springCampusService;

  public MyFirstController(SpringCampusService springCampusService) {
    this.springCampusService = springCampusService;
  }

  @GetMapping("/hello")
  public String hello(Model model) {
    var hello = springCampusService.createSpringCampusEntity();
    model.addAttribute("name", hello.getName());
    model.addAttribute("items", hello.getItems());
    model.addAttribute("description", hello.getDescription());
    model.addAttribute("city", hello.getCity());
    model.addAttribute("yearOpened", hello.getYearOpened());
    model.addAttribute("address", hello.getAddress());
    // Will look for templates/smart-hello.html
    return "smart-hello";
  }

  @GetMapping(path = "/api/hello", produces = MediaType.APPLICATION_JSON_VALUE)
  public ResponseEntity<DummyEntity> helloRest() {
    DummyEntity helloEntity = springCampusService.getHelloEntity();
    return ResponseEntity.ok(helloEntity);
  }
}
