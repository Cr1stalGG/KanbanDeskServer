package by.grsu.service;

import by.grsu.dto.security.AuthRequest;
import by.grsu.dto.security.AuthResponse;

public interface AuthenticationService {
    AuthResponse authenticate(AuthRequest request);
}
