package cern.pori.spring.repository;

import java.util.List;

public interface SpringCampusRepository {

  String getHello();

  default List<String> getItems() {
    return List.of("Spring", "Spring MVC", "Spring Data", "Spring Boot");
  }
}
