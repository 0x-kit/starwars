package org.example.domain.usecases;

import lombok.Getter;
import org.apache.commons.lang3.StringUtils;
import org.example.domain.commons.UseCaseParams;
import org.example.domain.exceptions.InvalidParamsException;

public class SearchPeopleParams implements UseCaseParams {

  public SearchPeopleParams(String name, Integer page) {
    this.name = name;
    this.page = page;
    validate();
  }

  @Getter
  private String name;

  @Getter
  private Integer page;

  @Override
  public void validate() {
    if (StringUtils.isEmpty(name)) {
      throw new InvalidParamsException("Name cannot be blank");
    }
  }
}
