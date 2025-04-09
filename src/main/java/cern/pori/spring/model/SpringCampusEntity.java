package cern.pori.spring.model;

import java.time.LocalDate;
import java.util.List;

public class SpringCampusEntity {

  private String name;
  private String city;
  private LocalDate yearOpened;
  private String description;
  private String address;
  private List<String> items;

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public String getCity() {
    return city;
  }

  public void setCity(String city) {
    this.city = city;
  }

  public LocalDate getYearOpened() {
    return yearOpened;
  }

  public void setYearOpened(LocalDate yearOpened) {
    this.yearOpened = yearOpened;
  }

  public String getDescription() {
    return description;
  }

  public void setDescription(String description) {
    this.description = description;
  }

  public String getAddress() {
    return address;
  }

  public void setAddress(String address) {
    this.address = address;
  }

  public List<String> getItems() {
    return items;
  }

  public void setItems(List<String> items) {
    this.items = items;
  }
}
