package com.chama.Chama.janitor;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Collection;

public interface JanitorService {
  public abstract Collection<Janitor> getJanitors();
  public abstract Janitor updateJanitor(Long id, Janitor janitor);
  public abstract void deleteJanitor(Long id);
}
