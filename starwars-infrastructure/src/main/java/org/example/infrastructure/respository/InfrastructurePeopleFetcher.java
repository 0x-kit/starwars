package org.example.infrastructure.respository;

import static java.util.stream.Collectors.toList;

import java.util.List;
import org.example.domain.model.Person;
import org.example.domain.respository.PeopleFetcher;
import org.example.infrastructure.components.swapi.mapper.PersonMapper;
import org.example.infrastructure.components.swapi.model.SwapiFilm;
import org.example.infrastructure.components.swapi.model.SwapiPerson;
import org.example.infrastructure.components.swapi.model.SwapiPlanet;
import org.example.infrastructure.components.swapi.model.SwapiTransport;
import org.example.infrastructure.components.swapi.services.SwapiService;
import org.springframework.stereotype.Service;

@Service
public class InfrastructurePeopleFetcher implements PeopleFetcher {

  private final SwapiService swapiService;

  private final PersonMapper personMapper;

  public InfrastructurePeopleFetcher(SwapiService swapiService, PersonMapper personMapper) {
    this.swapiService = swapiService;
    this.personMapper = personMapper;
  }

  @Override
  public List<Person> fetchByName(final String name, final Integer page) {
    return swapiService.fetchPeople(name, page)
        .stream()
        .map(this::fetchPersonInfo)
        .collect(toList());
  }

  private Person fetchPersonInfo(SwapiPerson swapiPerson) {
    SwapiPlanet swapiPlanet = swapiService.fetchHomeInfo(swapiPerson.getHomeworld());

    List<SwapiFilm> swapiFilms = swapiService.fetchFilmsInfo(swapiPerson.getFilms());

    SwapiTransport swapiTransport = swapiService.fetchFastestTransport(swapiPerson.getStarships(), swapiPerson.getVehicles());

    return personMapper.map(swapiPerson, swapiPlanet, swapiTransport, swapiFilms);
  }
}
