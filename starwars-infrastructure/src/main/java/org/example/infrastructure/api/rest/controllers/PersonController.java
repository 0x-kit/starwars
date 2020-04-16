package org.example.infrastructure.api.rest.controllers;

import java.util.List;
import org.example.domain.model.Person;
import org.example.domain.usecases.SearchPeople;
import org.example.domain.usecases.SearchPeopleParams;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/swapi-proxy")
public class PersonController {

  private final SearchPeople searchPeople;

  public PersonController(SearchPeople searchPeople) {
    this.searchPeople = searchPeople;
  }

  @GetMapping("/person-info")
  public ResponseEntity<List<Person>> personInfo(@RequestParam(value = "name") String name,
      @RequestParam(value = "page", required = false) Integer page) {
    return new ResponseEntity<>(searchPeople.execute(new SearchPeopleParams(name, page)),
        HttpStatus.OK);
  }
}