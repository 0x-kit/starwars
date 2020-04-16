package org.example.domain.respository;

import java.util.List;
import org.example.domain.model.Person;

public interface PeopleFetcher {

  List<Person> fetchByName(String name, Integer page);

}