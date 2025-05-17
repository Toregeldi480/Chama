package com.chama.Chama.janitor;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class JanitorService {
  @Autowired
  private JanitorRepository janitorRepository;
  @Autowired
  private JanitorMapper janitorMapper;

  private final PasswordEncoder passwordEncoder;

  public JanitorService(PasswordEncoder passwordEncoder) {
    this.passwordEncoder = passwordEncoder;
  }

  public JanitorDto createJanitor(JanitorDto janitorDto) {
    Janitor janitor = janitorMapper.toEntity(janitorDto, passwordEncoder);
    Janitor savedJanitor = janitorRepository.save(janitor);
    return janitorMapper.toDto(savedJanitor);
  }

  public void updateJanitor(Janitor janitor) {
    if (janitorRepository.findById(janitor.getId()) != null) {
      janitorRepository.save(janitor);
    }
  }
}
