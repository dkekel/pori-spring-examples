package cern.pori.spring.repository;

public class DummySpringRepository implements SpringRepository {

  @Override
  public String getHello() {
    return "Hello World!";
  }
}
