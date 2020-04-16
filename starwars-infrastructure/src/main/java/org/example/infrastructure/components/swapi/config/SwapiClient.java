package org.example.infrastructure.components.swapi.config;

import org.example.infrastructure.components.swapi.model.SwapiFilm;
import org.example.infrastructure.components.swapi.model.SwapiPerson;
import org.example.infrastructure.components.swapi.model.SwapiPlanet;
import org.example.infrastructure.components.swapi.model.SwapiResponse;
import org.example.infrastructure.components.swapi.model.SwapiTransport;

public interface SwapiClient {

  SwapiResponse<SwapiPerson> fetchPeopleByName(final String name, final Integer page);

  SwapiPlanet fetchPlanetById(final String id);

  SwapiTransport fetchStarShipById(String id);

  SwapiTransport fetchVehicleById(String id);

  SwapiFilm fetchFilmById(String id);
}

