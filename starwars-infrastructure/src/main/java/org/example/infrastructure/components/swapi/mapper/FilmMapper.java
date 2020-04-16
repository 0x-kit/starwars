package org.example.infrastructure.components.swapi.mapper;

import java.util.List;
import org.example.domain.model.Film;
import org.example.infrastructure.components.swapi.model.SwapiFilm;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.ReportingPolicy;
import org.mapstruct.factory.Mappers;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE, componentModel = "spring")
public interface FilmMapper {

  FilmMapper INSTANCE = Mappers.getMapper(FilmMapper.class);

  @Mapping(source = "title", target = "name")
  Film map(SwapiFilm swapifilm);

  List<Film> map(List<SwapiFilm> swapiFilms);
}

