package com.chama.Chama.janitor;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "janitor")
public class Janitor {
  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  private Long id;

  @Column(unique = true)
  private String email;

  @Column(unique = true)
  private String username;

  private String name;
  private String surname;
  private String password;
  private String phone;
}
