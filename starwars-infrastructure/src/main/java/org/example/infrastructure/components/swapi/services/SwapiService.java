package org.example.infrastructure.components.swapi.services;

import java.util.List;
import org.example.infrastructure.components.swapi.model.SwapiFilm;
import org.example.infrastructure.components.swapi.model.SwapiPerson;
import org.example.infrastructure.components.swapi.model.SwapiPlanet;
import org.example.infrastructure.components.swapi.model.SwapiTransport;

public interface SwapiService {

  List<SwapiPerson> fetchPeople(String name, Integer page);

  SwapiPlanet fetchHomeInfo(String id);

  List<SwapiFilm> fetchFilmsInfo(List<String> ids);

  SwapiTransport fetchFastestTransport(List<String> starshipsIds, List<String> vehicleIds);

}
