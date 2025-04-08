package cern.pori.java.repository;

public class SmartRepository implements Repository {

  @Override
  public String getHello() {
    return "Hello Pori!";
  }
}
