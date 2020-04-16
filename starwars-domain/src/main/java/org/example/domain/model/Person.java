package org.example.domain.model;

import java.util.List;
import lombok.Data;

@Data
public class Person {

  private String name;

  private String birth_year;

  private String gender;

  private String planet_name;

  private String fastest_vehicle_driven;

  private List<Film> films;
}
