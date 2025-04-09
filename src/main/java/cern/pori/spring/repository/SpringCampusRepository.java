package cern.pori.spring.repository;

import java.time.LocalDate;
import java.util.List;

public interface SpringCampusRepository {

  String getHello();

  String getName();

  String getCity();

  LocalDate getYearOpened();

  String getDescription();

  String getAddress();

  default List<String> getItems() {
    return List.of("Spring", "Spring MVC", "Spring Data", "Spring Boot");
  }
}
