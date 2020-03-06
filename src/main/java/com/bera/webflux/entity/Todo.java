package com.bera.webflux.entity;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.PrePersist;
import java.time.LocalDateTime;

@NoArgsConstructor
@Getter
@Entity
public class Todo {

  @Id
  @Column(name = "todo_id")
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  @Setter
  @Column(nullable = false)
  private Boolean done;

  @Column(nullable = false)
  private String content;

  @CreationTimestamp private LocalDateTime createDate;

  @UpdateTimestamp private LocalDateTime updateDate;

  @PrePersist
  public void proPersist() {
    this.done = this.done == null ? false : true;
  }

  @Builder
  public Todo(String content) {
    this.content = content;
  }
}
