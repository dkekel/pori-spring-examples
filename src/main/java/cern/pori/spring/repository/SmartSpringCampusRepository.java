package cern.pori.spring.repository;

import java.time.LocalDate;
import org.springframework.stereotype.Repository;

@Repository
public class SmartSpringCampusRepository implements SpringCampusRepository {

  @Override
  public String getHello() {
    return "Hello PORI!";
  }

  @Override
  public String getName() {
    return "Spring Campus Pori 2025";
  }

  @Override
  public String getCity() {
    return "28130 Pori, Finland";
  }

  @Override
  public LocalDate getYearOpened() {
    return LocalDate.of(2025, 5, 5);
  }

  @Override
  public String getDescription() {
    return """
        The 2025 CERN Spring Campus is the ninth edition of a series of schools dedicated to Information Technology and Computing.
        This year, the school will take place in Pori Satakunta University of Applied Sciences between the 05th and the 09th of May 2025.
        """;
  }

  @Override
  public String getAddress() {
    return "Satakunnankatu 23";
  }
}
