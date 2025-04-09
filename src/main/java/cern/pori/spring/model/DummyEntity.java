package cern.pori.spring.model;

import java.util.List;

public class DummyEntity {

  private final String message;
  private final List<String> items;

  public DummyEntity(String message, List<String> items) {
    this.message = message;
    this.items = items;
  }

  public String getMessage() {
    return message;
  }

  public List<String> getItems() {
    return items;
  }
}
