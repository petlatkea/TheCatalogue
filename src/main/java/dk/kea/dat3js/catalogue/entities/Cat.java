package dk.kea.dat3js.catalogue.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Cat {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private int id;
  private String name;
  private String country;
  private String claim_to_fame;
  private Integer birthyear;

  public Cat() {

  }

  public Cat(String name, String country, String claim_to_fame, Integer birthyear) {
    this.name = name;
    this.country = country;
    this.claim_to_fame = claim_to_fame;
    this.birthyear = birthyear;
  }

  public int getId() {
    return id;
  }

  public void setId(int id) {
    this.id = id;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public String getCountry() {
    return country;
  }

  public void setCountry(String country) {
    this.country = country;
  }

  public String getClaim_to_fame() {
    return claim_to_fame;
  }

  public void setClaim_to_fame(String claim_to_fame) {
    this.claim_to_fame = claim_to_fame;
  }

  public Integer getBirthyear() {
    return birthyear;
  }

  public void setBirthyear(Integer birthyear) {
    this.birthyear = birthyear;
  }

  @Override
  public String toString() {
    return "Cat{" +
        "id=" + id +
        ", name='" + name + '\'' +
        ", country='" + country + '\'' +
        ", claim_to_fame='" + claim_to_fame + '\'' +
        ", birthyear=" + birthyear +
        '}';
  }
}
