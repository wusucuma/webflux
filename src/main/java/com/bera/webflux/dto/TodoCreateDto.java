package com.bera.webflux.dto;

import lombok.Builder;
import lombok.Getter;

@Getter
public class TodoCreateDto {

  private String content;

  @Builder
  public TodoCreateDto(String content) {
    this.content = content;
  }
}
