package com.chama.Chama.auth;

import com.chama.Chama.janitor.Janitor;
import com.chama.Chama.janitor.JanitorDto;

public interface AuthService {
    public abstract Janitor authorizeJanitor(JanitorDto janitor);
    public abstract Boolean authenticateJanitor(JanitorDto janitor);
}
