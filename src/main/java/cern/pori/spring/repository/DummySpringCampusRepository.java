package cern.pori.spring.repository;

import java.time.LocalDate;

public class DummySpringCampusRepository implements SpringCampusRepository {

  @Override
  public String getHello() {
    return "Hello World!";
  }

  @Override
  public String getName() {
    throw new UnsupportedOperationException("Not supported yet.");
  }

  @Override
  public String getCity() {
    throw new UnsupportedOperationException("Not supported yet.");
  }

  @Override
  public LocalDate getYearOpened() {
    throw new UnsupportedOperationException("Not supported yet.");
  }

  @Override
  public String getDescription() {
    throw new UnsupportedOperationException("Not supported yet.");
  }

  @Override
  public String getAddress() {
    throw new UnsupportedOperationException("Not supported yet.");
  }
}
