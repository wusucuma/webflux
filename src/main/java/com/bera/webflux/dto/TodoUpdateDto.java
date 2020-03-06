package com.bera.webflux.dto;

import lombok.Builder;
import lombok.Getter;

@Getter
public class TodoUpdateDto {

  private Long id;

  private String content;

  private Boolean done;

  @Builder
  public TodoUpdateDto(Long id, String content, Boolean done) {
    this.id = id;
    this.content = content;
    this.done = done;
  }
}
