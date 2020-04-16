package org.example.domain.commons;

public interface UseCase<T extends UseCaseParams> {

  Object execute(T params);

}