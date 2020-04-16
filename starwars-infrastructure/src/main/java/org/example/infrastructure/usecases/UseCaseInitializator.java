package org.example.infrastructure.usecases;

import org.example.domain.respository.PeopleFetcher;
import org.example.domain.usecases.SearchPeople;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class UseCaseInitializator {

  private final PeopleFetcher peopleFetcher;

  public UseCaseInitializator(PeopleFetcher peopleFetcher) {
    this.peopleFetcher = peopleFetcher;
  }

  @Bean
  public SearchPeople searchPeople() {
    return new SearchPeople(peopleFetcher);
  }


}
