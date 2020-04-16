package org.example.infrastructure.components.swapi.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;

@JsonIgnoreProperties(ignoreUnknown = true)
@Data
public class SwapiTransport {

  private String name;

  private String max_atmosphering_speed;

}
