package com.chama.Chama.janitor;

import org.mapstruct.Context;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.springframework.security.crypto.password.PasswordEncoder;

@Mapper(componentModel = "spring", uses = PasswordEncoder.class)
public interface JanitorMapper {
    @Mapping(target = "password", ignore = true)
    JanitorDto toDto(Janitor janitor);

    Janitor toEntity(JanitorDto janitorDto, @Context PasswordEncoder encoder);
}
