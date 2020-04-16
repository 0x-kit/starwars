package org.example.infrastructure.components.swapi.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;

@JsonIgnoreProperties(ignoreUnknown = true)
@Data
public class SwapiFilm {

  private String title;

  private String release_date;

}
