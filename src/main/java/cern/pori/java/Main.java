package cern.pori.java;

import cern.pori.java.service.DummyService;

public class Main {

  public static void main(String[] args) {
    var dummyService = new DummyService();
    System.out.println(dummyService.getHello());
  }
}
