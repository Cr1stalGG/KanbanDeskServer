package by.grsu.service.impl;

import by.grsu.dto.mapper.AccountDtoMapper;
import by.grsu.dto.security.AuthRequest;
import by.grsu.dto.security.AuthResponse;
import by.grsu.entity.Account;
import by.grsu.exceptions.AuthException;
import by.grsu.repository.AccountRepository;
import by.grsu.security.configuration.AccountUserDetailsConfig;
import by.grsu.security.jwt.JwtService;
import by.grsu.service.AuthenticationService;
import by.grsu.utils.AuthStateParser;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class AuthenticationServiceImpl implements AuthenticationService {
    private final AccountRepository accountRepository;
    private final JwtService jwtService;
    private final AuthenticationManager authenticationManager;

    @Override
    public AuthResponse authenticate(AuthRequest request) {
        try {
            if(accountRepository.existsByLogin(request.getLogin().toLowerCase())) {
                authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(request.getLogin().toLowerCase(), request.getPassword()));

                Account account = Optional.ofNullable(accountRepository.findByLogin(request.getLogin().toLowerCase())).orElseThrow();

                var jwtToken = jwtService.generateToken(new AccountUserDetailsConfig(account));

                return AuthResponse.builder().token(jwtToken).build();
            } else {
                AuthStateParser.getAuthState(request.getLogin().toLowerCase(), request.getPassword());

                Account account = AccountDtoMapper.convertDtoToEntity(request);
                accountRepository.save(account);

                authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(request.getLogin().toLowerCase(), request.getPassword()));

                account = Optional.ofNullable(accountRepository.findByLogin(request.getLogin().toLowerCase())).orElseThrow();

                var jwtToken = jwtService.generateToken(new AccountUserDetailsConfig(account));

                return AuthResponse.builder().token(jwtToken).build();

            }

        } catch (AuthException e) {
            return AuthResponse.builder().token("invalid smth").build();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
