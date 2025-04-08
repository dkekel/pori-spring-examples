package cern.pori.java.service;

import cern.pori.java.repository.Repository;
import cern.pori.java.repository.SmartRepository;

public class DummyService {

  private final Repository repository;

  public DummyService() {
    this.repository = new SmartRepository();
  }

  public String getHello() {
    return repository.getHello();
  }
}
