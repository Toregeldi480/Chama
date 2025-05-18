package com.chama.Chama.janitor;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.List;

@Service
public class JanitorServiceImpl implements JanitorService {
    @Autowired
    private JanitorRepository janitorRepository;
    @Autowired
    private PasswordEncoder passwordEncoder;

    @Override
    public Collection<Janitor> getJanitors() {
        return janitorRepository.findAll();
    }

    @Override
    public Janitor updateJanitor(Long id, Janitor janitor) {
        Janitor updatedJanitor = janitorRepository.findById(id).orElseThrow(() -> new RuntimeException("User not found"));
        updatedJanitor.setUsername(janitor.getUsername());
        updatedJanitor.setName(janitor.getName());
        updatedJanitor.setSurname(janitor.getSurname());
        updatedJanitor.setEmail(janitor.getEmail());
        updatedJanitor.setPhone(janitor.getPhone());
        updatedJanitor.setPassword(passwordEncoder.encode(janitor.getPassword()));
        return janitorRepository.save(updatedJanitor);
    }

    @Override
    public void deleteJanitor(Long id) {
        janitorRepository.deleteById(id);
    }
}
