package com.chama.Chama.janitor;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.Size;
import lombok.Getter;

@Getter
public class JanitorDto {
    @Email private String email;
    @Size(min = 8) private String password;
}
