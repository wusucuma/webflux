package com.bera.webflux.dto;

import lombok.Getter;
import lombok.ToString;

public class TodoRequestDto {

  @ToString
  @Getter
  public static class TodoCreate {
    private String content;
  }
}
