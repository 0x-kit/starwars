package org.example.infrastructure.components.swapi.model;

import java.util.List;
import lombok.Data;

@Data
public class SwapiResponse<T> {

  private int count;

  private String next;

  private String previous;

  private List<T> results;

}
