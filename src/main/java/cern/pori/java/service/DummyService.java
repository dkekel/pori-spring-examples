package cern.pori.java.service;

import cern.pori.java.repository.DummyRepository;
import cern.pori.java.repository.Repository;

public class DummyService {

  private final Repository repository;

  public DummyService() {
    this.repository = new DummyRepository();
  }

  public String getHello() {
    return repository.getHello();
  }
}
