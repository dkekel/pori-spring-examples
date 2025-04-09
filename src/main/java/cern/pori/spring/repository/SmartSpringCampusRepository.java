package cern.pori.spring.repository;

public class SmartSpringCampusRepository implements SpringCampusRepository {

  @Override
  public String getHello() {
    return "Hello PORI!";
  }
}
