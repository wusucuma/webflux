package com.bera.webflux.dto;

import lombok.Builder;
import lombok.Getter;

@Getter
public class TodoDto {

  private Long id;

  private Boolean done;

  private String content;

  @Builder
  public TodoDto(Long id, Boolean done, String content) {
    this.id = id;
    this.done = done;
    this.content = content;
  }
}
