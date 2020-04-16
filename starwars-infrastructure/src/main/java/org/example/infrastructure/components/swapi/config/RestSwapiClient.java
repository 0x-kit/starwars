package org.example.infrastructure.components.swapi.config;

import static java.util.Collections.singletonMap;
import static org.springframework.web.util.UriComponentsBuilder.fromHttpUrl;

import org.example.infrastructure.components.swapi.model.SwapiFilm;
import org.example.infrastructure.components.swapi.model.SwapiPerson;
import org.example.infrastructure.components.swapi.model.SwapiPlanet;
import org.example.infrastructure.components.swapi.model.SwapiResponse;
import org.example.infrastructure.components.swapi.model.SwapiTransport;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.stereotype.Service;

@Service
public class RestSwapiClient extends BaseRestTemplate implements SwapiClient {

  private static final Logger log = LoggerFactory.getLogger(SwapiClient.class);

  @Value("${swapi.url}")
  private String baseUrl;

  @Value("${swapi.endpoints.people}")
  private String peopleEndpoint;

  @Value("${swapi.endpoints.starships}")
  private String startshipsEndpoint;

  @Value("${swapi.endpoints.vehicles}")
  private String vehiclesEndpoint;

  @Value("${swapi.endpoints.films}")
  private String filmsEndpoint;

  @Value("${swapi.endpoints.planets}")
  private String planetsEndpoint;

  private String buildURL(String endpoint, String id) {
    return fromHttpUrl(baseUrl + endpoint).path("/{id}")
        .buildAndExpand(singletonMap("id", id))
        .toString();
  }

  @Override
  public SwapiResponse<SwapiPerson> fetchPeopleByName(final String name, final Integer page) {
    log.debug("fetchPeopleByName {}", name);
    String url = fromHttpUrl(baseUrl + peopleEndpoint)
        .queryParam("search", name)
        .queryParam("page", page)
        .toUriString();
    return get(url, new ParameterizedTypeReference<SwapiResponse<SwapiPerson>>() {
    });
  }

  @Override
  public SwapiPlanet fetchPlanetById(final String id) {
    log.debug("fetchPlanetById {}", id);
    return get(buildURL(planetsEndpoint, id), new ParameterizedTypeReference<SwapiPlanet>() {
    });
  }

  @Override
  public SwapiTransport fetchStarShipById(String id) {
    log.debug("fetchStarShipById {}", id);
    return get(buildURL(startshipsEndpoint, id), new ParameterizedTypeReference<SwapiTransport>() {
    });
  }

  @Override
  public SwapiTransport fetchVehicleById(String id) {
    log.debug("fetchVehicleById {}", id);
    return get(buildURL(vehiclesEndpoint, id), new ParameterizedTypeReference<SwapiTransport>() {
    });
  }

  @Override
  public SwapiFilm fetchFilmById(String id) {
    log.debug("fetchFilmById {}", id);
    return get(buildURL(filmsEndpoint, id), new ParameterizedTypeReference<SwapiFilm>() {
    });
  }
}
