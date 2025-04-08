package cern.pori.java.repository;

public class DummyRepository implements Repository {

  @Override
  public String getHello() {
    return "Hello World!";
  }
}
