package com.trupper.technical.test.ordenes.compra.service.impl;

import com.trupper.technical.test.ordenes.compra.advise.TrackExecutionTime;
import com.trupper.technical.test.ordenes.compra.dto.LoginUserDto;
import com.trupper.technical.test.ordenes.compra.dto.RegisterUserDto;
import com.trupper.technical.test.ordenes.compra.entities.User;
import com.trupper.technical.test.ordenes.compra.repository.UserRepository;
import com.trupper.technical.test.ordenes.compra.service.AuthenticationService;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

/**
 * Create the authentication service
 * This service will contain the logic for registering a new user and authenticating an existing user.
 *
 */
@Service
public class AuthenticationServiceImpl implements AuthenticationService {
    private final UserRepository userRepository;

    private final PasswordEncoder passwordEncoder;

    private final AuthenticationManager authenticationManager;

    public AuthenticationServiceImpl(
            UserRepository userRepository,
            AuthenticationManager authenticationManager,
            PasswordEncoder passwordEncoder
    ) {
        this.authenticationManager = authenticationManager;
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
    }

    /**
     * Registers a new user.
     *
     * @param input
     * @return
     */
    @TrackExecutionTime
    @Override
    public User signup(RegisterUserDto input) {
        User user = new User();
        user.setFullName(input.getFullName());
        user.setEmail(input.getEmail());
        user.setPassword(passwordEncoder.encode(input.getPassword()));
        return userRepository.save(user);
    }

    /**
     * Authenticates an existing user
     *
     * @param input
     * @return
     */
    @TrackExecutionTime
    @Override
    public User authenticate(LoginUserDto input) {
        authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(
                        input.getEmail(),
                        input.getPassword()
                )
        );

        return userRepository.findByEmail(input.getEmail())
                .orElseThrow();
    }
}
