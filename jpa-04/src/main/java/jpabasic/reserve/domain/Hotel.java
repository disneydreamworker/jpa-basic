package jpabasic.reserve.domain;

import jakarta.persistence.*;

import java.time.LocalDateTime;

@Entity
@Table(name = "hotel_info")
public class Hotel {

  @Id
  @Column(name="hotel_id")
  private String id;

  @Column(name = "nm")
  private String name;

  private int year;

  @Enumerated(EnumType.STRING)
  private Grade grade;

  private LocalDateTime created;

  @Column(name = "modified")
  private LocalDateTime lastModified;


  //


  public Hotel(String id, String name, int year, Grade grade) {
    this.id = id;
    this.name = name;
    this.year = year;
    this.grade = grade;
  }

  public String getId() {
    return id;
  }

  public void setId(String id) {
    this.id = id;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public int getYear() {
    return year;
  }

  public void setYear(int year) {
    this.year = year;
  }

  public Grade getGrade() {
    return grade;
  }

  public void setGrade(Grade grade) {
    this.grade = grade;
  }

  public LocalDateTime getCreated() {
    return created;
  }

  public void setCreated(LocalDateTime created) {
    this.created = created;
  }

  public LocalDateTime getLastModified() {
    return lastModified;
  }

  public void setLastModified(LocalDateTime lastModified) {
    this.lastModified = lastModified;
  }

  @Override
  public String toString() {
    return "Hotel{" +
        "id='" + id + '\'' +
        ", name='" + name + '\'' +
        ", year=" + year +
        ", grade=" + grade +
        ", created=" + created +
        ", lastModified=" + lastModified +
        '}';
  }


}

