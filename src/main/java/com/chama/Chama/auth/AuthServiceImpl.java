package com.chama.Chama.auth;

import com.chama.Chama.janitor.Janitor;
import com.chama.Chama.janitor.JanitorDto;
import com.chama.Chama.janitor.JanitorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class AuthServiceImpl implements AuthService {
    @Autowired
    private JanitorRepository janitorRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Override
    public Janitor authorizeJanitor(JanitorDto janitorDto) {
        Janitor createdJanitor = new Janitor();
        createdJanitor.setEmail(janitorDto.getEmail());
        createdJanitor.setPassword(passwordEncoder.encode(janitorDto.getPassword()));
        return janitorRepository.save(createdJanitor);
    }

    @Override
    public Boolean authenticateJanitor(JanitorDto janitorDto) {
        Janitor janitor = null;
        if(janitorDto.getLogin().contains("@")) {
            janitor = janitorRepository.findByEmail(janitorDto.getLogin());
        } else {
            janitor = janitorRepository.findByUsername(janitorDto.getLogin());
        }
        return passwordEncoder.matches(janitor.getPassword(), janitorDto.getPassword());
    }
}
