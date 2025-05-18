package com.chama.Chama.janitor;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class JanitorDto {
    @Id
    private Long id;
    @Size(min = 8)
    private String password;
    private String email;
    private String username;
    private String login;
}
