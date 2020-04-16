package org.example.infrastructure.components.swapi.services;

import static java.lang.Integer.parseInt;
import static java.util.Comparator.comparing;
import static java.util.stream.Collectors.toList;

import java.util.Collection;
import java.util.List;
import java.util.stream.Stream;
import org.example.infrastructure.components.swapi.config.SwapiClient;
import org.example.infrastructure.components.swapi.model.SwapiFilm;
import org.example.infrastructure.components.swapi.model.SwapiPerson;
import org.example.infrastructure.components.swapi.model.SwapiPlanet;
import org.example.infrastructure.components.swapi.model.SwapiTransport;
import org.springframework.stereotype.Service;

@Service
public class RestSwapiService implements SwapiService {

  private final SwapiClient swapiClient;

  public RestSwapiService(SwapiClient swapiClient) {
    this.swapiClient = swapiClient;
  }

  @Override
  public List<SwapiPerson> fetchPeople(final String name, final Integer page) {
    return swapiClient.fetchPeopleByName(name, page)
        .getResults();
  }

  @Override
  public SwapiPlanet fetchHomeInfo(final String id) {
    return swapiClient.fetchPlanetById(id);
  }

  @Override
  public SwapiTransport fetchFastestTransport(List<String> starshipsIds, List<String> vehiclesIds) {
    List<SwapiTransport> starships = starshipsIds.stream()
        .map(swapiClient::fetchStarShipById)
        .collect(toList());

    List<SwapiTransport> vehicles = vehiclesIds.stream()
        .map(swapiClient::fetchVehicleById)
        .collect(toList());

    Stream<SwapiTransport> combinedVehicles = Stream.of(starships, vehicles)
        .flatMap(Collection::stream);

    return combinedVehicles.max(comparing(vehicle -> parseInt(vehicle.getMax_atmosphering_speed())))
        .orElse(null);
  }

  @Override
  public List<SwapiFilm> fetchFilmsInfo(List<String> ids) {
    return ids.stream()
        .map(swapiClient::fetchFilmById)
        .collect(toList());
  }

}