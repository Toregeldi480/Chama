package com.chama.Chama.controllers;

import com.chama.Chama.dtos.LoginUserDto;
import com.chama.Chama.dtos.RegisterUserDto;
import com.chama.Chama.entities.User;
import com.chama.Chama.services.AuthenticationService;
import com.chama.Chama.services.JwtService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping("/auth")
@RestController
public class AuthenticationController {
    private final JwtService jwtService;

    private final AuthenticationService authenticationService;

    public AuthenticationController(JwtService jwtService, AuthenticationService authenticationService) {
        this.jwtService = jwtService;
        this.authenticationService = authenticationService;
    }

    @PostMapping("/signup")
    public ResponseEntity<User> register(@RequestBody RegisterUserDto registerUserDto) {
        User registeredUser = authenticationService.signup(registerUserDto);

        return ResponseEntity.ok(registeredUser);
    }

    @PostMapping("/login")
    public ResponseEntity<LoginResponse> authenticate(@RequestBody LoginUserDto loginUserDto) {
        User authenticatedUser = authenticationService.authenticate(loginUserDto);

        String jwtToken = jwtService.generateToken(authenticatedUser);

        LoginResponse loginResponse = new LoginResponse();
        loginResponse.setToken(jwtToken);
        loginResponse.setExpiresIn(jwtService.getExpirationTime());

        return ResponseEntity.ok(loginResponse);
    }

    class LoginResponse {
        private String token;
        private long expiresIn;

        public String getToken() {
            return token;
        }
        public long getExpiresIn() {
            return expiresIn;
        }

        public void setToken(String token) {
            this.token = token;
        }
        public void setExpiresIn(long expiresIn) {
            this.expiresIn = expiresIn;
        }
    }
}
