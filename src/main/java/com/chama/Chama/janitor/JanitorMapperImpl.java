package com.chama.Chama.janitor;

import org.mapstruct.Context;
import org.springframework.security.crypto.password.PasswordEncoder;

public abstract class JanitorMapperImpl implements JanitorMapper {
    @Override
    public Janitor toEntity(JanitorDto janitorDto, @Context PasswordEncoder passwordEncoder) {
        if (janitorDto == null) {
            return null;
        }
        Janitor janitor = new Janitor();
        janitor.setEmail(janitorDto.getEmail());
        janitor.setPassword(passwordEncoder.encode(janitorDto.getPassword()));
        return janitor;
    }
}
