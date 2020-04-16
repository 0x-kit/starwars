package org.example.infrastructure.components.swapi.mapper;

import java.util.List;
import org.example.domain.model.Person;
import org.example.infrastructure.components.swapi.model.SwapiFilm;
import org.example.infrastructure.components.swapi.model.SwapiPerson;
import org.example.infrastructure.components.swapi.model.SwapiPlanet;
import org.example.infrastructure.components.swapi.model.SwapiTransport;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.ReportingPolicy;
import org.mapstruct.factory.Mappers;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE, componentModel = "spring", uses = {FilmMapper.class})
public interface PersonMapper {

  PersonMapper INSTANCE = Mappers.getMapper(PersonMapper.class);

  @Mapping(source = "swapiPerson.name", target = "name")
  @Mapping(source = "swapiPlanet.name", target = "planet_name")
  @Mapping(source = "swapiTransport.name", target = "fastest_vehicle_driven")
  @Mapping(source = "swapiFilms", target = "films")
  Person map(SwapiPerson swapiPerson, SwapiPlanet swapiPlanet, SwapiTransport swapiTransport, List<SwapiFilm> swapiFilms);

}
