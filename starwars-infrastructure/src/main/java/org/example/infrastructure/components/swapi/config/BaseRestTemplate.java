package org.example.infrastructure.components.swapi.config;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestClientException;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.server.ResponseStatusException;

@Service
public abstract class BaseRestTemplate {

  private static final Logger log = LoggerFactory.getLogger(BaseRestTemplate.class);

  private final RestTemplate restTemplate;

  @Value("${swapi.user-agent}")
  private String userAgent;

  public BaseRestTemplate() {
    this.restTemplate = new RestTemplate();
  }

  public <T> T get(String url, ParameterizedTypeReference<T> type) {
    ResponseEntity<T> responseEntity;
    try {
      responseEntity = restTemplate.exchange(url, HttpMethod.GET, new HttpEntity<>(buildHTTPHeaders()), type);
    } catch (RestClientException e) {
      log.error(e.getMessage());
      throw e;
    }
    HttpStatus statusCode = responseEntity.getStatusCode();

    if (statusCode == HttpStatus.OK) {
      return responseEntity.getBody();
    }

    log.error("Unexpected status code: {}", statusCode);
    throw new ResponseStatusException(statusCode);
  }

  private HttpHeaders buildHTTPHeaders() {
    // User-Agent to avoid 403
    final HttpHeaders httpHeaders = new HttpHeaders();
    httpHeaders.add(HttpHeaders.CONTENT_TYPE, MediaType.APPLICATION_JSON_VALUE);
    httpHeaders.set(HttpHeaders.USER_AGENT, userAgent);
    return httpHeaders;
  }

}

