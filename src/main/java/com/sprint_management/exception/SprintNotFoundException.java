
package com.sprint_management.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class SprintNotFoundException extends RuntimeException {

  /**
   * Constructor con mensaje personalizado.
   *
   * @param message Mensaje que describe el error.
   */
  public SprintNotFoundException(String message) {
    super(message);
  }
}
