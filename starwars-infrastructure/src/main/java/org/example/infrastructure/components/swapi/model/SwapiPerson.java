package org.example.infrastructure.components.swapi.model;

import static java.util.stream.Collectors.toList;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import java.util.List;
import lombok.AccessLevel;
import lombok.Data;
import lombok.Getter;

@JsonIgnoreProperties(ignoreUnknown = true)
@Data
public class SwapiPerson {

  private String name;

  private String birth_year;

  private String gender;

  @Getter(AccessLevel.NONE)
  private String homeworld;

  @Getter(AccessLevel.NONE)
  private List<String> starships;

  @Getter(AccessLevel.NONE)
  private List<String> vehicles;

  @Getter(AccessLevel.NONE)
  private List<String> films;

  private String getIdFromURL(String url) {
    return url.split("/")[5];
  }

  public String getHomeworld() {
    return this.getIdFromURL(homeworld);
  }

  public List<String> getStarships() {
    return starships.stream()
        .map(this::getIdFromURL)
        .collect(toList());
  }

  public List<String> getVehicles() {
    return vehicles.stream()
        .map(this::getIdFromURL)
        .collect(toList());
  }

  public List<String> getFilms() {
    return films.stream()
        .map(this::getIdFromURL)
        .collect(toList());
  }
}
