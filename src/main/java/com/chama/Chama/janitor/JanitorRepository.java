package com.chama.Chama.janitor;

import org.springframework.data.jpa.repository.JpaRepository;

public interface JanitorRepository extends JpaRepository<Janitor, Long> {
  public Janitor findByUsername(String username);
  public Janitor findByEmail(String email);
}
