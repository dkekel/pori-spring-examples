package cern.pori.spring.repository;

import java.time.LocalDate;
import org.springframework.stereotype.Repository;

@Repository
public class DummySpringCampusRepository implements SpringCampusRepository {

  @Override
  public String getHello() {
    return "Hello World!";
  }
}
