package com.chama.Chama.auth;

import com.chama.Chama.janitor.Janitor;
import com.chama.Chama.janitor.JanitorDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/auth")
public class AuthController {
    @Autowired
    private AuthService authService;

    @PostMapping("/login")
    public ResponseEntity<Boolean> authenticateJanitor(@RequestBody JanitorDto janitorDto) {
        return ResponseEntity.status(HttpStatus.OK).body(authService.authenticateJanitor(janitorDto));
    }

    @PostMapping("/register")
    public ResponseEntity<Janitor> authorizeJanitor(@RequestBody JanitorDto janitorDto) {
        return ResponseEntity.status(HttpStatus.OK).body(authService.authorizeJanitor(janitorDto));
    }
}
