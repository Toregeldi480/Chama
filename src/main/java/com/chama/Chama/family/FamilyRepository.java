package com.chama.Chama.family;

import org.springframework.data.jpa.repository.JpaRepository;

public interface FamilyRepository extends JpaRepository<Family, Long> {
  public Family getFamilyByName(String name);
}
