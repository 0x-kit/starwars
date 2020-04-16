package org.example.domain.exceptions;

public class InstanceNotFoundException extends RuntimeException {

  private static final long serialVersionUID = 1L;

  private final String className;

  private final String field;

  private final String value;

  public InstanceNotFoundException(String className, String field, String value) {
    super();
    this.className = className;
    this.field = field;
    this.value = value;
  }

  public String getMessage() {
    return new StringBuilder().append(className)
        .append(" with ")
        .append(field)
        .append(" '")
        .append(value)
        .append("' not found")
        .toString();
  }
}
