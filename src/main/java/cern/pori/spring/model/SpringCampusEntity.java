package cern.pori.spring.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.persistence.CollectionTable;
import jakarta.persistence.Column;
import jakarta.persistence.ElementCollection;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.Table;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "SPRING_CAMPUS")
public class SpringCampusEntity {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  private String name;
  private String city;
  @JsonFormat(pattern = "yyyy-MM-dd")
  @Column(name = "YEAR_OPENED")
  private LocalDate yearOpened;

  @Column(length = 1000)
  private String description;
  private String address;

  @ElementCollection(fetch = FetchType.EAGER)
  @CollectionTable(
      name = "SPRING_CAMPUS_ITEMS",
      joinColumns = @JoinColumn(name = "SPRING_CAMPUS_ID")
  )
  @Column(name = "ITEMS")
  private List<String> items = new ArrayList<>();

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

  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }
}
