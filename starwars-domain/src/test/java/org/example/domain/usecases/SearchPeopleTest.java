package org.example.domain.usecases;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.doReturn;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import org.assertj.core.util.Lists;
import org.example.domain.exceptions.InstanceNotFoundException;
import org.example.domain.model.Person;
import org.example.domain.respository.PeopleFetcher;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.ArgumentCaptor;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

@RunWith(MockitoJUnitRunner.class)
public class SearchPeopleTest {

  @Mock
  private PeopleFetcher peopleFetcher;

  @InjectMocks
  private SearchPeople searchPeople;

  @Test
  public void searchesPeople() {
    givenAnExistingPerson();

    searchPeople.execute(new SearchPeopleParams(onePerson().getName(), 7));

    ArgumentCaptor<String> nameArgument = ArgumentCaptor.forClass(String.class);
    ArgumentCaptor<Integer> pageArgument = ArgumentCaptor.forClass(Integer.class);

    verify(peopleFetcher, times(1)).fetchByName(nameArgument.capture(), pageArgument.capture());
    assertThat(nameArgument.getValue()).isEqualTo(onePerson().getName());
    assertThat(pageArgument.getValue()).isEqualTo(7);
  }

  @Test(expected = InstanceNotFoundException.class)
  public void throwsAnExceptionWhenPersonDoesNotExist() {
    givenANotExistingPerson();

    searchPeople.execute(new SearchPeopleParams("AnyName", null));
  }

  private void givenANotExistingPerson() {
    when(peopleFetcher.fetchByName(any(), any())).thenThrow(InstanceNotFoundException.class);
  }

  private void givenAnExistingPerson() {
    doReturn(Lists.newArrayList(onePerson())).when(peopleFetcher)
        .fetchByName(any(), any());
  }

  private Person onePerson() {
    Person person = new Person();
    person.setName("Luke");
    person.setGender("Male");
    return person;
  }


}
