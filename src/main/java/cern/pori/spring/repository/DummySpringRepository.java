package cern.pori.spring.repository;

import org.springframework.stereotype.Repository;

@Repository
public class DummySpringRepository implements SpringRepository {

  @Override
  public String getHello() {
    return "Hello World!";
  }
}
