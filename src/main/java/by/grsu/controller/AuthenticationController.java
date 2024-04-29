package by.grsu.controller;

import by.grsu.dto.security.AuthRequest;
import by.grsu.dto.security.AuthResponse;
import by.grsu.service.AuthenticationService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/auth")
@RequiredArgsConstructor
public class AuthenticationController {
    private final AuthenticationService authenticationService;

    @PostMapping("/login")
    public AuthResponse authenticate(@RequestBody AuthRequest request){
        return authenticationService.authenticate(request);
    }
}
