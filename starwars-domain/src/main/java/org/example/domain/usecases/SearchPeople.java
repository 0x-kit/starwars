package org.example.domain.usecases;

import java.util.List;
import org.example.domain.commons.UseCase;
import org.example.domain.exceptions.InstanceNotFoundException;
import org.example.domain.model.Person;
import org.example.domain.respository.PeopleFetcher;

public class SearchPeople implements UseCase<SearchPeopleParams> {

  private final PeopleFetcher peopleFetcher;

  public SearchPeople(final PeopleFetcher peopleFetcher) {
    this.peopleFetcher = peopleFetcher;
  }

  @Override
  public List<Person> execute(SearchPeopleParams params) {
    List<Person> people = peopleFetcher.fetchByName(params.getName(), params.getPage());
    if (people.isEmpty()) {
      throw new InstanceNotFoundException(Person.class.getSimpleName(), "name", params.getName());
    }
    return people;
  }
}