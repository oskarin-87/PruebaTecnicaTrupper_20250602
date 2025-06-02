package com.trupper.technical.test.ordenes.compra.controller;

import com.trupper.technical.test.ordenes.compra.dto.LoginUserDto;
import com.trupper.technical.test.ordenes.compra.dto.RegisterUserDto;
import com.trupper.technical.test.ordenes.compra.entities.User;
import com.trupper.technical.test.ordenes.compra.service.AuthenticationService;
import com.trupper.technical.test.ordenes.compra.service.JwtService;
import com.trupper.technical.test.ordenes.compra.service.response.LoginResponse;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Create user registration and authentication routes
 * We can now create the routes /auth/signup and /auth/login for user registration and authentication, respectively.
 *
 */
@RequestMapping("/auth")
@RestController
public class AuthenticationController {
    private final JwtService jwtService;

    private final AuthenticationService authenticationService;

    public AuthenticationController(JwtService jwtService, AuthenticationService authenticationService) {
        this.jwtService = jwtService;
        this.authenticationService = authenticationService;
    }

    /**
     *
     * Register a new user, can be accessed without authentication
     *
     * @param registerUserDto
     * @return User
     */
    @PostMapping("/signup")
    public ResponseEntity<User> register(@RequestBody RegisterUserDto registerUserDto) {
        User registeredUser = authenticationService.signup(registerUserDto);

        return ResponseEntity.ok(registeredUser);
    }

    /**
     * Authenticate a user, can be accessed without authentication
     *
     * @param loginUserDto
     * @return LoginResponse
     */
    @PostMapping("/login")
    public ResponseEntity<LoginResponse> authenticate(@RequestBody LoginUserDto loginUserDto) {
        User authenticatedUser = authenticationService.authenticate(loginUserDto);

        String jwtToken = jwtService.generateToken(authenticatedUser);

        LoginResponse loginResponse = new LoginResponse();
        loginResponse.setToken(jwtToken);
        loginResponse.setExpiresIn(jwtService.getExpirationTime());
        return ResponseEntity.ok(loginResponse);
    }
}
