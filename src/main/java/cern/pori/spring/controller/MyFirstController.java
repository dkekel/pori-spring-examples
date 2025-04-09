package cern.pori.spring.controller;

import cern.pori.spring.service.SpringCampusService;
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
    var hello = springCampusService.getHelloEntity();
    model.addAttribute("message", hello.getMessage());
    model.addAttribute("items", hello.getItems());
    // Will look for templates/hello.html
    return "hello";
  }

}
